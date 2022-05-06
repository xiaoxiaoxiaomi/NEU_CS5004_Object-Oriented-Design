package problem;

import java.util.HashMap;

/**
 * Class CheckBoxValidator determines if the input meets the checkbox requirements.
 */
public class CheckBoxValidator extends Validator<Boolean> {

  /**
   * Return true if the input is a Boolean.
   *
   * @param input - input data, should be Boolean
   * @return true if the input meets the checkbox requirements, otherwise return false
   */
  @Override
  public boolean isValid(Boolean input) {
    return true;
  }

  /**
   * Returns a string representation of the object.
   *
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "CheckBoxValidator{}";
  }
}
