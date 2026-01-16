package at.aau.serg.exercises.escape;

import java.time.Instant;
import java.util.Objects;

public final class AuditEvent {
    private final Instant timestamp;
    private final String action;
    private final String team;
    private final String details;

    public AuditEvent(Instant timestamp, String action, String team, String details) {
        this.timestamp = Objects.requireNonNull(timestamp, "timestamp");
        this.action = Objects.requireNonNull(action, "action");
        this.team = Objects.requireNonNull(team, "team");
        this.details = Objects.requireNonNull(details, "details");
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public String getAction() {
        return action;
    }

    public String getTeam() {
        return team;
    }

    public String getDetails() {
        return details;
    }
}
