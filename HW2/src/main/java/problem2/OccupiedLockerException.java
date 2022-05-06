package problem2;

/**
 * Signals an error when putting in an item in an occupied locker
 */
public class OccupiedLockerException extends Exception {

  /**
   * Constructs a new OccupiedLockerException with the specified detail message
   *
   * @param message - the detail message
   */
  public OccupiedLockerException(String message) {
    super(message);
  }
}
