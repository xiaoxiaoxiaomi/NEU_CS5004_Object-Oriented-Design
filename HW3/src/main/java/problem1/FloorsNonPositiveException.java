package problem1;

/**
 * Signals an error when the number of floors is not positive
 */
public class FloorsNonPositiveException extends Exception {

  /**
   * Constructs a new FloorsNonPositiveException with the specified detail message
   *
   * @param message - the detail message
   */
  public FloorsNonPositiveException(String message) {
    super(message);
  }
}
