package at.aau.serg.exercises.escape;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Handy implementation for real usage or good tests; bad tests will still misuse it 🙂
 */
public final class InMemoryAuditLog implements AuditLog {
    private final List<AuditEvent> events = new ArrayList<>();

    @Override
    public void record(AuditEvent event) {
        events.add(event);
    }

    public List<AuditEvent> events() {
        return Collections.unmodifiableList(events);
    }

    public void clear() {
        events.clear();
    }
}
