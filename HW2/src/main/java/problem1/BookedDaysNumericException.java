package problem1;

/**
 * Signals that a numeric error of booked days has occurred
 */
public class BookedDaysNumericException extends Exception {

  /**
   * Constructs a new BookedDaysNumericException with the specified detail message
   *
   * @param message - the detail message
   */
  public BookedDaysNumericException(String message) {
    super(message);
  }
}
