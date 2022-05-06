package problem1;

/**
 * Signals that a numeric error of daily price has occurred
 */
public class DailyPriceNumericException extends Exception {

  /**
   * Constructs a new DailyPriceNumericException with the specified detail message
   *
   * @param message - the detail message
   */
  public DailyPriceNumericException(String message) {
    super(message);
  }
}
