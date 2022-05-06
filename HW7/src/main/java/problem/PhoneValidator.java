package problem;

import java.util.Objects;

/**
 * Class PhoneValidator determines if the input meets the phone requirements.
 */
public class PhoneValidator extends Validator<String> {

  private static final Integer DEFAULT_PHONE_LEN = 10;
  private static final Integer MIN_PHONE_LEN = 1;
  private Integer specifiedLength;

  /**
   * Default constructor of Class PhoneValidator.
   */
  public PhoneValidator() {
    this.specifiedLength = DEFAULT_PHONE_LEN;
  }

  /**
   * Constructor of Class PhoneValidator.
   *
   * @param specifiedLength - specified length supplied by client code, encoded as Integer
   */
  public PhoneValidator(Integer specifiedLength) {
    if (specifiedLength < MIN_PHONE_LEN) {
      throw new IllegalArgumentException("Specified length should be at least 1");
    }
    this.specifiedLength = specifiedLength;
  }

  /**
   * Getter for specified length supplied by client code
   *
   * @return specified length supplied by client code
   */
  public Integer getSpecifiedLength() {
    return specifiedLength;
  }

  /**
   * Return true if the input is a String that contains only digits and has the specified length.
   *
   * @param input - input data, should be String
   * @return true if the input meets the phone requirements, otherwise return false
   */
  @Override
  public boolean isValid(String input) {
    // determine whether the input contains only digits and has the specified length
    return input != null && input.matches("[0-9]+") && input.length() == this.specifiedLength;
  }

  /**
   * Indicates whether some other object is "equal to" this one.
   *
   * @param o - the reference object with which to compare.
   * @return true if this object is the same as the obj argument; false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PhoneValidator that = (PhoneValidator) o;
    return Objects.equals(specifiedLength, that.specifiedLength);
  }

  /**
   * Returns a hash code value for the object.
   *
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(specifiedLength);
  }

  /**
   * Returns a string representation of the object.
   *
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "PhoneValidator{" +
        "specifiedLength=" + specifiedLength +
        '}';
  }
}
