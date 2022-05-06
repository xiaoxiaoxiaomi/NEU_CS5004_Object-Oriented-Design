package midterm.p2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class NationalParkDirectoryTest {

  NationalPark testNationalPark1;
  NationalPark testNationalPark2;
  NationalPark testNationalPark3;
  NationalParkDirectory testDirectory;

  @BeforeEach
  void setUp() {
    testNationalPark1 = new NationalPark("ID1", "Name1", "WA", 10000.0, LocalDate.of(2001, 1, 1),
        new String[]{"center1", "center2"}, false);
    testNationalPark2 = new NationalPark("ID2", "Name2", "WA", 20000.0, LocalDate.of(2002, 2, 2),
        new String[]{"center3", "center4", "center5"}, true);
    testNationalPark3 = new NationalPark("ID3", "Name3", "WA", 30000.0, LocalDate.of(2003, 3, 3),
        new String[]{"center6", "center7", "center8", "center9"}, true);
    testDirectory = new NationalParkDirectory();
    testDirectory.add(testNationalPark1);
    testDirectory.add(testNationalPark2);
    testDirectory.add(testNationalPark3);
  }

  @Test
  void count() {
    assertEquals(3, this.testDirectory.count());
  }

  @Test
  void add() {
    NationalPark testNationalPark4 = new NationalPark("ID4", "Name4", "WA", 10000.0,
        LocalDate.of(2004, 4, 4),
        new String[]{"center10", "center11"}, false);
    this.testDirectory.add(testNationalPark4);
    assertTrue(this.testDirectory.contains(testNationalPark4));
    this.testDirectory.add(testNationalPark4);
  }

  @Test
  void allNationalParkOpenedYearRound() {
    NationalPark[] expectedArr = new NationalPark[]{testNationalPark2, testNationalPark3};
    assertArrayEquals(expectedArr, this.testDirectory.allNationalParkOpenedYearRound());
  }

  @Test
  void getNationalParkByID() throws InvalidNationalParkIDException {
    assertEquals(testNationalPark2, this.testDirectory.getNationalParkByID("ID2"));
    assertThrows(InvalidNationalParkIDException.class, () -> {
      this.testDirectory.getNationalParkByID("ID4");
    });
  }
}