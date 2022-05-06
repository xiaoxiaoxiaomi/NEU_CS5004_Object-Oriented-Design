package problem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CheckBoxValidatorTest {

  CheckBoxValidator testCheckBoxValidator;

  @BeforeEach
  void setUp() {
    testCheckBoxValidator = new CheckBoxValidator();
  }

  @Test
  void isValid() {
    assertTrue(testCheckBoxValidator.isValid(false));
  }

  @Test
  void testToString() {
    String expectedString = "CheckBoxValidator{}";
    assertEquals(expectedString, testCheckBoxValidator.toString());
  }
}