package problem1;

/**
 * Signals an error the given index does not exist in the CourseCatalog
 */
public class InvalidIndexException extends Exception {

  /**
   * Constructs a new InvalidIndexException with the specified detail message
   *
   * @param message - the detail message
   */
  public InvalidIndexException(String message) {
    super(message);
  }
}
