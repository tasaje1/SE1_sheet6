package at.aau.serg.exercises.escape;

import java.time.Clock;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

import java.util.Collections;

/**
 * Escape-room vault controller.
 * - Injects Clock + Random for determinism
 * - Audit is an interface (no filesystem side effects)
 * - Clear state and rules
 */
public final class EscapeRoomVault {
    private final Config config;
    private final Clock clock;
    private final Random random;
    private final AuditLog audit;

    private int failedAttempts;
    private Instant lockoutUntil = Instant.EPOCH;

    public EscapeRoomVault(Config config, Clock clock, Random random, AuditLog audit) {
        this.config = Objects.requireNonNull(config, "config");
        this.clock = Objects.requireNonNull(clock, "clock");
        this.random = Objects.requireNonNull(random, "random");
        this.audit = Objects.requireNonNull(audit, "audit");
    }

    /**
     * Issues a code like "SKULL-0429" with expiry.
     */
    public Token issueToken(String teamName, String theme) {
        teamName = requireName(teamName, "teamName");
        theme = requireName(theme, "theme");

        String prefix = normalizeTheme(theme);
        int pin = random.nextInt(10_000);
        String code = prefix + "-" + String.format("%04d", pin);

        Instant now = clock.instant();
        Instant expiresAt = now.plus(config.getCodeTtl());

        audit.record(new AuditEvent(now, "ISSUE", teamName, "code=" + code + ", expiresAt=" + expiresAt));
        return new Token(code, expiresAt);
    }

    /**
     * Attempts to unlock:
     * - locked out => false
     * - expired token => false (counts as failed)
     * - correct code => true (resets failures)
     * - wrong code => false (counts as failed)
     */
    public boolean attemptUnlock(String teamName, Token token, String typedCode) {
        teamName = requireName(teamName, "teamName");
        Objects.requireNonNull(token, "token");
        typedCode = (typedCode == null) ? "" : typedCode.trim();

        Instant now = clock.instant();

        if (now.isBefore(lockoutUntil)) {
            audit.record(new AuditEvent(now, "DENY_LOCKOUT", teamName, "until=" + lockoutUntil));
            return false;
        }

        if (token.isExpiredAt(now)) {
            failedAttempts++;
            audit.record(new AuditEvent(now, "DENY_EXPIRED", teamName, "expected=" + token.getCode()));
            applyLockoutIfNeeded(now);
            return false;
        }

        if (token.getCode().equals(typedCode)) {
            failedAttempts = 0;
            audit.record(new AuditEvent(now, "ALLOW", teamName, "ok"));
            return true;
        }

        failedAttempts++;
        audit.record(new AuditEvent(now, "DENY_WRONG", teamName,
                "expected=" + token.getCode() + ", typed=" + typedCode));
        applyLockoutIfNeeded(now);
        return false;
    }

    public int failedAttempts() {
        return failedAttempts;
    }

    public Instant lockoutUntil() {
        return lockoutUntil;
    }

    private void applyLockoutIfNeeded(Instant now) {
        if (failedAttempts >= config.getMaxFailedAttempts()) {
            lockoutUntil = now.plus(config.getLockoutDuration());
        }
    }

    private static String normalizeTheme(String theme) {
        String p = theme.trim().toUpperCase(Locale.ROOT);
        return p.length() <= 8 ? p : p.substring(0, 8);
    }

    private static String requireName(String s, String name) {
        if (s == null || s.isBlank()) throw new IllegalArgumentException(name);
        return s;
    }
}
