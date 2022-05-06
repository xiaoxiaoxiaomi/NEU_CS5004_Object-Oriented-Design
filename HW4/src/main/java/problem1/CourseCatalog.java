package problem1;

import java.util.Arrays;
import java.util.Objects;

/**
 * CourseCatalog is an ordered, mutable collection, which will be used as part of a university
 * course registration system
 */
public class CourseCatalog implements CourseCatalogInterface {

  private Integer capacity;
  private Course[] courseArr;
  private Integer numCourses;

  /**
   * Constructor for Class CourseCatalog
   *
   * @param capacity - capacity of the course catalog, as an Integer
   */
  public CourseCatalog(Integer capacity) {
    this.capacity = capacity;
    this.courseArr = new Course[capacity];
    this.numCourses = 0;
  }

  /**
   * Constructor for Class CourseCatalog
   *
   * @param capacity - capacity of the course catalog, as an Integer
   * @param courseArr - an array whose elements are Course
   * @throws InvalidCourseListException if the length of the input course array exceeds the capacity
   */
  public CourseCatalog(Integer capacity, Course[] courseArr) throws InvalidCourseListException {
    if (courseArr.length > capacity) {
      throw new InvalidCourseListException("The number of courses exceeds the catalog capacity");
    }
    this.capacity = capacity;
    this.courseArr = new Course[capacity];
    System.arraycopy(courseArr, 0, this.courseArr, 0, courseArr.length);
    this.numCourses = courseArr.length;
  }

  /**
   * Adds a Course to the end of the CourseCatalog.
   *
   * @param course - course, encoded as Course
   * @throws CourseCatalogFullException if the number of courses in catalog has reached maximum
   */
  @Override
  public void append(Course course) throws CourseCatalogFullException {
    if (Objects.equals(this.numCourses, this.capacity)) {
      throw new CourseCatalogFullException("The course catalog is full");
    }
    this.courseArr[this.numCourses++] = course;
  }

  /**
   * Adds a Course to the beginning of the CourseCatalog.
   *
   * @param course - course, encoded as Course
   * @throws CourseCatalogFullException if the number of courses in catalog has reached maximum
   */
  @Override
  public void add(Course course) throws CourseCatalogFullException {
    if (Objects.equals(this.numCourses, this.capacity)) {
      throw new CourseCatalogFullException("The course catalog is full");
    }
    System.arraycopy(this.courseArr, 0, this.courseArr, 1, this.numCourses);
    this.courseArr[0] = course;
    this.numCourses++;
  }

  /**
   * Removes a specified Course from the CourseCatalog. If the CourseCatalog contains multiple
   * instances of the same Course, the instance with the lowest index is removed.
   *
   * @param course - course, encoded as Course
   * @throws CourseNotFoundException if the course does not exist
   */
  @Override
  public void remove(Course course) throws CourseNotFoundException {
    for (int i = 0; i < this.numCourses; i++) {
      if (this.courseArr[i] == course) {
        System.arraycopy(this.courseArr, i + 1, this.courseArr, i, this.numCourses - i);
        this.numCourses--;
        return;
      }
    }
    throw new CourseNotFoundException("The course is not found");
  }

  /**
   * Checks if the specified course exists in the CourseCatalog.
   *
   * @param course - course, encoded as Course
   * @return true if the specified course exists in the CourseCatalog, otherwise return false
   */
  @Override
  public boolean contains(Course course) {
    for (int i = 0; i < this.numCourses; i++) {
      if (this.courseArr[i] == course) {
        return true;
      }
    }
    return false;
  }

  /**
   * Returns the index of the specified Course in the CourseCatalog if it exists, otherwise, returns
   * -1.
   *
   * @param course - course, encoded as Course
   * @return the index of the specified Course in the CourseCatalog if it exists, otherwise, returns
   * -1.
   */
  @Override
  public int indexOf(Course course) {
    for (int i = 0; i < this.numCourses; i++) {
      if (this.courseArr[i] == course) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Gets the number of Courses in the CourseCatalog.
   *
   * @return the number of Courses in the CourseCatalog.
   */
  @Override
  public int count() {
    return this.numCourses;
  }

  /**
   * Returns the Course at the given index in the CourseCatalog.
   *
   * @param index index of Course, as an int
   * @return the Course at the given index in the CourseCatalog.
   * @throws InvalidIndexException if the index does not exist.
   */
  @Override
  public Course get(int index) throws InvalidIndexException {
    if (index > this.numCourses - 1 || index < 0) {
      throw new InvalidIndexException("The index does not exist");
    }
    return this.courseArr[index];
  }

  /**
   * Checks if the Course Catalog is empty.
   *
   * @return true if the Course Catalog is empty, otherwise return false
   */
  @Override
  public boolean isEmpty() {
    return this.numCourses == 0;
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
    CourseCatalog that = (CourseCatalog) o;
    return Arrays.equals(courseArr, that.courseArr) && Objects.equals(numCourses,
        that.numCourses);
  }

  /**
   * Returns a hash code value for the object.
   *
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    int result = Objects.hash(numCourses);
    result = 31 * result + Arrays.hashCode(courseArr);
    return result;
  }

  /**
   * Returns a string representation of the object.
   *
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "CourseCatalogImplementation{" +
        "courseArr=" + Arrays.toString(courseArr) +
        ", numCourses=" + numCourses +
        '}';
  }
}
