package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VanTest {

  Van testVan;

  @BeforeEach
  void setUp() throws DailyPriceNumericException, BookedDaysNumericException {
    testVan = new Van(120.0, 0);
  }

  @Test
  void getMaximumOccupancy() {
    assertEquals(8, testVan.getMaximumOccupancy());
  }

  @Test
  void getRequireSpecializedLicense() {
    assertEquals(false, testVan.getRequireSpecializedLicense());
  }

  @Test
  void getAllowDifferentPickupAndDropoffLocations() {
    assertEquals(false, testVan.getAllowDifferentPickupAndDropoffLocations());
  }

  @Test
  void bookVehicle() throws BookedDaysNumericException {
    assertTrue(testVan.bookVehicle(1, 6, "Seattle", "Seattle", false));
    assertEquals(1, testVan.getBookedDays());
    assertFalse(testVan.bookVehicle(1, 6, "Seattle", "Seattle", false));
    testVan.setBookedDays(0);
    assertFalse(testVan.bookVehicle(1, 0, "Seattle", "Seattle", false));
    assertFalse(testVan.bookVehicle(1, 9, "Seattle", "Seattle", false));
    assertFalse(testVan.bookVehicle(1, 6, "Seattle", "Boston", false));
  }
}