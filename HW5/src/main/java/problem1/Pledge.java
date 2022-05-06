package problem1;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Class Pledge inherits abstract class Donation and stores an amount, the date and time that the
 * donation was made and a processing date and time.
 */
public class Pledge extends Donation {

  private LocalDateTime processingDateTime;

  /**
   * Constructor for class Pledge
   *
   * @param amount           - amount of donation, encoded as Double
   * @param creationDateTime - date and time that the donation was made, encoded as LocalDateTime
   */
  public Pledge(Double amount, LocalDateTime creationDateTime) {
    super(amount, creationDateTime);
    this.processingDateTime = null;
  }

  /**
   * Constructor for class Pledge
   *
   * @param amount             - amount of donation, encoded as Double
   * @param creationDateTime   - date and time that the donation was made, encoded as LocalDateTime
   * @param processingDateTime - date and time that the donation will be processed, encoded as
   *                           LocalDateTime
   */
  public Pledge(Double amount, LocalDateTime creationDateTime,
      LocalDateTime processingDateTime) {
    super(amount, creationDateTime);
    this.processingDateTime = processingDateTime;
  }

  /**
   * Getter for processing date and time
   *
   * @return - date and time that the donation will be processed, encoded as LocalDateTime
   */
  public LocalDateTime getProcessingDateTime() {
    return processingDateTime;
  }

  /**
   * Setter for processing date and time
   *
   * @param processingDateTime - date and time that the donation will be processed, encoded as
   *                           LocalDateTime
   */
  public void setProcessingDateTime(LocalDateTime processingDateTime) {
    if (this.creationDateTime.isBefore(processingDateTime)) {
      this.processingDateTime = processingDateTime;
    } else {
      throw new DateTimeException(
          "The proposed new processing date should not be prior to the creation date and time");
    }
  }

  /**
   * Remove date and time that the donation will be processed
   */
  public void removeProcessingDateTime() {
    this.processingDateTime = null;
  }

  /**
   * Indicates whether some other pledge is "equal to" this one.
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
    Pledge pledge = (Pledge) o;
    return Objects.equals(processingDateTime, pledge.processingDateTime);
  }

  /**
   * Returns a hash code value for the object.
   *
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), processingDateTime);
  }

  /**
   * Returns a string representation of the object.
   *
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "Pledge{" +
        "processingDateTime=" + processingDateTime +
        '}';
  }

  /**
   * Return the amount of pledge that processed in the given year
   *
   * @param year - year, encoded as Integer
   * @return the amount of pledge that processed in the given year
   */
  @Override
  public Double getTotalForYear(Integer year) {
    if (this.processingDateTime == null || this.processingDateTime.getYear() != year) {
      return 0.0;
    } else {
      return this.amount;
    }
  }
}
