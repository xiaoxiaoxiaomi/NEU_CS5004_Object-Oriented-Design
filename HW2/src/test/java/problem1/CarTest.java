package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {

  Car testCar;

  @BeforeEach
  void setUp() throws DailyPriceNumericException, BookedDaysNumericException {
    testCar = new Car(80.0, 0);
  }

  @Test
  void getMaximumOccupancy() {
    assertEquals(5, testCar.getMaximumOccupancy());
  }

  @Test
  void getRequireSpecializedLicense() {
    assertEquals(false, testCar.getRequireSpecializedLicense());
  }

  @Test
  void getAllowDifferentPickupAndDropoffLocations() {
    assertEquals(true, testCar.getAllowDifferentPickupAndDropoffLocations());
  }

  @Test
  void bookVehicle() throws BookedDaysNumericException {
    assertTrue(testCar.bookVehicle(7, 4, "Seattle", "Boston", false));
    assertEquals(7, testCar.getBookedDays());
    assertFalse(testCar.bookVehicle(1, 1, "Seattle", "Seattle", true));
    testCar.setBookedDays(0);
    assertFalse(testCar.bookVehicle(7, 0, "Seattle", "Boston", false));
    assertFalse(testCar.bookVehicle(7, 6, "Seattle", "Boston", false));
  }
}