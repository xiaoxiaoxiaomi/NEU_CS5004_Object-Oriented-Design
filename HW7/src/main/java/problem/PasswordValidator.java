package problem;

import java.util.Objects;

/**
 * Class PasswordValidator determines if the input meets the password requirements.
 */
public class PasswordValidator extends Validator<String> {

  private static final Integer DEFAULT_MIN_LOWER = 0;
  private static final Integer DEFAULT_MIN_UPPER = 0;
  private static final Integer DEFAULT_MIN_DIGIT = 0;
  private static final Integer MIN_PASSWORD_LEN = 1;
  private Integer minLength;
  private Integer maxLength;
  private Integer minLowerCase;
  private Integer minUpperCase;
  private Integer minDigit;

  /**
   * Constructor of Class PasswordValidator.
   *
   * @param minLength    - minimum acceptable length, encoded as Integer
   * @param maxLength    - maximum acceptable length, encoded as Integer
   * @param minLowerCase - minimum number of lowercase letters that the password must contain,
   *                     encoded as Integer
   * @param minUpperCase - minimum number of uppercase letters that the password must contain,
   *                     encoded as Integer
   * @param minDigit     - minimum number of digits that the password must contain, encoded as
   *                     Integer
   */
  public PasswordValidator(Integer minLength, Integer maxLength, Integer minLowerCase,
      Integer minUpperCase, Integer minDigit) {
    if (minLength < MIN_PASSWORD_LEN) {
      throw new IllegalArgumentException("Minimum length should be at least 1");
    }
    if (maxLength < minLength) {
      throw new IllegalArgumentException("Maximum length should be at least minimum length");
    }
    if (minLowerCase < DEFAULT_MIN_LOWER) {
      throw new IllegalArgumentException(
          "Minimum number of lowercase letters should be at least 0");
    }
    if (minUpperCase < DEFAULT_MIN_UPPER) {
      throw new IllegalArgumentException(
          "Minimum number of uppercase letters should be at least 0");
    }
    if (minDigit < DEFAULT_MIN_DIGIT) {
      throw new IllegalArgumentException("Minimum number of digits should be at least 0");
    }
    this.minLength = minLength;
    this.maxLength = maxLength;
    this.minLowerCase = minLowerCase;
    this.minUpperCase = minUpperCase;
    this.minDigit = minDigit;
  }

  /**
   * Constructor of Class PasswordValidator without providing values for minLowerCase, minLowerCase
   * and minDigit(using default values).
   *
   * @param minLength - minimum acceptable length, encoded as Integer
   * @param maxLength - maximum acceptable length, encoded as Integer
   */
  public PasswordValidator(Integer minLength, Integer maxLength) {
    if (minLength < MIN_PASSWORD_LEN) {
      throw new IllegalArgumentException("Minimum length should be at least 1");
    }
    if (maxLength < minLength) {
      throw new IllegalArgumentException("Maximum length should be at least minimum length");
    }
    this.minLength = minLength;
    this.maxLength = maxLength;
    this.minLowerCase = DEFAULT_MIN_LOWER;
    this.minUpperCase = DEFAULT_MIN_UPPER;
    this.minDigit = DEFAULT_MIN_DIGIT;
  }

  /**
   * Getter for minimum acceptable length
   *
   * @return minimum acceptable length
   */
  public Integer getMinLength() {
    return minLength;
  }

  /**
   * Getter for maximum acceptable length
   *
   * @return maximum acceptable length
   */
  public Integer getMaxLength() {
    return maxLength;
  }

  /**
   * Getter for minimum number of lowercase letters
   *
   * @return minimum number of lowercase letters
   */
  public Integer getMinLowerCase() {
    return minLowerCase;
  }

  /**
   * Getter for minimum number of uppercase letters
   *
   * @return minimum number of uppercase letters
   */
  public Integer getMinUpperCase() {
    return minUpperCase;
  }

  /**
   * Getter for minimum number of digits
   *
   * @return minimum number of digits
   */
  public Integer getMinDigit() {
    return minDigit;
  }

  /**
   * Return true if the input meets the length requirements, contains at least the minimum number of
   * each character type and contains no space.
   *
   * @param input - input data, should be String
   * @return true if the input meets the password requirements, otherwise return false
   */
  @Override
  public boolean isValid(String input) {
    // return false if the password is null or does not meet the length requirements
    if (input == null || input.length() < this.minLength || input.length() > this.maxLength) {
      return false;
    }
    int lowerCaseCount = 0;
    int upperCaseCount = 0;
    int digitCount = 0;
    // count lower case & upper case & digit
    for (char c : input.toCharArray()) {
      if (Character.isLowerCase(c)) {
        lowerCaseCount++;
      } else if (Character.isUpperCase(c)) {
        upperCaseCount++;
      } else if (Character.isDigit(c)) {
        digitCount++;
      } else if (Character.isSpaceChar(c)) {
        return false;
      }
    }
    // determine whether lowerCaseCount, upperCaseCount, digitCount are within the boundary
    return lowerCaseCount >= this.minLowerCase && upperCaseCount >= this.minUpperCase
        && digitCount >= this.minDigit;
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
    PasswordValidator that = (PasswordValidator) o;
    return Objects.equals(minLength, that.minLength) && Objects.equals(maxLength,
        that.maxLength) && Objects.equals(minLowerCase, that.minLowerCase)
        && Objects.equals(minUpperCase, that.minUpperCase) && Objects.equals(
        minDigit, that.minDigit);
  }

  /**
   * Returns a hash code value for the object.
   *
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(minLength, maxLength, minLowerCase, minUpperCase, minDigit);
  }

  /**
   * Returns a string representation of the object.
   *
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "PasswordValidator{" +
        "minLength=" + minLength +
        ", maxLength=" + maxLength +
        ", minLowerCase=" + minLowerCase +
        ", minUpperCase=" + minUpperCase +
        ", minDigit=" + minDigit +
        '}';
  }
}
