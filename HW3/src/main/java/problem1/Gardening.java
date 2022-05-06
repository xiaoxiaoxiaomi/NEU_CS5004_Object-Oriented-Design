package problem1;

/**
 * Class Gardening is inherited from abstract class ExteriorService, it inherits property address,
 * property size, whether the service is carried out monthly, the number of services previously
 * carried out at the address, estimated hours and discount rate.
 */
public class Gardening extends ExteriorService {

  private static final Double WASTE_REMOVAL_FEE = 20.0;

  /**
   * Constructor for class Gardening
   *
   * @param propertyAddress      - property address, encoded as String
   * @param propertySize         - property size, encoded as enum, the size can be small, medium, or
   *                             large
   * @param isMonthly            -  whether the service is carried out monthly, encoded as Boolean
   * @param numberOfPastServices - the number of services previously carried out at the address,
   *                             encoded as Integer
   */
  public Gardening(String propertyAddress, PropertySize propertySize,
      Boolean isMonthly, Integer numberOfPastServices) {
    super(propertyAddress, propertySize, isMonthly, numberOfPastServices);
  }

  /**
   * Calculate price for Gardening
   *
   * @return price for Gardening, as double
   */
  @Override
  public double calculatePrice() {
    return (NonSpecialistService.BASE_RATE * this.estimatedHours + WASTE_REMOVAL_FEE) * (1
        - this.discountRate);
  }
}
