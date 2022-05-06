package problem1;

/**
 * Signals an error when the number of employees is more than required.
 */
public class EmployeesExceedException extends Exception {

  /**
   * Constructs a new EmployeesExceedException with the specified detail message
   *
   * @param message - the detail message
   */
  public EmployeesExceedException(String message) {
    super(message);
  }
}
