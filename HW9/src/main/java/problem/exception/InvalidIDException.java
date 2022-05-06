package problem.exception;

/**
 * Signals an error if the provided id does not exist
 */
public class InvalidIDException extends Exception {

  /**
   * Constructs a new InvalidIDException with the specified detail message
   *
   * @param message - the detail message
   */
  public InvalidIDException(String message) {
    super(message);
  }
}
