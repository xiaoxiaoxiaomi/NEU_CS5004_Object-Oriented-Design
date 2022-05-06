package problem;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FieldTest {

  PasswordValidator testPasswordValidator;
  Field testField1;
  CheckBoxValidator testCheckBoxValidator;
  Field testField2;

  @BeforeEach
  void setUp() {
    testPasswordValidator = new PasswordValidator(6, 10, 2, 2, 2);
    testField1 = new Field("password", true, testPasswordValidator);
    testCheckBoxValidator = new CheckBoxValidator();
    testField2 = new Field("label", false, testCheckBoxValidator);
  }

  @Test
  void getLabel() {
    assertEquals("password", testField1.getLabel());
  }

  @Test
  void getValue() {
    assertEquals(null, testField1.getValue());
  }

  @Test
  void getRequired() {
    assertEquals(true, testField1.getRequired());
  }

  @Test
  void getValidator() {
    assertEquals(testPasswordValidator, testField1.getValidator());
  }

  @Test
  void updateValue() throws InvalidInputException {
    Exception e = assertThrows(InvalidInputException.class, () -> {
      testField1.updateValue("aB1");
    });
    assertEquals("This input is not valid according to the validator", e.getMessage());
    testField1.updateValue("aaBB11");
    assertEquals("aaBB11", testField1.getValue());
    testField2.updateValue(false);
    assertEquals(false, testField2.getValue());
  }

  @Test
  void isFilled() throws InvalidInputException {
    assertFalse(testField1.isFilled());
    testField1.updateValue("aaBB11");
    assertTrue(testField1.isFilled());
    assertTrue(testField2.isFilled());
  }

  @Test
  void testEquals() throws InvalidInputException {
    assertTrue(testField1.equals(testField1));
    assertFalse(testField1.equals(null));
    assertFalse(testField1.equals(testPasswordValidator));
    Field newField = new Field("username", true, testPasswordValidator);
    assertFalse(testField1.equals(newField));
    newField = new Field("password", false, testPasswordValidator);
    assertFalse(testField1.equals(newField));
    newField = new Field("password", true, testCheckBoxValidator);
    assertFalse(testField1.equals(newField));
    newField = new Field("password", true, testPasswordValidator);
    assertTrue(testField1.equals(newField));
    newField.updateValue("aaBB11");
    assertFalse(testField1.equals(newField));
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash("password", null, true, testPasswordValidator);
    assertEquals(expectedHashCode, testField1.hashCode());
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
    expectedString = "Field{" +
        "label='" + "password" + '\'' +
        ", value=" + null +
        ", required=" + true +
        ", validator=" + expectedString +
        '}';
    assertEquals(expectedString, testField1.toString());
  }
}