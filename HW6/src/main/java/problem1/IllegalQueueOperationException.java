package problem1;

/**
 * Signals an error calling operation on empty PQ
 */
public class IllegalQueueOperationException extends RuntimeException {

  /**
   * Constructs a new IllegalQueueOperationException with the specified detail message
   *
   * @param message - the detail message
   */
  public IllegalQueueOperationException(String message) {
    super(message);
  }
}
