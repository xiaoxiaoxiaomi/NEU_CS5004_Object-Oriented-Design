package problem1;

import java.util.Objects;

/**
 * Abstract class SpecialistService is inherited from abstract class Service, it inherits property
 * address, property size, whether the service is carried out monthly and the number of services
 * previously carried out at the address, and it stores number of employees and if the work to be
 * done is complex
 */
public abstract class SpecialistService extends Service {

  /**
   * number of employees, encoded as Integer
   */
  protected Integer numberOfEmployees;
  /**
   * if the work to be done is complex, encoded as Boolean
   */
  protected Boolean ifComplex;
  /**
   * the base rate is $200 per licensed employee for all specialist services
   */
  protected static final Double SPECIALIST_BASE_RATE = 200.0;

  private static final Integer ALL_SPECIALIST_SERVICE_MIN_EMPLOYEE = 1;
  private static final Integer COMPLEX_WORK_MIN_EMPLOYEE = 2;
  private static final Integer COMPLEX_WORK_LARGE_HOUSE_MIN_EMPLOYEE = 3;

  /**
   * Constructor for the class SpecialistService
   *
   * @param propertyAddress      - property address, encoded as String
   * @param propertySize         - property size, encoded as enum, the size can be small, medium, or
   *                             large
   * @param isMonthly            -  whether the service is carried out monthly, encoded as Boolean
   * @param numberOfPastServices - the number of services previously carried out at the address,
   *                             encoded as Integer
   * @param numberOfEmployees    - the number of licensed employees required to complete the work,
   *                             encoded as Integer
   * @param ifComplex            - if the work to be done is complex, encoded as Boolean
   */
  public SpecialistService(String propertyAddress, PropertySize propertySize,
      Boolean isMonthly, Integer numberOfPastServices, Integer numberOfEmployees,
      Boolean ifComplex) {
    super(propertyAddress, propertySize, isMonthly, numberOfPastServices);
    this.numberOfEmployees = numberOfEmployees;
    this.ifComplex = ifComplex;
    if (numberOfEmployees < ALL_SPECIALIST_SERVICE_MIN_EMPLOYEE) {
      this.numberOfEmployees = ALL_SPECIALIST_SERVICE_MIN_EMPLOYEE;
    }
    if (ifComplex) {
      if (numberOfEmployees < COMPLEX_WORK_MIN_EMPLOYEE) {
        this.numberOfEmployees = COMPLEX_WORK_MIN_EMPLOYEE;
      }
      if (propertySize == PropertySize.LARGE
          && numberOfEmployees < COMPLEX_WORK_LARGE_HOUSE_MIN_EMPLOYEE) {
        this.numberOfEmployees = COMPLEX_WORK_LARGE_HOUSE_MIN_EMPLOYEE;
      }
    }
  }

  /**
   * Getter for number of employees
   *
   * @return - the number of licensed employees required to complete the work, encoded as Integer
   */
  public Integer getNumberOfEmployees() {
    return this.numberOfEmployees;
  }

  /**
   * Getter for if the work to be done is complex
   *
   * @return if the work to be done is complex, encoded as Boolean
   */
  public Boolean getIfComplex() {
    return this.ifComplex;
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
    SpecialistService that = (SpecialistService) o;
    return numberOfEmployees.equals(that.numberOfEmployees) && ifComplex.equals(that.ifComplex);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), numberOfEmployees, ifComplex);
  }

  /**
   * Returns a string representation of the object.
   *
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "SpecialistService{" +
        "numberOfEmployees=" + numberOfEmployees +
        ", ifComplex=" + ifComplex +
        '}';
  }
}
