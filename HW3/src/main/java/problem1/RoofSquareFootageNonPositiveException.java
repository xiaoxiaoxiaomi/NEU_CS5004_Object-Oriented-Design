package problem1;

/**
 * Signals an error when the roof square footage is not positive
 */
public class RoofSquareFootageNonPositiveException extends Exception {

  /**
   * Constructs a new RoofSquareFootageNonPositiveException with the specified detail message
   *
   * @param message - the detail message
   */
  public RoofSquareFootageNonPositiveException(String message) {
    super(message);
  }
}
