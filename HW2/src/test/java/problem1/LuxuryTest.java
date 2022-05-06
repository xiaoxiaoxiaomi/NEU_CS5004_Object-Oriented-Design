package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LuxuryTest {

  Luxury testLuxury;

  @BeforeEach
  void setUp() throws DailyPriceNumericException, BookedDaysNumericException {
    testLuxury = new Luxury(150.0, 0);
  }

  @Test
  void getMaximumOccupancy() {
    assertEquals(4, testLuxury.getMaximumOccupancy());
  }

  @Test
  void getRequireSpecializedLicense() {
    assertEquals(false, testLuxury.getRequireSpecializedLicense());
  }

  @Test
  void getAllowDifferentPickupAndDropoffLocations() {
    assertEquals(false, testLuxury.getAllowDifferentPickupAndDropoffLocations());
  }

  @Test
  void bookVehicle() throws BookedDaysNumericException {
    assertTrue(testLuxury.bookVehicle(3,3, "Seattle", "Seattle", true));
    assertEquals(3, testLuxury.getBookedDays());
    assertFalse(testLuxury.bookVehicle(3,3, "Seattle", "Seattle", true));
    testLuxury.setBookedDays(0);
    assertFalse(testLuxury.bookVehicle(3,0, "Seattle", "Seattle", true));
    assertFalse(testLuxury.bookVehicle(3,5, "Seattle", "Seattle", true));
    assertFalse(testLuxury.bookVehicle(3,3, "Seattle", "Boston", true));
  }
}