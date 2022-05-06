package problem;

import static java.lang.Double.NEGATIVE_INFINITY;
import static java.lang.Double.POSITIVE_INFINITY;

import java.util.Objects;

/**
 * Class NumberValidator determines if the input meets the number requirements. The purpose of the
 * validator is to check that text entered by a user can be converted to the appropriate numeric
 * format.
 */
public class NumberValidator extends Validator<String> {

  private static final Double DEFAULT_MIN_VALUE = NEGATIVE_INFINITY;
  private static final Double DEFAULT_MAX_VALUE = POSITIVE_INFINITY;
  private static final Integer DEFAULT_MAX_DECIMAL_PLACES = 6;
  private static final Integer MIN_MAX_DECIMAL_PLACES = 0;
  private Double minValue;
  private Double maxValue;
  private Integer maxDecimalPlaces;

  /**
   * Default constructor of Class NumberValidator.
   */
  public NumberValidator() {
    this.minValue = DEFAULT_MIN_VALUE;
    this.maxValue = DEFAULT_MAX_VALUE;
    this.maxDecimalPlaces = DEFAULT_MAX_DECIMAL_PLACES;
  }

  /**
   * Constructor of Class NumberValidator.
   *
   * @param minValue         - minimum value, encoded as Double
   * @param maxValue         - maximum value, encoded as Double
   * @param maxDecimalPlaces - maximum number of decimal places allowed
   */
  public NumberValidator(Double minValue, Double maxValue, Integer maxDecimalPlaces) {
    if (maxValue < minValue) {
      throw new IllegalArgumentException("Maximum value should be at least minimum value");
    }
    if (maxDecimalPlaces < MIN_MAX_DECIMAL_PLACES) {
      throw new IllegalArgumentException("Maximum number of decimal places should be at least 0");
    }
    this.minValue = minValue;
    this.maxValue = maxValue;
    this.maxDecimalPlaces = maxDecimalPlaces;
  }

  /**
   * Getter for minimum value
   *
   * @return minimum value
   */
  public Double getMinValue() {
    return minValue;
  }

  /**
   * Getter for maximum value
   *
   * @return maximum value
   */
  public Double getMaxValue() {
    return maxValue;
  }

  /**
   * Getter for maximum number of decimal places
   *
   * @return maximum number of decimal places
   */
  public Integer getMaxDecimalPlaces() {
    return maxDecimalPlaces;
  }

  /**
   * Return true if the input is between the minimum value and maximum value, and the number of
   * decimal places is not larger than maximum number of decimal places allowed.
   *
   * @param input - input data, should be String
   * @return true if the input meets the number requirements, otherwise return false
   */
  @Override
  public boolean isValid(String input) {
    // check if the input is numeric
    if (input == null || !input.matches("-?\\d+(\\.\\d+)?")) {
      return false;
    }
    // if there is a dot, it should be a Double
    if (input.contains(".")) {
      String[] array = input.split("\\.");
      // check whether the number of decimal places is not larger than maximum number of decimal places allowed
      if (array[1].length() > this.maxDecimalPlaces) {
        return false;
      }
    }
    Double number = Double.valueOf(input);
    // check if the number is between the minimum value and maximum value
    return number >= this.minValue && number <= this.maxValue;
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
    NumberValidator that = (NumberValidator) o;
    return Objects.equals(minValue, that.minValue) && Objects.equals(maxValue,
        that.maxValue) && Objects.equals(maxDecimalPlaces, that.maxDecimalPlaces);
  }

  /**
   * Returns a hash code value for the object.
   *
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(minValue, maxValue, maxDecimalPlaces);
  }

  /**
   * Returns a string representation of the object.
   *
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "NumberValidator{" +
        "minValue=" + minValue +
        ", maxValue=" + maxValue +
        ", maxDecimalPlaces=" + maxDecimalPlaces +
        '}';
  }
}
