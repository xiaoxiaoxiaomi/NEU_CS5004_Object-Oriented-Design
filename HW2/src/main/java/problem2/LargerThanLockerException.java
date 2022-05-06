package problem2;

/**
 * Signals an error when putting in an item which is larger than the locker
 */
public class LargerThanLockerException extends Exception {

  /**
   * Constructs a new LargerThanLockerException with the specified detail message
   *
   * @param message - the detail message
   */
  public LargerThanLockerException(String message) {
    super(message);
  }
}
