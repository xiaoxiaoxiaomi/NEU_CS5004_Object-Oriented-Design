package problem1;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VehicleTest {

  Vehicle testVehicle;

  @BeforeEach
  void setUp() throws DailyPriceNumericException, BookedDaysNumericException {
    testVehicle = new Vehicle(100.0, 10);
  }

  @Test
  void testVehicleConstructor() {
    assertThrows(DailyPriceNumericException.class, () -> {
      new Vehicle(0.0, 10);
    });
    assertThrows(BookedDaysNumericException.class, () -> {
      new Vehicle(100.0, -1);
    });
  }

  @Test
  void getDailyPrice() {
    assertEquals(100.0, testVehicle.getDailyPrice());
  }

  @Test
  void getBookedDays() {
    assertEquals(10, testVehicle.getBookedDays());
  }

  @Test
  void setBookedDays() throws BookedDaysNumericException {
    testVehicle.setBookedDays(5);
    assertEquals(5, testVehicle.getBookedDays());
    assertThrows(BookedDaysNumericException.class, () -> {
      testVehicle.setBookedDays(-1);
    });
  }

  @Test
  void isAvailable() throws BookedDaysNumericException {
    assertEquals(false, testVehicle.isAvailable());
    testVehicle.setBookedDays(0);
    assertEquals(true, testVehicle.isAvailable());
  }
}