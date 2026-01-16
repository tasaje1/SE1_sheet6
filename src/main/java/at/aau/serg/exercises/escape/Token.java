package at.aau.serg.exercises.escape;

import java.time.Instant;
import java.util.Objects;

public final class Token {
    private final String code;
    private final Instant expiresAt;

    public Token(String code, Instant expiresAt) {
        this.code = Objects.requireNonNull(code, "code");
        this.expiresAt = Objects.requireNonNull(expiresAt, "expiresAt");
    }

    public String getCode() {
        return code;
    }

    public Instant getExpiresAt() {
        return expiresAt;
    }

    public boolean isExpiredAt(Instant now) {
        return now.isAfter(expiresAt);
    }
}
