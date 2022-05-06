package problem1;

import java.util.Objects;

/**
 * Class WindowCleaning is inherited from abstract class ExteriorService, it inherits property address,
 * property size, whether the service is carried out monthly, the number of services previously
 * carried out at the address, estimated hours and discount rate, and it stores number of floors.
 */
public class WindowCleaning extends ExteriorService {

  private final Integer numberOfFloors;

  private static final Integer MAX_NUMBER_OF_FLOORS = 3;
  private static final Double MORE_FLOOR_FEE_RATE = 0.05;

  /**
   * Constructor for class WindowCleaning
   *
   * @param propertyAddress      - property address, encoded as String
   * @param propertySize         - property size, encoded as enum, the size can be small, medium, or
   *                             large
   * @param isMonthly            -  whether the service is carried out monthly, encoded as Boolean
   * @param numberOfPastServices - the number of services previously carried out at the address,
   *                             encoded as Integer
   * @param numberOfFloors       - number of floors, encoded as Integer
   * @throws FloorsExceedException      On 4 or more floors
   * @throws FloorsNonPositiveException On non-positive floors
   */
  public WindowCleaning(String propertyAddress, PropertySize propertySize,
      Boolean isMonthly, Integer numberOfPastServices, Integer numberOfFloors)
      throws FloorsExceedException, FloorsNonPositiveException {
    super(propertyAddress, propertySize, isMonthly, numberOfPastServices);
    if (numberOfFloors > MAX_NUMBER_OF_FLOORS) {
      throw new FloorsExceedException(
          "It should not be possible to create a window cleaning service for a property with more than 3 floors.");
    }
    if (numberOfFloors <= 0) {
      throw new FloorsNonPositiveException(
          "It should not be possible to create a window cleaning service for a property with non-positive floors.");
    }
    this.numberOfFloors = numberOfFloors;
  }

  /**
   * Getter for number of floors
   *
   * @return number of floors, encoded as Integer
   */
  public Integer getNumberOfFloors() {
    return numberOfFloors;
  }

  /**
   * Indicates whether some other object is "equal to" this one.
   *
   * @param o the reference object with which to compare.
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
    WindowCleaning that = (WindowCleaning) o;
    return numberOfFloors.equals(that.numberOfFloors);
  }

  /**
   * Returns a hash code value for the object.
   *
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), numberOfFloors);
  }

  /**
   * Returns a string representation of the object.
   *
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "WindowCleaning{" +
        "numberOfFloors=" + numberOfFloors +
        '}';
  }

  /**
   * Calculate price for Window Cleaning
   *
   * @return price for Window Cleaning, as double
   */
  @Override
  public double calculatePrice() {
    if (this.numberOfFloors > 1) {
      return NonSpecialistService.BASE_RATE * this.estimatedHours * (1 + MORE_FLOOR_FEE_RATE)
          * (1 - this.discountRate);
    } else {
      return NonSpecialistService.BASE_RATE * this.estimatedHours * (1 - this.discountRate);
    }
  }
}
