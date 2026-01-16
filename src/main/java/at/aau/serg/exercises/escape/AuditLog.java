package at.aau.serg.exercises.escape;

public interface AuditLog {
    void record(AuditEvent event);
}
