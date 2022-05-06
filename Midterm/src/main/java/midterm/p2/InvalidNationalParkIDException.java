package midterm.p2;

/**
 * Signals an error if the given unique ID does not exist
 */
public class InvalidNationalParkIDException extends Exception {

  /**
   * Constructs a new InvalidNationalParkIDException with the specified detail message
   * @param message - the detail message
   */
  public InvalidNationalParkIDException(String message) {
    super(message);
  }
}
