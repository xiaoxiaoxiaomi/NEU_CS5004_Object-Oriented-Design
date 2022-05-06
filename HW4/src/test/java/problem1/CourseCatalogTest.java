package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseCatalogTest {

  static final Integer CATALOG_CAPACITY = 100;

  Course course1;
  Course course2;
  Course course3;
  Course[] testCourseArr;
  CourseCatalog testCourseCatalog;

  @BeforeEach
  void setUp() throws InvalidCourseListException {
    course1 = new Course("Object-Oriented Design", "CS", 5004);
    course2 = new Course("Data Structure", "CS", 5008);
    course3 = new Course("Algorithm", "CS", 5800);
    testCourseArr = new Course[]{course1, course2};
    testCourseCatalog = new CourseCatalog(CATALOG_CAPACITY, testCourseArr);
  }

  @Test
  void test_Constructor() {
    Course[] newCourseArr = new Course[CATALOG_CAPACITY+1];
    assertThrows(InvalidCourseListException.class, () -> {
      new CourseCatalog(CATALOG_CAPACITY, newCourseArr);
    });
  }

  @Test
  void append() throws CourseCatalogFullException, InvalidIndexException {
    testCourseCatalog.append(course3);
    assertEquals(testCourseCatalog.get(2), course3);
    for (int i=0; i < CATALOG_CAPACITY - 3; i++) {
      testCourseCatalog.append(course3);
    }
    assertThrows(CourseCatalogFullException.class, () -> {
      testCourseCatalog.append(course3);
    });
  }

  @Test
  void add() throws CourseCatalogFullException, InvalidIndexException {
    testCourseCatalog.add(course3);
    assertEquals(testCourseCatalog.get(0), course3);
    for (int i=0; i < CATALOG_CAPACITY - 3; i++) {
      testCourseCatalog.add(course3);
    }
    assertThrows(CourseCatalogFullException.class, () -> {
      testCourseCatalog.add(course3);
    });
  }

  @Test
  void remove() throws CourseNotFoundException {
    testCourseCatalog.remove(course1);
    assertFalse(testCourseCatalog.contains(course1));
    assertThrows(CourseNotFoundException.class, () -> {
      testCourseCatalog.remove(course3);
    });
  }

  @Test
  void contains() {
    assertTrue(testCourseCatalog.contains(course1));
    assertFalse(testCourseCatalog.contains(course3));
  }

  @Test
  void indexOf() {
    assertEquals(0, testCourseCatalog.indexOf(course1));
    assertEquals(-1, testCourseCatalog.indexOf(course3));
  }

  @Test
  void count() {
    assertEquals(2, testCourseCatalog.count());
  }

  @Test
  void get() throws InvalidIndexException {
    assertEquals(course2, testCourseCatalog.get(1));
    assertThrows(InvalidIndexException.class, () -> {
      testCourseCatalog.get(-1);
    });
    assertThrows(InvalidIndexException.class, () -> {
      testCourseCatalog.get(2);
    });
  }

  @Test
  void isEmpty() throws CourseNotFoundException {
    assertFalse(testCourseCatalog.isEmpty());
    testCourseCatalog.remove(course1);
    testCourseCatalog.remove(course2);
    assertTrue(testCourseCatalog.isEmpty());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(course1.equals(course1));
    assertTrue(testCourseCatalog.equals(testCourseCatalog));
  }

  @Test
  void testEquals_DifferentObject() {
    assertFalse(course1.equals(testCourseCatalog));
    assertFalse(testCourseCatalog.equals(course1));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(course1.equals(null));
    assertFalse(testCourseCatalog.equals(null));
  }

  @Test
  void testEquals_DifferentName() {
    Course testCourse = new Course("OOD", "CS", 5004);
    assertFalse(course1.equals(testCourse));
  }

  @Test
  void testEquals_DifferentPrefix() {
    Course testCourse = new Course("Object-Oriented Design", "DS", 5004);
    assertFalse(course1.equals(testCourse));
  }

  @Test
  void testEquals_DifferentNumber() {
    Course testCourse = new Course("Object-Oriented Design", "CS", 6004);
    assertFalse(course1.equals(testCourse));
  }

  @Test
  void testEquals_DifferentCourseArr() throws InvalidCourseListException {
    Course[] newCourseArr = new Course[]{course1, course2, course3};
    CourseCatalog newCourseCalalog = new CourseCatalog(CATALOG_CAPACITY, newCourseArr);
    assertFalse(testCourseCatalog.equals(newCourseCalalog));
  }

  @Test
  void testEquals_SameFieldsOverall() throws CourseCatalogFullException {
    Course testCourse = new Course("Object-Oriented Design", "CS", 5004);
    assertTrue(course1.equals(testCourse));
    Course newCourse1 = new Course("Object-Oriented Design", "CS", 5004);
    Course newCourse2 = new Course("Data Structure", "CS", 5008);
    CourseCatalog newCourseCatalog = new CourseCatalog(CATALOG_CAPACITY);
    newCourseCatalog.append(newCourse1);
    newCourseCatalog.append(newCourse2);
    assertTrue(testCourseCatalog.equals(newCourseCatalog));
  }

  @Test
  void testHashCode() {
    Course[] expectedCourseArr = new Course[CATALOG_CAPACITY];
    expectedCourseArr[0] = course1;
    expectedCourseArr[1] = course2;
    int expectedHashCode = Objects.hash(2);
    expectedHashCode = 31 * expectedHashCode + Arrays.hashCode(expectedCourseArr);
    assertEquals(expectedHashCode, testCourseCatalog.hashCode());
  }

  @Test
  void testToString() {
    Course[] expectedCourseArr = new Course[CATALOG_CAPACITY];
    expectedCourseArr[0] = course1;
    expectedCourseArr[1] = course2;
    String expectedString = "CourseCatalogImplementation{" +
        "courseArr=" + Arrays.toString(expectedCourseArr) +
        ", numCourses=" + 2 +
        '}';
    assertEquals(expectedString, testCourseCatalog.toString());
  }
}