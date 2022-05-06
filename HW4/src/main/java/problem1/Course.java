package problem1;

import java.util.Objects;

/**
 * Class Course stores information about Course - name, prefix and number
 */
public class Course {

  private final String name;
  private final String prefix;
  private final int number;

  /**
   * Constructor for the class Course
   *
   * @param name   - name, encoded as String
   * @param prefix - prefix, encoded as String
   * @param number - number, encoded as int
   */
  public Course(String name, String prefix, int number) {
    this.name = name;
    this.prefix = prefix;
    this.number = number;
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
    Course course = (Course) o;
    return number == course.number &&
        name.equals(course.name) &&
        prefix.equals(course.prefix);
  }

  /**
   * Returns a hash code value for the object.
   *
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, prefix, number);
  }

  /**
   * Returns a string representation of the object.
   *
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return prefix + number + ": " + name;
  }
}
