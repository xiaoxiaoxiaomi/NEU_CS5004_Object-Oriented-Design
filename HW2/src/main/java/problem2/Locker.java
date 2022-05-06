package problem2;

/**
 * Class Locker stores information about locker - maximum width, maximum height, maximum depth and
 * mail item
 */
public class Locker {

  private final Integer maximumWidth;
  private final Integer maximumHeight;
  private final Integer maximumDepth;
  private MailItem mailItem;

  /**
   * Constructor for the class Locker
   *
   * @param maximumWidth  - maximum width in inches, an integer greater than or equal to 1
   * @param maximumHeight - maximum height in inches, an integer greater than or equal to 1
   * @param maximumDepth  - maximum depth in inches, an integer greater than or equal to 1
   * @throws DimensionNumericException On non-positive number of dimension
   */
  public Locker(Integer maximumWidth, Integer maximumHeight, Integer maximumDepth)
      throws DimensionNumericException {
    if (maximumWidth < 1) {
      throw new DimensionNumericException("The maximum width should be greater than or equal to 1");
    } else {
      this.maximumWidth = maximumWidth;
    }
    if (maximumHeight < 1) {
      throw new DimensionNumericException(
          "The maximum height should be greater than or equal to 1");
    } else {
      this.maximumHeight = maximumHeight;
    }
    if (maximumDepth < 1) {
      throw new DimensionNumericException("The maximum depth should be greater than or equal to 1");
    } else {
      this.maximumDepth = maximumDepth;
    }
    this.mailItem = null;
  }

  /**
   * Getter for maximum width
   *
   * @return - maximum width in inches, an integer greater than or equal to 1
   */
  public Integer getMaximumWidth() {
    return this.maximumWidth;
  }

  /**
   * Getter for maximum height
   *
   * @return - maximum height in inches, an integer greater than or equal to 1
   */
  public Integer getMaximumHeight() {
    return this.maximumHeight;
  }

  /**
   * Getter for maximum depth
   *
   * @return - maximum depth in inches, an integer greater than or equal to 1
   */
  public Integer getMaximumDepth() {
    return this.maximumDepth;
  }

  /**
   * Getter for mail item
   *
   * @return - the item stores in the locker, if any, otherwise, return null
   */
  public MailItem getMailItem() {
    return this.mailItem;
  }

  /**
   * Consumes a mail item and stores it in a locker with two exceptions: if the locker is occupied
   * or the mail item exceeds the dimensions of the locker
   *
   * @param newMailItem - a mail item to be added to the locker, encoded as a MailItem
   * @throws OccupiedLockerException   If the locker already contains a mail item
   * @throws LargerThanLockerException If any single dimension of the mail item is bigger than the
   *                                   locker
   */
  void addMail(MailItem newMailItem) throws OccupiedLockerException, LargerThanLockerException {
    if (this.mailItem != null) {
      throw new OccupiedLockerException("The locker is occupied!");
    } else if (newMailItem.getWidth() > this.maximumWidth
        || newMailItem.getHeight() > this.maximumHeight
        || newMailItem.getDepth() > this.maximumDepth) {
      throw new LargerThanLockerException("The mail item exceeds the dimensions of the locker!");
    } else {
      this.mailItem = newMailItem;
    }
  }

  /**
   * Takes a recipient and remove and return the mail item from the locker under the following
   * conditions: there is a mail item in the locker AND the recipient passed to pickupMail matches
   * the recipient of the mail item
   *
   * @param recipient - recipient to pickup mail item in the locker, encoded as a Recipient
   * @return - mail item
   * @throws EmptyLockerException         If there is no mail item in the locker
   * @throws RecipientNotMatchedException If the recipient passed to pickupMail does not match the
   *                                      recipient of the mail item
   */
  MailItem pickupMail(Recipient recipient)
      throws EmptyLockerException, RecipientNotMatchedException {
    if (this.mailItem == null) {
      throw new EmptyLockerException("There is no mail item in the locker!");
    } else if (this.mailItem.getRecipient() != recipient) {
      throw new RecipientNotMatchedException(
          "The recipient passed to pickupMail does not match the recipient of the mail item!");
    } else {
      return this.mailItem;
    }
  }
}
