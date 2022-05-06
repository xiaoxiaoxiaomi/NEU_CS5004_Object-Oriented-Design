package problem1;


/**
 * Class Painting is inherited from abstract class InteriorService, it inherits property address,
 * property size, whether the service is carried out monthly, the number of services previously
 * carried out at the address, estimated hours and discount rate.
 */
public class Painting extends InteriorService {

  private static final Integer SMALL_MEDIUM_ESTIMATED_HOUR_PAINTING = 16;
  private static final Integer LARGE_ESTIMATED_HOUR_PAINTING = 24;

  /**
   * Constructor for the class Painting
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
  public Painting(String propertyAddress, PropertySize propertySize,
      Boolean isMonthly, Integer numberOfPastServices, Integer numberOfPets)
      throws PetsNegativeException {
    super(propertyAddress, propertySize, isMonthly, numberOfPastServices, numberOfPets);
  }

  /**
   * Calculate price for Painting
   *
   * @return price for Painting, as double
   */
  @Override
  public double calculatePrice() {
    if (this.propertySize == PropertySize.LARGE) {
      this.estimatedHours = LARGE_ESTIMATED_HOUR_PAINTING;
    } else {
      this.estimatedHours = SMALL_MEDIUM_ESTIMATED_HOUR_PAINTING;
    }
    return NonSpecialistService.BASE_RATE * this.estimatedHours * (1 + this.petFeeRate) * (1
        - this.discountRate);
  }
}
