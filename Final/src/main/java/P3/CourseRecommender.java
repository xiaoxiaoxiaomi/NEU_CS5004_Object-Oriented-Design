package P3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

public class CourseRecommender {

  private static final String CS5001 = "CS5001";
  private static final String CS5002 = "CS5002";
  private static final String CS5004 = "CS5004";
  private static final String CS5008 = "CS5008";
  private static final Integer RECOMMEND_THRESHOLD = 3;
  private List<Student> students;
  private List<Student> alignStudents;
  private Map<String, CourseStatistics> map;

  public CourseRecommender(List<Student> students, List<Student> alignStudents,
      Map<String, CourseStatistics> map) {
    this.students = students;
    this.alignStudents = alignStudents;
    this.map = map;
  }

  public CourseRecommender(List<Student> students) {
    this.students = students;
    this.alignStudents = filterOutAlignStudents(students);
    this.map = computeCollegeCoursesStatistics(students);
  }

  private List<Student> filterOutAlignStudents(List<Student> allStudents) {
    List<Student> alignStudents = new ArrayList<>();
    return allStudents.stream().filter(this::isAlignStudent).collect(Collectors.toList());
  }

  private boolean isAlignStudent(Student student) {
    return student.getTakenCourses().stream()
        .anyMatch(x -> x.getCourseCode().equals(CS5001) || x.getCourseCode().equals(CS5002)
            || x.getCourseCode().equals(CS5004) || x.getCourseCode().equals(CS5008));
  }

  private Map<String, CourseStatistics> computeCollegeCoursesStatistics(List<Student> students) {
    Map<String, Integer> allStudentsCourseCount = new HashMap<>();
    Map<String, Float> allStudentGradeSum = new HashMap<>();
    Map<String, Integer> alignStudentsCourseCount = new HashMap<>();
    Map<String, Float> alignStudentGradeSum = new HashMap<>();
    for (Student student : students) {
      for (Course course : student.getTakenCourses()) {
        String courseName = course.getCourseName();
        allStudentsCourseCount.put(courseName,
            allStudentsCourseCount.getOrDefault(courseName, 0) + 1);
        allStudentGradeSum.put(courseName,
            allStudentGradeSum.getOrDefault(courseName, 0f) + course.getGrade());
        if (isAlignStudent(student)) {
          alignStudentsCourseCount.put(courseName,
              alignStudentsCourseCount.getOrDefault(courseName, 0) + 1);
          alignStudentGradeSum.put(courseName,
              alignStudentGradeSum.getOrDefault(courseName, 0f) + course.getGrade());
        }
      }

    }
    Map<String, CourseStatistics> map = new HashMap<>();
    for (String courseName : allStudentsCourseCount.keySet()) {
      float avgGradeOfStudents =
          allStudentGradeSum.get(courseName) / allStudentsCourseCount.get(courseName);
      float avgGradeOfAlignStudents =
          alignStudentsCourseCount.containsKey(courseName) ? alignStudentGradeSum.get(courseName)
              / alignStudentsCourseCount.get(courseName) : 0;
      CourseStatistics courseStatistics = new CourseStatistics(
          allStudentsCourseCount.get(courseName),
          alignStudentsCourseCount.getOrDefault(courseName, 0),
          avgGradeOfStudents,
          avgGradeOfAlignStudents);
      map.put(courseName, courseStatistics);
    }
    return map;
  }

  public List<Course> recommendCourses(Student student)
      throws RecommendedCoursesNotEnoughException {
    Map<String, Course> recommendCourses = new HashMap<>();
    PriorityQueue<Object[]> mostTakenCourses = new PriorityQueue<>(
        (a, b) -> Integer.compare((Integer) b[1], (Integer) a[1])
    );
    PriorityQueue<Object[]> highestAverageGradeCourses = new PriorityQueue<>(
        (a, b) -> Float.compare((Float) b[1], (Float) a[1])
    );
    PriorityQueue<Object[]> leastTakenCourses = new PriorityQueue<>(
        Comparator.comparingInt(a -> (Integer) a[1])
    );
    // put each course to the three priority queues
    for (String courseName : this.map.keySet()) {
      mostTakenCourses.offer(new Object[]{courseName, this.map.get(courseName).getNumOfStudents()});
      highestAverageGradeCourses.offer(
          new Object[]{courseName, this.map.get(courseName).getAvgGradeOfStudents()});
      leastTakenCourses.offer(
          new Object[]{courseName, this.map.get(courseName).getNumOfStudents()});
    }
    // The first recommended course is the first course taken by the most students in the college, that the student has not yet taken
    recommendCourse(student, recommendCourses, mostTakenCourses);
    // The second recommended courses is the course with the highest average grade that the student has not already taken
    recommendCourse(student, recommendCourses, highestAverageGradeCourses);
    // The third recommended course is the first course taken by the least students in the college, that the student has not yet taken
    recommendCourse(student, recommendCourses, leastTakenCourses);
    // if there are not enough courses to recommend, throw exception
    if (recommendCourses.size() < RECOMMEND_THRESHOLD) {
      throw new RecommendedCoursesNotEnoughException("There are not enough courses to recommend!");
    }
    // get all the courses
    Set<Course> allCourses = this.students.stream().flatMap(x -> x.getTakenCourses().stream())
        .collect(Collectors.toSet());
    // map course name to course object
    for (Course course : allCourses) {
      if (recommendCourses.containsKey(course.getCourseName())) {
        recommendCourses.put(course.getCourseName(), course);
      }
    }
    // return recommended course objects which are the values of the recommendCourses map
    return (List<Course>) recommendCourses.values();
  }

  private void recommendCourse(Student student, Map<String, Course> recommendCourses,
      PriorityQueue<Object[]> PQ) {
    while (PQ.size() > 0) {
      Object[] courseObj = PQ.poll();
      String courseName = (String) courseObj[0];
      // get the first one in the priority queue that the student has not taken yet
      if (student.getTakenCourses().stream().noneMatch(x -> x.getCourseName().equals(courseName))) {
        recommendCourses.put(courseName, null);
        break;
      }
    }
  }

  public List<Student> getStudents() {
    return students;
  }

  public List<Student> getAlignStudents() {
    return alignStudents;
  }

  public Map<String, CourseStatistics> getMap() {
    return map;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CourseRecommender that = (CourseRecommender) o;
    return Objects.equals(students, that.students) && Objects.equals(
        alignStudents, that.alignStudents) && Objects.equals(map, that.map);
  }

  @Override
  public int hashCode() {
    return Objects.hash(students, alignStudents, map);
  }

  @Override
  public String toString() {
    return "CourseRecommender{" +
        "students=" + students +
        ", alignStudents=" + alignStudents +
        ", map=" + map +
        '}';
  }
}
