package at.aau.serg.exercises.escape;

import org.junit.jupiter.api.*;

import java.time.*;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class EscapeRoomSmellyTests {
    static EscapeRoomVault vault;
    static InMemoryAuditLog audit;

    static Clock clock = Clock.systemDefaultZone();
    static Random random = new Random();

    @BeforeAll
    static void init() {
        audit = new InMemoryAuditLog();

        Config cfg = new Config(Duration.ofSeconds(45), 3, Duration.ofSeconds(30));
        vault = new EscapeRoomVault(cfg, clock, random, audit);
    }

    @Test
    void test1() throws Exception {

        Token token = vault.issueToken("Team Rocket", "skull");
        boolean ok = vault.attemptUnlock("Team Rocket", token, token.getCode());

        assertTrue(audit.events().size() > 0);
    }

    @Test
    void giantEverythingTest() {
        Token token = vault.issueToken("Team A", "pharaoh");

        boolean a = vault.attemptUnlock("Team A", token, "WRONG");
        boolean b = vault.attemptUnlock("Team A", token, "ALSO WRONG");
        boolean c = vault.attemptUnlock("Team A", token, "NOPE");

        assertFalse(a);
        assertFalse(b);
        assertFalse(c);

        boolean d = vault.attemptUnlock("Team A", token, token.getCode());
        assertEquals(false, d);

        assertTrue(vault.failedAttempts() >= 0);
        assertNotNull(vault.lockoutUntil());
    }

    @Test
    void randomFuzz() {


        Token token = vault.issueToken("Team A", "tiger");

        boolean ok = vault.attemptUnlock("Team A", token, "WRONG-CODE");


    }

    @Test
    void testThrow() {
        try {
            vault.issueToken("", "skull");
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    void expiryTest() {
        Token expired = new Token("SKULL-0001", Instant.now().minusSeconds(1));
        boolean ok = vault.attemptUnlock("Team Z", expired, "SKULL-0001");
        assertTrue(ok || !ok);
    }

    @Test
    void auditStringChecks() {
        Token token = vault.issueToken("Team B", "skull");
        String details = audit.events().get(audit.events().size() - 1).getDetails();

        // Overspecified + weak checks
        assertTrue(details.contains("code=" + token.getCode()));
        assertTrue(details.contains("expiresAt="));
        assertTrue(details.length() > 10);
    }

    @AfterEach
    void teardown() {
    }
}
