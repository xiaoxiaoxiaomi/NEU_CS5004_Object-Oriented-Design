package problem2;

/**
 * Signals that a numeric error of dimension has occurred
 */
public class DimensionNumericException extends Exception {

  /**
   * Constructs a new DimensionNumericException with the specified detail message
   *
   * @param message - the detail message
   */
  public DimensionNumericException(String message) {
    super(message);
  }
}
