package problem1;

/**
 * Signals an error when the number of floors is more than required.
 */
public class FloorsExceedException extends Exception {

  /**
   * Constructs a new FloorsExceedException with the specified detail message
   *
   * @param message - the detail message
   */
  public FloorsExceedException(String message) {
    super(message);
  }
}
