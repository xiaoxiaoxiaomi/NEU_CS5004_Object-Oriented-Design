package problem1;

/**
 * Abstract class ExteriorService is inherited from abstract class NonSpecialistService, it inherits
 * property address, property size, whether the service is carried out monthly and the number of
 * services previously carried out at the address, estimated hours and discount rate
 */
public abstract class ExteriorService extends NonSpecialistService {

  /**
   * Constructor for the class ExteriorService
   *
   * @param propertyAddress      - property address, encoded as String
   * @param propertySize         - property size, encoded as enum, the size can be small, medium, or
   *                             large
   * @param isMonthly            -  whether the service is carried out monthly, encoded as Boolean
   * @param numberOfPastServices - the number of services previously carried out at the address,
   *                             encoded as Integer
   */
  public ExteriorService(String propertyAddress, PropertySize propertySize,
      Boolean isMonthly, Integer numberOfPastServices) {
    super(propertyAddress, propertySize, isMonthly, numberOfPastServices);
    if (this.propertySize == PropertySize.SMALL) {
      this.estimatedHours = SMALL_ESTIMATED_HOUR;
    } else if (this.propertySize == PropertySize.MEDIUM) {
      this.estimatedHours = MEDIUM_ESTIMATED_HOURS;
    } else {
      this.estimatedHours = LARGE_ESTIMATED_HOURS;
    }
  }
}
