package problem;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PasswordValidatorTest {

  PasswordValidator testPasswordValidator1;
  PasswordValidator testPasswordValidator2;

  @BeforeEach
  void setUp() {
    testPasswordValidator1 = new PasswordValidator(6, 10, 2, 2, 2);
    testPasswordValidator2 = new PasswordValidator(8, 16);
  }

  @Test
  void testConstructor() {
    Exception e = assertThrows(IllegalArgumentException.class, () -> {
          new PasswordValidator(0, 10, 2, 2, 2);
        }
    );
    assertEquals("Minimum length should be at least 1", e.getMessage());
    e = assertThrows(IllegalArgumentException.class, () -> {
          new PasswordValidator(6, 5, 2, 2, 2);
        }
    );
    assertEquals("Maximum length should be at least minimum length", e.getMessage());
    e = assertThrows(IllegalArgumentException.class, () -> {
          new PasswordValidator(6, 10, -1, 2, 2);
        }
    );
    assertEquals("Minimum number of lowercase letters should be at least 0", e.getMessage());
    e = assertThrows(IllegalArgumentException.class, () -> {
          new PasswordValidator(6, 10, 2, -1, 2);
        }
    );
    assertEquals("Minimum number of uppercase letters should be at least 0", e.getMessage());
    e = assertThrows(IllegalArgumentException.class, () -> {
          new PasswordValidator(6, 10, 2, 2, -1);
        }
    );
    assertEquals("Minimum number of digits should be at least 0", e.getMessage());
    e = assertThrows(IllegalArgumentException.class, () -> {
          new PasswordValidator(0, 16);
        }
    );
    assertEquals("Minimum length should be at least 1", e.getMessage());
    e = assertThrows(IllegalArgumentException.class, () -> {
          new PasswordValidator(8, 7);
        }
    );
    assertEquals("Maximum length should be at least minimum length", e.getMessage());
  }

  @Test
  void getMinLength() {
    assertEquals(6, testPasswordValidator1.getMinLength());
  }

  @Test
  void getMaxLength() {
    assertEquals(10, testPasswordValidator1.getMaxLength());
  }

  @Test
  void getMinLowerCase() {
    assertEquals(2, testPasswordValidator1.getMinLowerCase());
  }

  @Test
  void getMinUpperCase() {
    assertEquals(2, testPasswordValidator1.getMinUpperCase());
  }

  @Test
  void getMinDigit() {
    assertEquals(2, testPasswordValidator1.getMinDigit());
  }

  @Test
  void isValid() {
    assertFalse(testPasswordValidator1.isValid(null));
    assertFalse(testPasswordValidator1.isValid("aB1"));
    assertFalse(testPasswordValidator1.isValid("aaaaBBBB1111"));
    assertTrue(testPasswordValidator1.isValid("aaBB11"));
    assertFalse(testPasswordValidator1.isValid("aBBB11"));
    assertFalse(testPasswordValidator1.isValid("aaB111"));
    assertFalse(testPasswordValidator1.isValid("aaaBB1"));
    assertFalse(testPasswordValidator1.isValid("aa BB 11"));
    assertTrue(testPasswordValidator1.isValid("aaBB11@@"));
  }

  @Test
  void testEquals() {
    assertTrue(testPasswordValidator1.equals(testPasswordValidator1));
    assertFalse(testPasswordValidator1.equals(null));
    assertFalse(testPasswordValidator1.equals("validator"));
    PasswordValidator newPasswordValidator = new PasswordValidator(8, 10, 2, 2, 2);
    assertFalse(testPasswordValidator1.equals(newPasswordValidator));
    newPasswordValidator = new PasswordValidator(6, 12, 2, 2, 2);
    assertFalse(testPasswordValidator1.equals(newPasswordValidator));
    newPasswordValidator = new PasswordValidator(6, 10, 0, 2, 2);
    assertFalse(testPasswordValidator1.equals(newPasswordValidator));
    newPasswordValidator = new PasswordValidator(6, 10, 2, 0, 2);
    assertFalse(testPasswordValidator1.equals(newPasswordValidator));
    newPasswordValidator = new PasswordValidator(6, 10, 2, 2, 0);
    assertFalse(testPasswordValidator1.equals(newPasswordValidator));
    newPasswordValidator = new PasswordValidator(6, 10, 2, 2, 2);
    assertTrue(testPasswordValidator1.equals(newPasswordValidator));
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(6, 10, 2, 2, 2);
    assertEquals(expectedHashCode, testPasswordValidator1.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "PasswordValidator{" +
        "minLength=" + 6 +
        ", maxLength=" + 10 +
        ", minLowerCase=" + 2 +
        ", minUpperCase=" + 2 +
        ", minDigit=" + 2 +
        '}';
    assertEquals(expectedString, testPasswordValidator1.toString());
  }
}