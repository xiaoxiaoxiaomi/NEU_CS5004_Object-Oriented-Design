package problem2;

/**
 * Signals an error when the recipient passed to pickupMail does not match the recipient of the mail
 * item
 */
public class RecipientNotMatchedException extends Exception {

  /**
   * Constructs a new RecipientNotMatchedException with the specified detail message
   *
   * @param message - the detail message
   */
  public RecipientNotMatchedException(String message) {
    super(message);
  }
}
