package problem1;

/**
 * Signals an error when the number of pets is negative
 */
public class PetsNegativeException extends Exception {

  /**
   * Constructs a new PetsNegativeException with the specified detail message
   *
   * @param message - the detail message
   */
  public PetsNegativeException(String message) {
    super(message);
  }
}
