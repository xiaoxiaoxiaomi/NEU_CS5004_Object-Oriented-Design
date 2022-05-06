package problem2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OlderVehiclesFilter {

  private static Integer FILTER_YEAR = 1999;
  private List<Vehicle> vehicles = new ArrayList<>();

  public OlderVehiclesFilter(List<Vehicle> vehicles) {
    this.vehicles = vehicles;
  }

  public OlderVehiclesFilter(Vehicle vehicle1, Vehicle vehicle2, Vehicle vehicle3) {
    this.vehicles.add(vehicle1);
    this.vehicles.add(vehicle2);
    this.vehicles.add(vehicle2);
  }

  /**
   * Method filters out all vehicles manufactured before 1999. For the remaining vehicles, method
   * prints their make, model and manufacturing year.
   */
  public void filterOlderVehicle_partialFunctionalCode() {
    List<Vehicle> youngerVehicles = new ArrayList<>();
    youngerVehicles = vehicles.stream().filter(x -> x.isYoungerThanGivenYear(FILTER_YEAR)).collect(
        Collectors.toList());
    for (Vehicle vehicle : youngerVehicles) {
      System.out.println(
          vehicle.getMake() + " " + vehicle.getModel() + " " + vehicle.getYear().toString());
    }
  }

  /**
   * Method filters out all vehicles manufactured before 1999. For the remaining vehicles, method
   * prints their make, model and manufacturing year.
   */
  public void filterOlderVehicle_filteringAndMapping() {
    System.out.println(vehicles.stream().filter(x -> x.isYoungerThanGivenYear(FILTER_YEAR))
        .map(x -> x.getMake() + " " + x.getModel() + " " + x.getYear().toString())
        .collect(Collectors.toList()));
  }

  /**
   * Method filters out all vehicles manufactured before 1999. For the remaining vehicles, method
   * prints their make, model and manufacturing year.
   */
  public void filterOlderVehicle_helperMethod() {
    vehicles.stream().filter(x -> x.isYoungerThanGivenYear(FILTER_YEAR))
        .forEach(vehicle -> Vehicle.printMakeModelAndYear(vehicle));
  }


  public List<String> filterVWvehilces() {
    //YOUR CODE HERE
    return null;
  }
}