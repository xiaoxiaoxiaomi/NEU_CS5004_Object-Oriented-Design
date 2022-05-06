package P3;

import java.util.List;
import java.util.Objects;

/*
Class Student contains information about a student - students name and their studentID, academic program a student is
enrolled into, as well as the list of courses the student has taken.
 */
public class Student {

  private Name name;
  private String studentID;
  private String academicProgram;
  private List<Course> takenCourses;

  public Student(Name name, String studentID, String academicProgram, List<Course> takenCourses) {
    this.name = name;
    this.studentID = studentID;
    this.academicProgram = academicProgram;
    this.takenCourses = takenCourses;
  }

  public Name getName() {
    return name;
  }

  public String getStudentID() {
    return studentID;
  }

  public String getAcademicProgram() {
    return academicProgram;
  }

  public List<Course> getTakenCourses() {
    return takenCourses;
  }

  public Float getGPA() {
    Float gradeSum = 0f;
    for (Course course : this.takenCourses) {
      gradeSum += course.getGrade();
    }
    return gradeSum / this.takenCourses.size();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Student)) {
      return false;
    }
    Student student = (Student) o;
    return Objects.equals(getName(), student.getName()) &&
        Objects.equals(getStudentID(), student.getStudentID()) &&
        Objects.equals(getAcademicProgram(), student.getAcademicProgram()) &&
        Objects.equals(getTakenCourses(), student.getTakenCourses());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getStudentID(), getAcademicProgram(), getTakenCourses());
  }

  @Override
  public String toString() {
    return "Student{" +
        "name=" + name +
        ", studentID='" + studentID + '\'' +
        ", academicProgram='" + academicProgram + '\'' +
        ", takenCourses=" + takenCourses +
        '}';
  }
}
