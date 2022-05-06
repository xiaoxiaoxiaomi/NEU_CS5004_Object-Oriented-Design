package problem1;

/**
 * Abstract class NonSpecialistService is inherited from abstract class Service, it inherits
 * property address, property size, whether the service is carried out monthly and the number of
 * services previously carried out at the address, and it stores estimated hours and discount rate
 */
public abstract class NonSpecialistService extends Service {

  /**
   * estimated hours, encoded as Integer
   */
  protected Integer estimatedHours;
  /**
   * discount rate, encoded as Double
   */
  protected Double discountRate = 0.0;
  /**
   * for all services except specialist services, the company charges a base rate of $80 per hour
   */
  protected static final Double BASE_RATE = 80.0;
  /**
   * the number of hours needed is estimated as 1 hour for small properties
   */
  protected static final Integer SMALL_ESTIMATED_HOUR = 1;
  /**
   * the number of hours needed is estimated as 2 hours for medium properties
   */
  protected static final Integer MEDIUM_ESTIMATED_HOURS = 2;
  /**
   * the number of hours needed is estimated as 4 hours for large properties
   */
  protected static final Integer LARGE_ESTIMATED_HOURS = 4;
  /**
   * the company will discount every 10th service
   */
  private static final Integer DISCOUNT_FREQUENCY = 10;
  /**
   * the company will discount every 10th service by 50%
   */
  private static final Double TENTH_DISCOUNT_RATE = 0.5;
  /**
   * the company offers a 10% discount for monthly services
   */
  private static final Double MONTHLY_DISCOUNT_RATE = 0.1;

  /**
   * Constructor for the class NonSpecialistService
   *
   * @param propertyAddress      - property address, encoded as String
   * @param propertySize         - property size, encoded as enum, the size can be small, medium, or
   *                             large
   * @param isMonthly            -  whether the service is carried out monthly, encoded as Boolean
   * @param numberOfPastServices - the number of services previously carried out at the address,
   *                             encoded as Integer
   */
  public NonSpecialistService(String propertyAddress, PropertySize propertySize, Boolean isMonthly,
      Integer numberOfPastServices) {
    super(propertyAddress, propertySize, isMonthly, numberOfPastServices);
    if (this.numberOfPastServices % DISCOUNT_FREQUENCY == (DISCOUNT_FREQUENCY - 1)) {
      this.discountRate = TENTH_DISCOUNT_RATE;
    } else if (this.isMonthly) {
      this.discountRate = MONTHLY_DISCOUNT_RATE;
    }
  }
}
