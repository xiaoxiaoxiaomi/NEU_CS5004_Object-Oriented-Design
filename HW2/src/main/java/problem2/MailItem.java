package problem2;

/**
 * Class MailItem stores information about mail item - width, height, depth and recipient
 */
public class MailItem {

  private final Integer width;
  private final Integer height;
  private final Integer depth;
  private final Recipient recipient;

  /**
   * Constructor for the class MailItem
   *
   * @param width     - width in inches, an integer greater than or equal to 1
   * @param height    - height in inches, an integer greater than or equal to 1
   * @param depth     - depth in inches, an integer greater than or equal to 1
   * @param recipient - recipient, encoded as data type Recipient
   * @throws DimensionNumericException On non-positive number of dimension
   */
  public MailItem(Integer width, Integer height, Integer depth, Recipient recipient)
      throws DimensionNumericException {
    if (width < 1) {
      throw new DimensionNumericException("The width should be greater than or equal to 1");
    } else {
      this.width = width;
    }
    if (height < 1) {
      throw new DimensionNumericException("The height should be greater than or equal to 1");
    } else {
      this.height = height;
    }
    if (depth < 1) {
      throw new DimensionNumericException("The depth should be greater than or equal to 1");
    } else {
      this.depth = depth;
    }
    this.recipient = recipient;
  }

  /**
   * Getter for width
   *
   * @return - width in inches, an integer greater than or equal to 1
   */
  public Integer getWidth() {
    return this.width;
  }

  /**
   * Getter for height
   *
   * @return - height in inches, an integer greater than or equal to 1
   */
  public Integer getHeight() {
    return this.height;
  }

  /**
   * Getter for depth
   *
   * @return - depth in inches, an integer greater than or equal to 1
   */
  public Integer getDepth() {
    return this.depth;
  }

  /**
   * Getter for recipient
   *
   * @return - recipient, encoded as data type Recipient
   */
  public Recipient getRecipient() {
    return this.recipient;
  }
}
