package problem1;

/**
 * Class Electrical is inherited from abstract class SpecialistService, it inherits property
 * address, property size, whether the service is carried out monthly and the number of services
 * previously carried out at the address, number of employees and if the work to be done is complex
 */
public class Electrical extends SpecialistService {

  private static final Integer ELECTRICAL_MAX_EMPLOYEE = 4;
  private static final Double ELECTRICAL_PERMITTING_FEE = 50.0;

  /**
   * Constructor for class Electrical
   *
   * @param propertyAddress      - property address, encoded as String
   * @param propertySize         - property size, encoded as enum, the size can be small, medium, or
   *                             large
   * @param isMonthly            -  whether the service is carried out monthly, encoded as Boolean
   * @param numberOfPastServices - the number of services previously carried out at the address,
   *                             encoded as Integer
   * @param numberOfEmployees    - number of employees, encoded as Integer
   * @param ifComplex            - whether the work is complex, encoded as Boolean
   * @throws EmployeesExceedException On 5 or more employees
   */
  public Electrical(String propertyAddress, PropertySize propertySize, Boolean isMonthly,
      Integer numberOfPastServices, Integer numberOfEmployees, Boolean ifComplex)
      throws EmployeesExceedException {
    super(propertyAddress, propertySize, isMonthly, numberOfPastServices, numberOfEmployees,
        ifComplex);
    if (numberOfEmployees > ELECTRICAL_MAX_EMPLOYEE) {
      throw new EmployeesExceedException(
          "It should not be possible to create an electrical service if more than 4 licensed employees are required");
    }
  }

  /**
   * Calculate price for Electrical
   *
   * @return price for Electrical
   */
  @Override
  public double calculatePrice() {
    return SpecialistService.SPECIALIST_BASE_RATE * this.numberOfEmployees
        + ELECTRICAL_PERMITTING_FEE;
  }
}
