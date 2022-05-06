package problem1;

/**
 * This is an interface for donation
 */
public interface DonationInterface {

  /**
   * Return the sum of donations processed in the specified year
   *
   * @param year - year, encoded as Integer
   * @return the sum of donations processed in the specified year
   */
  Double getTotalForYear(Integer year);
}
