package problem1;

/**
 * Signals an error if the given course does not exist in the catalog
 */
public class CourseNotFoundException extends Exception {

  /**
   * Constructs a new CourseNotFoundException with the specified detail message
   *
   * @param message - the detail message
   */
  public CourseNotFoundException(String message) {
    super(message);
  }
}
