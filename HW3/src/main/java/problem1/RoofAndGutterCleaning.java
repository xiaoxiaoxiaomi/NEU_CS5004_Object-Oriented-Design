package problem1;

import java.util.Objects;

/**
 * Class RoofAndGutterCleaning is inherited from abstract class ExteriorService, it inherits
 * property address, property size, whether the service is carried out monthly, the number of
 * services previously carried out at the address, estimated hours and discount rate, and it stores
 * roof square footage and roof type.
 */
public class RoofAndGutterCleaning extends ExteriorService {

  private final Double roofSquareFootage;
  private final RoofType roofType;

  private static final Double ADDITIONAL_RATE_BAR = 3000.0;
  private static final Double ADDITIONAL_RATE = 50.0;
  private static final Double ADDITIONAL_FEE = 200.0;

  /**
   * Constructor for class RoofAndGutterCleaning
   *
   * @param propertyAddress      - property address, encoded as String
   * @param propertySize         - property size, encoded as enum, the size can be small, medium, or
   *                             large
   * @param isMonthly            -  whether the service is carried out monthly, encoded as Boolean
   * @param numberOfPastServices - the number of services previously carried out at the address,
   *                             encoded as Integer
   * @param roofSquareFootage    - the square footage of the roof, encoded as Double
   * @param roofType             - the type of roof, encoded as enum, with values Gable, Mansard,
   *                             Flat and Hip Roof
   * @throws RoofSquareFootageNonPositiveException On non-positive roof square footage
   */
  public RoofAndGutterCleaning(String propertyAddress, PropertySize propertySize,
      Boolean isMonthly, Integer numberOfPastServices, Double roofSquareFootage,
      RoofType roofType) throws RoofSquareFootageNonPositiveException {
    super(propertyAddress, propertySize, isMonthly, numberOfPastServices);
    if (roofSquareFootage <= 0) {
      throw new RoofSquareFootageNonPositiveException(
          "The square footage of roof should not be negative.");
    }
    this.roofSquareFootage = roofSquareFootage;
    this.roofType = roofType;
  }

  /**
   * Getter for roof square footage
   *
   * @return - the square footage of the roof, encoded as Double
   */
  public Double getRoofSquareFootage() {
    return roofSquareFootage;
  }

  /**
   * Getter for roof type
   *
   * @return - the type of roof, encoded as enum, with values Gable, Mansard, Flat and Hip Roof
   */
  public RoofType getRoofType() {
    return roofType;
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
    RoofAndGutterCleaning that = (RoofAndGutterCleaning) o;
    return roofSquareFootage.equals(that.roofSquareFootage) && roofType == that.roofType;
  }

  /**
   * Returns a hash code value for the object.
   *
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), roofSquareFootage, roofType);
  }

  /**
   * Returns a string representation of the object.
   *
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "RoofAndGutterCleaning{" +
        "roofSquareFootage=" + roofSquareFootage +
        ", roofType=" + roofType +
        '}';
  }

  /**
   * Calculate price for Roof and Gutter Cleaning
   *
   * @return price for Roof and Gutter Cleaning, as double
   */
  @Override
  public double calculatePrice() {
    double rate = NonSpecialistService.BASE_RATE;
    double additionalFee = 0.0;
    if (this.roofSquareFootage > ADDITIONAL_RATE_BAR) {
      rate += ADDITIONAL_RATE;
    }
    if (this.roofType == RoofType.MANSARD) {
      additionalFee += ADDITIONAL_FEE;
    }
    return (rate * this.estimatedHours + additionalFee) * (1 - this.discountRate);
  }
}
