package problem;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FreeTextValidatorTest {

  FreeTextValidator testFreeTextValidator;

  @BeforeEach
  void setUp() {
    testFreeTextValidator = new FreeTextValidator(5, 10);
  }

  @Test
  void testConstructor() {
    FreeTextValidator newFreeTextValidator = new FreeTextValidator();
    assertEquals(10, newFreeTextValidator.getLines());
    assertEquals(20, newFreeTextValidator.getCharactersEachLine());
    Exception e = assertThrows(IllegalArgumentException.class, () -> {
          new FreeTextValidator(-1, 10);
        }
    );
    assertEquals("The number of lines should be at least 0", e.getMessage());
    e = assertThrows(IllegalArgumentException.class, () -> {
          new FreeTextValidator(5, -1);
        }
    );
    assertEquals("The number of characters per line should be at least 0", e.getMessage());
  }

  @Test
  void getLines() {
    assertEquals(5, testFreeTextValidator.getLines());
  }

  @Test
  void getCharactersEachLine() {
    assertEquals(10, testFreeTextValidator.getCharactersEachLine());
  }

  @Test
  void isValid() {
    assertFalse(testFreeTextValidator.isValid(null));
    assertFalse(
        testFreeTextValidator.isValid("#123456789#123456789#123456789#123456789#123456789#"));
    assertTrue(testFreeTextValidator.isValid("#123456789#123456789#123456789#123456789#123456789"));
  }

  @Test
  void testEquals() {
    assertTrue(testFreeTextValidator.equals(testFreeTextValidator));
    assertFalse(testFreeTextValidator.equals(null));
    assertFalse(testFreeTextValidator.equals("validator"));
    FreeTextValidator newFreeTextValidator = new FreeTextValidator(10, 10);
    assertFalse(testFreeTextValidator.equals(newFreeTextValidator));
    newFreeTextValidator = new FreeTextValidator(5, 20);
    assertFalse(testFreeTextValidator.equals(newFreeTextValidator));
    newFreeTextValidator = new FreeTextValidator(5, 10);
    assertTrue(testFreeTextValidator.equals(newFreeTextValidator));
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(5, 10);
    assertEquals(expectedHashCode, testFreeTextValidator.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "FreeTextValidator{" +
        "lines=" + 5 +
        ", charactersEachLine=" + 10 +
        '}';
    assertEquals(expectedString, testFreeTextValidator.toString());
  }
}