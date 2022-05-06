package problem1;

/**
 * Class Car stores information about car - daily price, booked days, maximum occupancy, if it
 * requires a specialized driver’s license and if it allows different pick-up and drop-off
 * locations
 */
public class Car extends Vehicle {

  private static final int CAR_MAXIMUM_OCCUPANCY = 5;
  private static final boolean CAR_REQUIRE_SPECIALIZED_LICENSE = false;
  private static final boolean CAR_ALLOW_DIFFERENT_PICKUP_AND_DROPOFF_LOCATIONS = true;
  private final Integer maximumOccupancy;
  private final Boolean requireSpecializedLicense;
  private final Boolean allowDifferentPickupAndDropoffLocations;

  /**
   * Constructor for the class Car
   *
   * @param dailyPrice - the cost of a single day rental, encoded as Double
   * @param bookedDays - the number of days the vehicle has been rented out to a client, encoded as
   *                   Integer
   * @throws DailyPriceNumericException On non-positive dailyPrice
   * @throws BookedDaysNumericException On negative bookedDays
   */
  public Car(Double dailyPrice, Integer bookedDays)
      throws DailyPriceNumericException, BookedDaysNumericException {
    super(dailyPrice, bookedDays);
    this.maximumOccupancy = CAR_MAXIMUM_OCCUPANCY;
    this.requireSpecializedLicense = CAR_REQUIRE_SPECIALIZED_LICENSE;
    this.allowDifferentPickupAndDropoffLocations = CAR_ALLOW_DIFFERENT_PICKUP_AND_DROPOFF_LOCATIONS;
  }

  /**
   * Getter for maximum occupancy
   *
   * @return - the maximum occupancy, as an Integer
   */
  public Integer getMaximumOccupancy() {
    return this.maximumOccupancy;
  }

  /**
   * Getter for whether requiring a specialized driver’s license
   *
   * @return - if it requires a specialized driver’s license, as a Boolean
   */
  public Boolean getRequireSpecializedLicense() {
    return this.requireSpecializedLicense;
  }

  /**
   * Getter for whether allowing different pick-up and drop-off locations
   *
   * @return - if it allows different pick-up and drop-off locations, as a Boolean
   */
  public Boolean getAllowDifferentPickupAndDropoffLocations() {
    return this.allowDifferentPickupAndDropoffLocations;
  }

  /**
   * Set the car's number of booked days to the given value if the booking is valid
   *
   * @param days                  - the number of days a client would want to reserve a car, as an
   *                              Integer
   * @param passengers            - the number of passengers the client would like to seat in the
   *                              vehicle, as an Integer
   * @param pickupLocation        - the client’s preferred pick-up location, as a String
   * @param dropoffLocation       - the client’s preferred drop-off location, as a String
   * @param hasSpecializedLicense - whether the client has a specialized driver’s license, as a
   *                              Boolean
   * @return - whether the client books the vehicle successfully
   * @throws BookedDaysNumericException On negative bookedDays
   */
  public boolean bookVehicle(Integer days, Integer passengers, String pickupLocation,
      String dropoffLocation, Boolean hasSpecializedLicense) throws BookedDaysNumericException {
    if (this.isAvailable() && passengers > 0 && passengers < this.maximumOccupancy) {
      this.setBookedDays(days);
      return true;
    } else {
      return false;
    }
  }
}
