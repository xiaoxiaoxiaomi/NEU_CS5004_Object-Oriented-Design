package problem1;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CredentialsTest {
    private Credentials testCredentials;

    @BeforeEach
    void setUp() {
        testCredentials = new Credentials("Tara Bailey", "56ccf274c41db8e88832564852a858e266a0e6b73d833dd239b794144b7b900e");
    }

    @Test
    void getUsername() {
        assertEquals("Tara Bailey", testCredentials.getUsername());
    }

    @Test
    void setUsername() {
        testCredentials.setUsername("James Coleman");
        assertEquals("James Coleman", testCredentials.getUsername());
    }

    @Test
    void getPasswordHash() {
        assertEquals("56ccf274c41db8e88832564852a858e266a0e6b73d833dd239b794144b7b900e", testCredentials.getPasswordHash());
    }

    @Test
    void setPasswordHash() {
        testCredentials.setPasswordHash("1c8d59005425d86534ace0aae67bec4f");
        assertEquals("1c8d59005425d86534ace0aae67bec4f", testCredentials.getPasswordHash());
    }
}