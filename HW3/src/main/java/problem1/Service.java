package problem1;

import java.util.Objects;

/**
 * Abstract Class Service stores information about Service - property address, property size,
 * whether the service is carried out monthly and the number of services previously carried out at
 * the address
 */
public abstract class Service {

  /**
   * property address, encoded as String
   */
  protected String propertyAddress;
  /**
   * property size, encoded as enum, the size can be small, medium, or large
   */
  protected PropertySize propertySize;
  /**
   * whether the service is carried out monthly, encoded as Boolean
   */
  protected Boolean isMonthly;
  /**
   * the number of services previously carried out at the address, encoded as Integer
   */
  protected Integer numberOfPastServices;

  /**
   * Constructor for the class Service
   *
   * @param propertyAddress      - property address, encoded as String
   * @param propertySize         - property size, encoded as enum, the size can be small, medium, or
   *                             large
   * @param isMonthly            -  whether the service is carried out monthly, encoded as Boolean
   * @param numberOfPastServices - the number of services previously carried out at the address,
   *                             encoded as Integer
   */
  public Service(String propertyAddress, PropertySize propertySize, Boolean isMonthly,
      Integer numberOfPastServices) {
    this.propertyAddress = propertyAddress;
    this.propertySize = propertySize;
    this.isMonthly = isMonthly;
    this.numberOfPastServices = numberOfPastServices;
  }

  /**
   * Getter for property address
   *
   * @return - property address, encoded as String
   */
  public String getPropertyAddress() {
    return this.propertyAddress;
  }

  /**
   * Getter for property size
   *
   * @return - property size, encoded as enum, the size can be small, medium, or large
   */
  public PropertySize getPropertySize() {
    return this.propertySize;
  }

  /**
   * Getter for whether the service is carried out monthly
   *
   * @return - whether the service is carried out monthly, encoded as Boolean
   */
  public Boolean getMonthly() {
    return this.isMonthly;
  }

  /**
   * Getter for the number of past services
   *
   * @return - the number of services previously carried out at the address, encoded as Integer
   */
  public Integer getNumberOfPastServices() {
    return this.numberOfPastServices;
  }

  /**
   * Abstract method calculatePrice() calculate a price for a service based on the work to be done,
   * and the home’s characteristics
   *
   * @return the price for a service based on the work to be done, and the home’s characteristics,
   * as a Double
   */
  public abstract double calculatePrice();

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
    Service service = (Service) o;
    return Objects.equals(propertyAddress, service.propertyAddress)
        && propertySize == service.propertySize && Objects.equals(isMonthly,
        service.isMonthly) && Objects.equals(numberOfPastServices,
        service.numberOfPastServices);
  }

  /**
   * Returns a hash code value for the object.
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(propertyAddress, propertySize, isMonthly, numberOfPastServices);
  }

  /**
   * Returns a string representation of the object.
   *
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "Service{" +
        "propertyAddress='" + propertyAddress + '\'' +
        ", propertySize=" + propertySize +
        ", isMonthly=" + isMonthly +
        ", numberOfPastServices=" + numberOfPastServices +
        '}';
  }
}
