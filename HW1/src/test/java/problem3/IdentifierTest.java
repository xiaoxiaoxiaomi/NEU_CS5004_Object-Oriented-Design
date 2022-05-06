package problem3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdentifierTest {
    private Identifier testIdentifier;

    @BeforeEach
    void setUp() {
        testIdentifier = new Identifier("Snow", 2017, "China");
    }

    @Test
    void getUsername() {
        assertEquals("Snow", testIdentifier.getUsername());
    }

    @Test
    void getYear() {
        assertEquals(2017, testIdentifier.getYear());
    }

    @Test
    void getCountry() {
        assertEquals("China", testIdentifier.getCountry());
    }
}