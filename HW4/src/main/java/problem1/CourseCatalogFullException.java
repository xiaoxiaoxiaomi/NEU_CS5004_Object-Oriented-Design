package problem1;

/**
 * Signals an error when the number of courses in catalog has reached maximum
 */
public class CourseCatalogFullException extends Exception {

  /**
   * Constructs a new CourseCatalogFullException with the specified detail message
   *
   * @param message - the detail message
   */
  public CourseCatalogFullException(String message) {
    super(message);
  }
}
