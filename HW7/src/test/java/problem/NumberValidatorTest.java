package problem;

import static java.lang.Double.NEGATIVE_INFINITY;
import static java.lang.Double.POSITIVE_INFINITY;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumberValidatorTest {

  NumberValidator testNumberValidator;

  @BeforeEach
  void setUp() {
    testNumberValidator = new NumberValidator(0.0, 10.0, 2);
  }

  @Test
  void testConstructor() {
    NumberValidator newNumberValidator = new NumberValidator();
    assertEquals(NEGATIVE_INFINITY, newNumberValidator.getMinValue());
    assertEquals(POSITIVE_INFINITY, newNumberValidator.getMaxValue());
    assertEquals(6, newNumberValidator.getMaxDecimalPlaces());
    Exception e = assertThrows(IllegalArgumentException.class, () -> {
          new NumberValidator(1.0, 0.0, 2);
        }
    );
    assertEquals("Maximum value should be at least minimum value", e.getMessage());
    e = assertThrows(IllegalArgumentException.class, () -> {
          new NumberValidator(0.0, 10.0, -1);
        }
    );
    assertEquals("Maximum number of decimal places should be at least 0", e.getMessage());
  }

  @Test
  void getMinValue() {
    assertEquals(0.0, testNumberValidator.getMinValue());
  }

  @Test
  void getMaxValue() {
    assertEquals(10.0, testNumberValidator.getMaxValue());
  }

  @Test
  void getMaxDecimalPlaces() {
    assertEquals(2, testNumberValidator.getMaxDecimalPlaces());
  }

  @Test
  void isValid() {
    assertFalse(testNumberValidator.isValid(null));
    assertFalse(testNumberValidator.isValid("3.-1"));
    assertFalse(testNumberValidator.isValid("3.000"));
    assertFalse(testNumberValidator.isValid("3.000"));
    assertFalse(testNumberValidator.isValid("-1"));
    assertFalse(testNumberValidator.isValid("11.0"));
    assertTrue(testNumberValidator.isValid("3.00"));
    assertTrue(testNumberValidator.isValid("3"));
  }

  @Test
  void testEquals() {
    assertTrue(testNumberValidator.equals(testNumberValidator));
    assertFalse(testNumberValidator.equals(null));
    assertFalse(testNumberValidator.equals("validator"));
    NumberValidator newNumberValidator = new NumberValidator(0.01, 10.0, 2);
    assertFalse(testNumberValidator.equals(newNumberValidator));
    newNumberValidator = new NumberValidator(0.0, 100.0, 2);
    assertFalse(testNumberValidator.equals(newNumberValidator));
    newNumberValidator = new NumberValidator(0.0, 10.0, 3);
    assertFalse(testNumberValidator.equals(newNumberValidator));
    newNumberValidator = new NumberValidator(0.0, 10.0, 2);
    assertTrue(testNumberValidator.equals(newNumberValidator));
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(0.0, 10.0, 2);
    assertEquals(expectedHashCode, testNumberValidator.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "NumberValidator{" +
        "minValue=" + 0.0 +
        ", maxValue=" + 10.0 +
        ", maxDecimalPlaces=" + 2 +
        '}';
    assertEquals(expectedString, testNumberValidator.toString());
  }
}