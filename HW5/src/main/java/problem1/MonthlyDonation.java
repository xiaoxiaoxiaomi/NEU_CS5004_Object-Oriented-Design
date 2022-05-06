package problem1;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Class MonthlyDonation inherits abstract class Donation and stores an amount, the date and time
 * that the donation was made and a cancellation date and time.
 */
public class MonthlyDonation extends Donation {

  private LocalDateTime cancellationDateTime;
  private static final Integer MONTHS_PER_YEAR = 12;

  /**
   * Constructor for class MonthlyDonation
   *
   * @param amount           - amount of donation, encoded as Double
   * @param creationDateTime - date and time that the donation was made, encoded as LocalDateTime
   */
  public MonthlyDonation(Double amount, LocalDateTime creationDateTime) {
    super(amount, creationDateTime);
    this.cancellationDateTime = null;
  }

  /**
   * Getter for cancellation date and time
   *
   * @return cancellation date and time, encoded as LocalDateTime
   */
  public LocalDateTime getCancellationDateTime() {
    return cancellationDateTime;
  }

  /**
   * Setter for cancellation date and time
   *
   * @param cancellationDateTime - cancellation date and time, encoded as LocalDateTime
   */
  public void setCancellationDateTime(LocalDateTime cancellationDateTime) {
    if (this.creationDateTime.isBefore(cancellationDateTime)) {
      this.cancellationDateTime = cancellationDateTime;
    } else {
      throw new DateTimeException(
          "The proposed cancellation should not be prior to the creation date and time.");
    }
  }

  /**
   * Indicates whether some other monthly donation is "equal to" this one.
   *
   * @param o - the reference object with which to compare.
   * @return true if this object is the same as the obj argument; false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    MonthlyDonation that = (MonthlyDonation) o;
    return Objects.equals(cancellationDateTime, that.cancellationDateTime);
  }

  /**
   * Returns a hash code value for the object.
   *
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), cancellationDateTime);
  }

  /**
   * Returns a string representation of the object.
   *
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "MonthlyDonation{" +
        "cancellationDateTime=" + cancellationDateTime +
        '}';
  }

  /**
   * Return the sum of all donations that occurred in the given year
   *
   * @param year - year, encoded as Integer
   * @return the sum of all donations that occurred in the given year
   */
  @Override
  public Double getTotalForYear(Integer year) {
    LocalDateTime start;
    if (this.creationDateTime.getYear() > year || (this.cancellationDateTime != null
        && this.cancellationDateTime.getYear() < year)) {
      return 0.0;
    } else if (this.creationDateTime.getYear() < year) {
      start = this.creationDateTime;
      while (start.getYear() < year) {
        start = start.plusMonths(1);
      }
    } else {
      start = this.creationDateTime;
    }
    if (this.cancellationDateTime == null || this.cancellationDateTime.getYear() > year) {
      return (MONTHS_PER_YEAR - start.getMonthValue() + 1) * amount;
    } else {
      int months = 0;
      while (start.isBefore(this.cancellationDateTime)) {
        months += 1;
        start = start.plusMonths(1);
      }
      return months * amount;
    }
  }
}
