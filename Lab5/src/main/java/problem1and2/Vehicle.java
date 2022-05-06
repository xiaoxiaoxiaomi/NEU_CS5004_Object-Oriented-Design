package problem1and2;

import java.util.Objects;

public abstract class Vehicle {

  protected String ID;
  protected Float avgSpeed;
  protected Float maxSpeed;

  public Vehicle(String ID, Float avgSpeed, Float maxSpeed) {
    this.ID = ID;
    this.avgSpeed = avgSpeed;
    this.maxSpeed = maxSpeed;
  }

  public String getID() {
    return ID;
  }

  public Float getAvgSpeed() {
    return avgSpeed;
  }

  public Float getMaxSpeed() {
    return maxSpeed;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Vehicle vehicle = (Vehicle) o;
    return Objects.equals(ID, vehicle.ID) && Objects.equals(avgSpeed,
        vehicle.avgSpeed) && Objects.equals(maxSpeed, vehicle.maxSpeed);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ID, avgSpeed, maxSpeed);
  }
}
