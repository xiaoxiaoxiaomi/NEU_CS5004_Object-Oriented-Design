package problem1;

/**
 * This is an interface for course catalog
 */
public interface CourseCatalogInterface {

  /**
   * Adds a Course to the end of the CourseCatalog.
   *
   * @param course - course, encoded as Course
   * @throws CourseCatalogFullException if the number of courses in catalog has reached maximum
   */
  void append(Course course) throws CourseCatalogFullException;

  /**
   * Adds a Course to the beginning of the CourseCatalog.
   *
   * @param course - course, encoded as Course
   * @throws CourseCatalogFullException if the number of courses in catalog has reached maximum
   */
  void add(Course course) throws CourseCatalogFullException;

  /**
   * Removes a specified Course from the CourseCatalog. If the CourseCatalog contains multiple
   * instances of the same Course, the instance with the lowest index is removed.
   *
   * @param course - course, encoded as Course
   * @throws CourseNotFoundException if the course does not exist
   */
  void remove(Course course) throws CourseNotFoundException;

  /**
   * Checks if the specified course exists in the CourseCatalog.
   *
   * @param course - course, encoded as Course
   * @return true if the specified course exists in the CourseCatalog, otherwise return false
   */
  boolean contains(Course course);

  /**
   * Returns the index of the specified Course in the CourseCatalog if it exists, otherwise, returns
   * -1.
   *
   * @param course - course, encoded as Course
   * @return the index of the specified Course in the CourseCatalog if it exists, otherwise, returns
   * -1.
   */
  int indexOf(Course course);

  /**
   * Gets the number of Courses in the CourseCatalog.
   *
   * @return the number of Courses in the CourseCatalog.
   */
  int count();

  /**
   * Returns the Course at the given index in the CourseCatalog.
   *
   * @param index index of Course, as an int
   * @return the Course at the given index in the CourseCatalog.
   * @throws InvalidIndexException if the index does not exist.
   */
  Course get(int index) throws InvalidIndexException;

  /**
   * Checks if the Course Catalog is empty.
   *
   * @return true if the Course Catalog is empty, otherwise return false
   */
  boolean isEmpty();
}
