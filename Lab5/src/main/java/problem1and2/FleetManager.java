package problem1and2;

public class FleetManager {

  public TripReport drive(float distance, Vehicle vehicle) {
    if (distance <= 0) {
      throw new IllegalArgumentException("Provided distance is invalid!");
    }
    if (vehicle.getAvgSpeed() <= 0) {
      throw new IllegalArgumentException("Provided vehicle's average speed is invalid!");
    }
      int tripDuration = Math.round(distance / vehicle.getAvgSpeed());
    return new TripReport(vehicle, vehicle.getAvgSpeed(), distance, tripDuration);
  }

  public TripReport drive(float distance, float speed, Vehicle vehicle) {
    if (distance <= 0) {
      throw new IllegalArgumentException("Provided distance is invalid!");
    }
    if (speed <= 0) {
      throw new IllegalArgumentException("Provided speed is invalid!");
    }
    if (speed > vehicle.getMaxSpeed()) {
      speed = vehicle.getMaxSpeed();
    }
    int tripDuration = Math.round(distance / speed);
    return new TripReport(vehicle, speed, distance, tripDuration);
  }

  public TripReport drive(float distance, Vehicle vehicle, float speed, int duration) {
    if (distance > 0 && speed > 0 && speed <= vehicle.getMaxSpeed() && duration >= 0 && duration == Math.round(distance / speed)) {
      return new TripReport(vehicle, speed, distance, duration);
    } else {
      throw new IllegalArgumentException("The trip information is not correct!");
    }
  }

  public TripReport drive(Vehicle vehicle, int duration) {
    if (duration < 0) {
      throw new IllegalArgumentException("Provided duration is invalid!");
    }
    if (vehicle.getAvgSpeed() <= 0) {
      throw new IllegalArgumentException("Provided vehicle's average speed is invalid!");
    }
    float distance = duration * vehicle.getAvgSpeed();
    return new TripReport(vehicle, vehicle.getAvgSpeed(), distance, duration);
  }
}
