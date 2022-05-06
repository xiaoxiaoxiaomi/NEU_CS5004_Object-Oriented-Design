package problem2;

import java.util.Objects;

/**
 * Abstract class Individual inherits Creator and stores first name and last name of an individual
 */
public abstract class Individual extends Creator {

  /**
   * first name, encoded as String
   */
  protected String firstName;
  /**
   * last name, encoded as String
   */
  protected String lastName;

  /**
   * Constructor of Class Individual
   *
   * @param firstName - first name, encoded as String
   * @param lastName  - last name, encoded as String
   */
  public Individual(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Getter for first name
   *
   * @return first name, encoded as String
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Getter for last name
   *
   * @return last name, encoded as String
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Indicates whether some other object is "equal to" this one.
   *
   * @param o - the reference object with which to compare.
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
    Individual that = (Individual) o;
    return Objects.equals(firstName, that.firstName) && Objects.equals(lastName,
        that.lastName);
  }

  /**
   * Returns a hash code value for the object.
   *
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName);
  }

  /**
   * Returns a string representation of the object.
   *
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "Individual{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        '}';
  }
}
