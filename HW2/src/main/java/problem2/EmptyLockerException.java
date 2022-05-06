package problem2;

/**
 * Signals an error when picking up from an empty locker
 */
public class EmptyLockerException extends Exception {

  /**
   * Constructs a new EmptyLockerException with the specified detail message
   *
   * @param message - the detail message
   */
  public EmptyLockerException(String message) {
    super(message);
  }
}
