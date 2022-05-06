package problem1;

import java.time.LocalDateTime;

/**
 * Class OneTimeDonation inherits abstract class Donation and stores an amount and the date and time
 * that the donation was made.
 */
public class OneTimeDonation extends Donation {

  /**
   * Constructor for class OneTimeDonation
   *
   * @param amount           - amount of donation, encoded as Double
   * @param creationDateTime - date and time that the donation was made, encoded as LocalDateTime
   */
  public OneTimeDonation(Double amount, LocalDateTime creationDateTime) {
    super(amount, creationDateTime);
  }

  /**
   * Return the amount of one-time donation that occurred in the given year
   *
   * @param year - year, encoded as Integer
   * @return the amount of one-time donation that occurred in the given year
   */
  @Override
  public Double getTotalForYear(Integer year) {
    if (this.creationDateTime.getYear() == year) {
      return this.amount;
    } else {
      return 0.0;
    }
  }
}
