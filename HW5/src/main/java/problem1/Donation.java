package problem1;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Abstract class Donation stores an amount and the date and time that the donation was made
 */
public abstract class Donation implements DonationInterface {

  /**
   * amount of donation, encoded as Double
   */
  protected Double amount;
  /**
   * date and time that the donation was made, encoded as LocalDateTime
   */
  protected LocalDateTime creationDateTime;

  /**
   * Constructor for the class Donation
   *
   * @param amount           - amount of donation, encoded as Double
   * @param creationDateTime - date and time that the donation was made, encoded as LocalDateTime
   */
  public Donation(Double amount, LocalDateTime creationDateTime) {
    this.amount = amount;
    this.creationDateTime = creationDateTime;
  }

  /**
   * Getter for amount
   *
   * @return amount of donation, encoded as Double
   */
  public Double getAmount() {
    return amount;
  }

  /**
   * Getter for creation
   *
   * @return - date and time that the donation was made, encoded as LocalDateTime
   */
  public LocalDateTime getCreationDateTime() {
    return creationDateTime;
  }

  /**
   * Indicates whether some other donation is "equal to" this one.
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
    Donation donation = (Donation) o;
    return Objects.equals(amount, donation.amount) && Objects.equals(
        creationDateTime, donation.creationDateTime);
  }

  /**
   * Returns a hash code value for the object.
   *
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(amount, creationDateTime);
  }

  /**
   * Returns a string representation of the object.
   *
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "Donation{" +
        "amount=" + amount +
        ", donationDateTime=" + creationDateTime +
        '}';
  }
}
