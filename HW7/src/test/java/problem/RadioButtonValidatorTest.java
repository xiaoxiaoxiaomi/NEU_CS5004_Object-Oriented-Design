package problem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RadioButtonValidatorTest {

  RadioButtonValidator testRadioButtonValidator;

  @BeforeEach
  void setUp() {
    testRadioButtonValidator = new RadioButtonValidator();
  }

  @Test
  void isValid() {
    assertFalse(testRadioButtonValidator.isValid(null));
    assertTrue(testRadioButtonValidator.isValid(false));
  }

  @Test
  void testToString() {
    String expectedString = "RadioButtonValidator{}";
    assertEquals(expectedString, testRadioButtonValidator.toString());
  }
}