package problem1and2;

import java.util.Objects;

public class TripReport {

  private Vehicle vehicleThatTookTheTrip;
  private Float speed;
  private Float distance;
  private Integer tripDuration;

  public TripReport(Vehicle vehicleThatTookTheTrip, Float speed, Float distance,
      Integer tripDuration) {
    this.vehicleThatTookTheTrip = vehicleThatTookTheTrip;
    this.speed = speed;
    this.distance = distance;
    this.tripDuration = tripDuration;
  }

  public Vehicle getVehicleThatTookTheTrip() {
    return vehicleThatTookTheTrip;
  }

  public Float getSpeed() {
    return speed;
  }

  public Float getDistance() {
    return distance;
  }

  public Integer getTripDuration() {
    return tripDuration;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TripReport that = (TripReport) o;
    return Objects.equals(vehicleThatTookTheTrip, that.vehicleThatTookTheTrip)
        && Objects.equals(speed, that.speed) && Objects.equals(distance,
        that.distance) && Objects.equals(tripDuration, that.tripDuration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vehicleThatTookTheTrip, speed, distance, tripDuration);
  }
}
