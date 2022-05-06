package problem;

import java.util.Objects;

/**
 * Class FreeTextValidator determines if the input meets the free text requirements.
 */
public class FreeTextValidator extends Validator<String> {

  private static final Integer DEFAULT_LINES = 10;
  private static final Integer DEFAULT_CHAR_EACH_LINE = 20;
  private static final Integer MIN_LINES = 0;
  private static final Integer MIN_CHAR_EACH_LINE = 0;
  private Integer lines;
  private Integer charactersEachLine;

  /**
   * Default constructor of Class FreeTextValidator.
   */
  public FreeTextValidator() {
    this.lines = DEFAULT_LINES;
    this.charactersEachLine = DEFAULT_CHAR_EACH_LINE;
  }

  /**
   * Constructor of Class FreeTextValidator.
   *
   * @param lines              - the number of lines in the text field, encoded as Integer
   * @param charactersEachLine -  the number of characters allowed per line, encoded as Integer
   */
  public FreeTextValidator(Integer lines, Integer charactersEachLine) {
    if (lines < MIN_LINES) {
      throw new IllegalArgumentException("The number of lines should be at least 0");
    }
    if (charactersEachLine < MIN_CHAR_EACH_LINE) {
      throw new IllegalArgumentException("The number of characters per line should be at least 0");
    }
    this.lines = lines;
    this.charactersEachLine = charactersEachLine;
  }

  /**
   * Getter for the number of lines in the text field
   *
   * @return the number of lines in the text field
   */
  public Integer getLines() {
    return lines;
  }

  /**
   * Getter for the number of characters allowed per line
   *
   * @return the number of characters allowed per line
   */
  public Integer getCharactersEachLine() {
    return charactersEachLine;
  }

  /**
   * Return true if the input is no longer than the number of lines multiplied by the number of
   * characters allowed per line.
   *
   * @param input - input data, should be String
   * @return true if the input meets the free text requirements, otherwise return false
   */
  @Override
  public boolean isValid(String input) {
    // check if the text is no longer than the number of lines multiplied by the number of characters allowed per line
    return input != null && input.length() <= this.lines * this.charactersEachLine;
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
    FreeTextValidator that = (FreeTextValidator) o;
    return Objects.equals(lines, that.lines) && Objects.equals(charactersEachLine,
        that.charactersEachLine);
  }

  /**
   * Returns a hash code value for the object.
   *
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(lines, charactersEachLine);
  }

  /**
   * Returns a string representation of the object.
   *
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "FreeTextValidator{" +
        "lines=" + lines +
        ", charactersEachLine=" + charactersEachLine +
        '}';
  }
}
