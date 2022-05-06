package problem;

/**
 * Signals an error when the type of input is neither String nor Boolean or invalid according to the
 * validator.
 */
public class InvalidInputException extends Exception {

  /**
   * Constructs a new InvalidInputException with the specified detail message.
   *
   * @param message - the detail message
   */
  public InvalidInputException(String message) {
    super(message);
  }
}
