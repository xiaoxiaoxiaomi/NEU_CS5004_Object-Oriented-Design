package midterm.p2;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

/*
Class NationalPark contain information about an individual US national park
 */
public class NationalPark {

  private String nationalParkID;
  private String nationalParkName;
  private String state;
  private Double area;
  private LocalDate dateParkFounded;
  private String[] visitorCenters;
  private Boolean openYearRound;

  public NationalPark(String nationalParkID, String nationalParkName, String state, Double area,
                      LocalDate dateParkFounded, String[] visitorCenters, Boolean openYearRound) {
    this.nationalParkID = nationalParkID;
    this.nationalParkName = nationalParkName;
    this.state = state;
    this.area = area;
    this.dateParkFounded = dateParkFounded;
    this.visitorCenters = visitorCenters;
    this.openYearRound = openYearRound;
  }

  public String getNationalParkID() {
    return nationalParkID;
  }

  public String getNationalParkName() {
    return nationalParkName;
  }

  public String getState() {
    return state;
  }

  public Double getArea() {
    return area;
  }

  public LocalDate getDateParkFounded() {
    return dateParkFounded;
  }

  public String[] getVisitorCenters() {
    return visitorCenters;
  }

  public Boolean getOpenYearRound() {
    return openYearRound;
  }

  public void setArea(Double area) {
    this.area = area;
  }

  public void setVisitorCenters(String[] visitorCenters) {
    this.visitorCenters = visitorCenters;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof NationalPark)) return false;
    NationalPark that = (NationalPark) o;
    return Objects.equals(getNationalParkID(), that.getNationalParkID()) &&
        Objects.equals(getNationalParkName(), that.getNationalParkName()) &&
        Objects.equals(getState(), that.getState()) &&
        Objects.equals(getArea(), that.getArea()) &&
        Objects.equals(getDateParkFounded(), that.getDateParkFounded()) &&
        Arrays.equals(getVisitorCenters(), that.getVisitorCenters()) &&
        Objects.equals(getOpenYearRound(), that.getOpenYearRound());
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(getNationalParkID(), getNationalParkName(),
        getState(), getArea(), getDateParkFounded(), getOpenYearRound());
    result = 31 * result + Arrays.hashCode(getVisitorCenters());
    return result;
  }

  @Override
  public String toString() {
    return "NationalPark{" +
        "nationalParkID='" + nationalParkID + '\'' +
        ", nationalParkName='" + nationalParkName + '\'' +
        ", state='" + state + '\'' +
        ", area=" + area +
        ", dateParkFounded=" + dateParkFounded +
        ", visitorCenters=" + Arrays.toString(visitorCenters) +
        ", openYearRound=" + openYearRound +
        '}';
  }
}
