package problem;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PhoneValidatorTest {

  PhoneValidator testPhoneValidator;

  @BeforeEach
  void setUp() {
    testPhoneValidator = new PhoneValidator(10);
  }

  @Test
  void testConstructor() {
    PhoneValidator newPhoneValidator = new PhoneValidator();
    assertEquals(10, newPhoneValidator.getSpecifiedLength());
    Exception e = assertThrows(IllegalArgumentException.class, () -> {
          new PhoneValidator(0);
        }
    );
    assertEquals("Specified length should be at least 1", e.getMessage());
  }

  @Test
  void getSpecifiedLength() {
    assertEquals(10, testPhoneValidator.getSpecifiedLength());
  }

  @Test
  void isValid() {
    assertFalse(testPhoneValidator.isValid(null));
    assertFalse(testPhoneValidator.isValid("123456789#"));
    assertFalse(testPhoneValidator.isValid("123456789"));
    assertTrue(testPhoneValidator.isValid("1234567890"));
  }

  @Test
  void testEquals() {
    assertTrue(testPhoneValidator.equals(testPhoneValidator));
    assertFalse(testPhoneValidator.equals(null));
    assertFalse(testPhoneValidator.equals("validator"));
    PhoneValidator newPhoneValidator = new PhoneValidator(11);
    assertFalse(testPhoneValidator.equals(newPhoneValidator));
    newPhoneValidator = new PhoneValidator(10);
    assertTrue(testPhoneValidator.equals(newPhoneValidator));
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(10);
    assertEquals(expectedHashCode, testPhoneValidator.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "PhoneValidator{" +
        "specifiedLength=" + 10 +
        '}';
    assertEquals(expectedString, testPhoneValidator.toString());
  }
}