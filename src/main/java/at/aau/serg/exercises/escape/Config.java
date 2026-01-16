package at.aau.serg.exercises.escape;

import java.time.Duration;
import java.util.Objects;

public final class Config {
    private final Duration codeTtl;
    private final int maxFailedAttempts;
    private final Duration lockoutDuration;

    public Config(Duration codeTtl, int maxFailedAttempts, Duration lockoutDuration) {
        this.codeTtl = Objects.requireNonNull(codeTtl, "codeTtl");
        this.lockoutDuration = Objects.requireNonNull(lockoutDuration, "lockoutDuration");
        if (codeTtl.isZero() || codeTtl.isNegative()) throw new IllegalArgumentException("codeTtl");
        if (maxFailedAttempts < 1) throw new IllegalArgumentException("maxFailedAttempts");
        if (lockoutDuration.isNegative()) throw new IllegalArgumentException("lockoutDuration");
        this.maxFailedAttempts = maxFailedAttempts;
    }

    public Duration getCodeTtl() {
        return codeTtl;
    }

    public int getMaxFailedAttempts() {
        return maxFailedAttempts;
    }

    public Duration getLockoutDuration() {
        return lockoutDuration;
    }
}
