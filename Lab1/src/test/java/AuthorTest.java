import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthorTest {

    private Name testName;
    private Author testAuthor;

    @BeforeEach
    void setUp() {
        testName = new Name("Ruxue", "Jiang");
        testAuthor = new Author(testName, "jiang.rux@northeastern.edu", "WA, US");
    }

    @Test
    void getName() {
        Name expectedName = new Name("Ruxue", "Jiang");
        // assertEquals(expectedName, testAuthor.getName());
        assertEquals(expectedName.getFirstName(), testAuthor.getName().getFirstName());
        assertEquals(expectedName.getLastName(), testAuthor.getName().getLastName());
    }

    @Test
    void getEmail() {
        assertEquals("jiang.rux@northeastern.edu", testAuthor.getEmail());
    }

    @Test
    void getAddress() {
        assertEquals("WA, US", testAuthor.getAddress());
    }
}