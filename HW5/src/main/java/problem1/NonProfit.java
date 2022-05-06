package problem1;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Class NonProfit tracks the organization’s name and a collection of all donations made to the
 * non-profit
 */
public class NonProfit {

  private String organizationName;
  private ArrayList<Donation> donationList;

  /**
   * Constructor for Class NonProfit
   *
   * @param organizationName - organization’s name, encoded as String
   * @param donationList     - a collection of all donations made to the non-profit, encoded as
   *                         ArrayList
   */
  public NonProfit(String organizationName, ArrayList<Donation> donationList) {
    this.organizationName = organizationName;
    this.donationList = donationList;
  }

  /**
   * Getter for the organization’s name
   *
   * @return the organization’s name, encoded as String
   */
  public String getOrganizationName() {
    return organizationName;
  }

  /**
   * Getter for list of all donations made to the non-profit
   *
   * @return a collection of all donations made to the non-profit, encoded as ArrayList
   */
  public ArrayList<Donation> getDonationList() {
    return donationList;
  }

  /**
   * Indicates whether some other object is "equal to" this one.
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
    NonProfit nonProfit = (NonProfit) o;
    Map<Donation, Long> map1 = donationList.stream().collect(
        Collectors.groupingBy(p -> p, Collectors.counting()));
    Map<Donation, Long> map2 = nonProfit.donationList.stream().collect(
        Collectors.groupingBy(p -> p, Collectors.counting()));
    return Objects.equals(organizationName, nonProfit.organizationName)
        && Objects.equals(map1, map2);
  }

  /**
   * Returns a hash code value for the object.
   *
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(organizationName, donationList.stream().collect(
        Collectors.groupingBy(p -> p, Collectors.counting())));
  }

  /**
   * Returns a string representation of the object.
   *
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "NonProfit{" +
        "organizationName='" + organizationName + '\'' +
        ", donationList=" + donationList +
        '}';
  }

  /**
   * Returns the sum of all donations processed in the specified year
   *
   * @param year - year, encoded as Integer
   * @return the sum of all donations processed in the specified year
   */
  public Double getTotalDonationsForYear(Integer year) {
    Double donationSum = 0.0;
    for (Donation d : donationList) {
      donationSum += d.getTotalForYear(year);
    }
    return donationSum;
  }
}
