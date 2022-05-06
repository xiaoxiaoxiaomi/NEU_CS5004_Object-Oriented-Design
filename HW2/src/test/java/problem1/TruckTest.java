package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TruckTest {

  Truck testTruck;

  @BeforeEach
  void setUp() throws DailyPriceNumericException, BookedDaysNumericException {
    testTruck = new Truck(100.0, 0);
  }

  @Test
  void getMaximumOccupancy() {
    assertEquals(2, testTruck.getMaximumOccupancy());
  }

  @Test
  void getRequireSpecializedLicense() {
    assertEquals(true, testTruck.getRequireSpecializedLicense());
  }

  @Test
  void getAllowDifferentPickupAndDropoffLocations() {
    assertEquals(false, testTruck.getAllowDifferentPickupAndDropoffLocations());
  }

  @Test
  void bookVehicle() throws BookedDaysNumericException {
    assertTrue(testTruck.bookVehicle(2, 1, "Seattle", "Seattle", true));
    assertEquals(2, testTruck.getBookedDays());
    assertFalse(testTruck.bookVehicle(1, 1, "Seattle", "Seattle", true));
    testTruck.setBookedDays(0);
    assertFalse(testTruck.bookVehicle(2, 0, "Seattle", "Seattle", true));
    assertFalse(testTruck.bookVehicle(2, 3, "Seattle", "Seattle", true));
    assertFalse(testTruck.bookVehicle(2, 1, "Seattle", "Boston", true));
    assertFalse(testTruck.bookVehicle(2, 1, "Seattle", "Seattle", false));
  }
}