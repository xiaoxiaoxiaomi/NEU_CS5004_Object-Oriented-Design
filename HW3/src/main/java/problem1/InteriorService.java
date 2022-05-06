package problem1;

import java.util.Objects;

/**
 * Abstract class InteriorService is inherited from abstract class NonSpecialistService, it inherits
 * property address, property size, whether the service is carried out monthly, the number of
 * services previously carried out at the address, estimated hours and discount rate, and it stores
 * number of pets
 */
public abstract class InteriorService extends NonSpecialistService {

  /**
   * number of pets, encoded as Integer
   */
  protected Integer numberOfPets;
  /**
   * pet fee rate, encoded as Double, stores extra fee rate according to the number of pets
   */
  protected double petFeeRate = 0.0;

  private static final Double ONE_OR_TWO_ADDITIONAL_FEE_RATE = 0.05;
  private static final Double THREE_OR_MORE_ADDITIONAL_FEE_RATE = 0.07;

  /**
   * Constructor for the class InteriorService
   *
   * @param propertyAddress      - property address, encoded as String
   * @param propertySize         - property size, encoded as enum, the size can be small, medium, or
   *                             large
   * @param isMonthly            -  whether the service is carried out monthly, encoded as Boolean
   * @param numberOfPastServices - the number of services previously carried out at the address,
   *                             encoded as Integer
   * @param numberOfPets         - number of pets, encoded as Integer
   * @throws PetsNegativeException On negative number of pets
   */
  public InteriorService(String propertyAddress, PropertySize propertySize,
      Boolean isMonthly, Integer numberOfPastServices, Integer numberOfPets)
      throws PetsNegativeException {
    super(propertyAddress, propertySize, isMonthly, numberOfPastServices);
    if (numberOfPets < 0) {
      throw new PetsNegativeException("The number of pets should not be negative.");
    }
    this.numberOfPets = numberOfPets;
    if (this.numberOfPets == 1 || this.numberOfPets == 2) {
      this.petFeeRate = ONE_OR_TWO_ADDITIONAL_FEE_RATE;
    } else if (this.numberOfPets >= 3) {
      this.petFeeRate = THREE_OR_MORE_ADDITIONAL_FEE_RATE;
    }
  }

  /**
   * Getter for number of pets
   *
   * @return - number of pets, encoded as Integer
   */
  public Integer getNumberOfPets() {
    return numberOfPets;
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
    InteriorService that = (InteriorService) o;
    return numberOfPets.equals(that.numberOfPets);
  }

  /**
   * Returns a hash code value for the object.
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), numberOfPets);
  }

  /**
   * Returns a string representation of the object.
   *
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "InteriorService{" +
        "numberOfPets=" + numberOfPets +
        ", petFeeRate=" + petFeeRate +
        '}';
  }
}
