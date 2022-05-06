package problem;

/**
 * Class RadioButtonValidator determines if the input meets the radio button requirements.
 */
public class RadioButtonValidator extends Validator<Boolean> {

  /**
   * Return true if the input is not null and is a Boolean.
   *
   * @param input - input data, should be Boolean
   * @return true if the input meets the radio button requirements, otherwise return false
   */
  @Override
  public boolean isValid(Boolean input) {
    // input cannot be null
    return input != null;
  }

  /**
   * Returns a string representation of the object.
   *
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "RadioButtonValidator{}";
  }
}
