package problem1;

/**
 * Class InternetTVComputing is inherited from abstract class SpecialistService, it inherits
 * property address, property size, whether the service is carried out monthly and the number of
 * services previously carried out at the address, number of employees and if the work to be done is
 * complex
 */
public class InternetTVComputing extends SpecialistService {

  private static final Integer INTERNET_TV_COMPUTING_MAX_EMPLOYEE = 2;
  private static final Double ELECTRONIC_WASTE_RECYCLING_FEE = 15.0;

  /**
   * Constructor for class InternetTVComputing
   *
   * @param propertyAddress      - property address, encoded as String
   * @param propertySize         - property size, encoded as enum, the size can be small, medium, or
   *                             large
   * @param isMonthly            -  whether the service is carried out monthly, encoded as Boolean
   * @param numberOfPastServices - the number of services previously carried out at the address,
   *                             encoded as Integer
   * @param numberOfEmployees    - number of employees, encoded as Integer
   * @param ifComplex            - whether the work is complex, encoded as Boolean
   * @throws EmployeesExceedException On 3 or more employees
   */
  public InternetTVComputing(String propertyAddress, PropertySize propertySize,
      Boolean isMonthly, Integer numberOfPastServices, Integer numberOfEmployees,
      Boolean ifComplex) throws EmployeesExceedException {
    super(propertyAddress, propertySize, isMonthly, numberOfPastServices, numberOfEmployees,
        ifComplex);
    if (numberOfEmployees > INTERNET_TV_COMPUTING_MAX_EMPLOYEE) {
      throw new EmployeesExceedException(
          "It should not be possible to create a service if more than 2 licensed employees are required.");
    }
  }

  /**
   * Calculate price for InternetTVComputing
   *
   * @return price for InternetTVComputing
   */
  @Override
  public double calculatePrice() {
    return SpecialistService.SPECIALIST_BASE_RATE * this.numberOfEmployees
        + ELECTRONIC_WASTE_RECYCLING_FEE;
  }
}
