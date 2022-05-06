package P3;

import java.util.Objects;

public class CourseStatistics {

  private Integer numOfStudents;
  private Integer numOfAlignStudents;
  private Float avgGradeOfStudents;
  private Float avgGradeOfAlignStudents;

  public CourseStatistics(Integer numOfStudents, Integer numOfAlignStudents,
      Float avgGradeOfStudents, Float avgGradeOfAlignStudents) {
    this.numOfStudents = numOfStudents;
    this.numOfAlignStudents = numOfAlignStudents;
    this.avgGradeOfStudents = avgGradeOfStudents;
    this.avgGradeOfAlignStudents = avgGradeOfAlignStudents;
  }

  public Integer getNumOfStudents() {
    return numOfStudents;
  }

  public Integer getNumOfAlignStudents() {
    return numOfAlignStudents;
  }

  public Float getAvgGradeOfStudents() {
    return avgGradeOfStudents;
  }

  public Float getAvgGradeOfAlignStudents() {
    return avgGradeOfAlignStudents;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CourseStatistics that = (CourseStatistics) o;
    return Objects.equals(numOfStudents, that.numOfStudents) && Objects.equals(
        numOfAlignStudents, that.numOfAlignStudents) && Objects.equals(avgGradeOfStudents,
        that.avgGradeOfStudents) && Objects.equals(avgGradeOfAlignStudents,
        that.avgGradeOfAlignStudents);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numOfStudents, numOfAlignStudents, avgGradeOfStudents,
        avgGradeOfAlignStudents);
  }

  @Override
  public String toString() {
    return "CourseStatistics{" +
        "numOfStudents=" + numOfStudents +
        ", numOfAlignStudents=" + numOfAlignStudents +
        ", avgGradeOfStudents=" + avgGradeOfStudents +
        ", avgGradeOfAlignStudents=" + avgGradeOfAlignStudents +
        '}';
  }
}
