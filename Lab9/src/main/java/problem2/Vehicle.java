package problem2;

import java.util.Objects;

public class Vehicle {
  private String make;
  private String model;
  private Integer year;
  private Color vehicleColor;
  /*
  • * Constructor for an object Vehicle, based on the provided input arguments.
  • * @param make - String, make of a vehicle
  • * @param model - String, make of a vehicle
  • * @param year - Integer, year of the vehicle (expected to
  be in the range 1950-2020)
  • * @param vehicleColor - Color, color of a vehicle */
  public Vehicle(String make, String model, Integer year, Color vehicleColor){
    this.make = make;
    this.model = model;
    this.year = year; this.vehicleColor = vehicleColor;
  }
  /*
   * Getter for the property ’make’
   * @returns value for property ’make’ (String)
   */
  public String getMake() { return make; }

  /*
   * Getter for the property ’model’
   * @returns value for property ’model’ (String)
   */
  public String getModel() { return model; }

  /*
   * Getter for the property ’year’
   * @returns value for property ’year’ (Integer in the range 1950- 2020) */
  public Integer getYear() { return year; }

  /*
   * Getter for the property ’vehicleColor’
   * @returns value for property ’vehicleColor’ (Color)
   */
  public Color getVehicleColor() { return vehicleColor; }

  protected static void printMakeModelAndYear(Vehicle vehicle){
    System.out.println(
        "Make=’" + vehicle.getMake() + "’" +
        ", Model=’" + vehicle.getModel() + "'" +
        ", Year=" + vehicle.getYear());
  }

  protected Boolean isYoungerThanGivenYear(Integer year){
    return this.getYear() > year;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Vehicle)) return false;
    Vehicle vehicle = (Vehicle) o;
    return Objects.equals(getMake(), vehicle.getMake());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getMake());
  }

  @Override
  public String toString() {
    return "Vehicle{" +
        "make=’" + make + "’" +
        ", model=’" + model + "'" +
        ", year=" + year +
        ", vehicleColor=" + vehicleColor + "}";
  }
}

