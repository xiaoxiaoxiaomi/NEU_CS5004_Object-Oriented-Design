package problem1;

/**
 * Signals an error if the length of the input course array exceeds the max size defined
 */
public class InvalidCourseListException extends Exception {

  /**
   * Constructs a new InvalidCourseListException with the specified detail message
   *
   * @param message - the detail message
   */
  public InvalidCourseListException(String message) {
    super(message);
  }
}
