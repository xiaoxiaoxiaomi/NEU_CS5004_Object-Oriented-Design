package problem1;

/**
 * Class Plumbing is inherited from abstract class SpecialistService, it inherits property address,
 * property size, whether the service is carried out monthly and the number of services previously
 * carried out at the address, number of employees and if the work to be done is complex
 */
public class Plumbing extends SpecialistService {

  private static final Double PLUMBING_PERMITTING_FEE = 20.0;

  /**
   * Constructor for class Plumbing
   * @param propertyAddress      - property address, encoded as String
   * @param propertySize         - property size, encoded as enum, the size can be small, medium, or
   *                             large
   * @param isMonthly            -  whether the service is carried out monthly, encoded as Boolean
   * @param numberOfPastServices - the number of services previously carried out at the address,
   *                             encoded as Integer
   * @param numberOfEmployees    - number of employees, encoded as Integer
   * @param ifComplex            - whether the work is complex, encoded as Boolean
   */
  public Plumbing(String propertyAddress, PropertySize propertySize,
      Boolean isMonthly, Integer numberOfPastServices, Integer numberOfEmployees,
      Boolean ifComplex) {
    super(propertyAddress, propertySize, isMonthly, numberOfPastServices, numberOfEmployees,
        ifComplex);
  }

  /**
   * Calculate price for Plumbing
   *
   * @return price for Plumbing
   */
  @Override
  public double calculatePrice() {
    return SpecialistService.SPECIALIST_BASE_RATE * this.numberOfEmployees
        + PLUMBING_PERMITTING_FEE;
  }
}
