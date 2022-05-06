package problem1;

/**
 * Class Cleaning is inherited from abstract class InteriorService, it inherits property address,
 * property size, whether the service is carried out monthly, the number of services previously
 * carried out at the address, estimated hours, discount rate and number of pets
 */
public class Cleaning extends InteriorService {

  /**
   * Constructor for the class Cleaning
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
  public Cleaning(String propertyAddress, PropertySize propertySize,
      Boolean isMonthly, Integer numberOfPastServices, Integer numberOfPets)
      throws PetsNegativeException {
    super(propertyAddress, propertySize, isMonthly, numberOfPastServices, numberOfPets);
  }

  /**
   * Calculate price for Cleaning
   *
   * @return price for Cleaning, as double
   */
  @Override
  public double calculatePrice() {
    if (this.propertySize == PropertySize.SMALL) {
      this.estimatedHours = SMALL_ESTIMATED_HOUR;
    } else if (this.propertySize == PropertySize.MEDIUM) {
      this.estimatedHours = MEDIUM_ESTIMATED_HOURS;
    } else {
      this.estimatedHours = LARGE_ESTIMATED_HOURS;
    }
    return NonSpecialistService.BASE_RATE * this.estimatedHours * (1 + this.petFeeRate) * (1
        - this.discountRate);
  }
}
