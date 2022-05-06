package midterm.p2;

/**
 * Signals an error if the NationalPark does not exist in the NationalParkDirectory
 */
public class NationalParkNotFoundException extends Exception {

  /**
   * Constructs a new NationalParkNotFoundException with the specified detail message
   * @param message - the detail message
   */
  public NationalParkNotFoundException(String message) {
    super(message);
  }
}
