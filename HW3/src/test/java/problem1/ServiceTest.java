package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ServiceTest {

  private Cleaning testCleaning;
  private Painting testPainting;
  private Gardening testGardening;
  private WindowCleaning testWindowCleaning;
  private RoofAndGutterCleaning testRoofAndGutterCleaning;
  private Electrical testElectrical;
  private Plumbing testPlumbing;
  private Plumbing testPlumbing2;
  private InternetTVComputing testInternetTVComputing;

  @BeforeEach
  void setUp()
      throws PetsNegativeException, FloorsExceedException, FloorsNonPositiveException, RoofSquareFootageNonPositiveException, EmployeesExceedException {
    testCleaning = new Cleaning("1629 Stockert Hollow Road", PropertySize.SMALL, false, 1, 0);
    testPainting = new Painting("3004 Libby Street", PropertySize.LARGE, false, 9, 1);
    testGardening = new Gardening("4432 Davisson Street", PropertySize.MEDIUM, true, 5);
    testWindowCleaning = new WindowCleaning("478 Wilkinson Court", PropertySize.LARGE, false, 2, 3);
    testRoofAndGutterCleaning = new RoofAndGutterCleaning("3034 Hart Street", PropertySize.MEDIUM,
        false, 0, 1000.0, RoofType.FLAT_AND_HIP_ROOF);
    testElectrical = new Electrical("1675 Godfrey Road", PropertySize.SMALL, false, 4, 1, true);
    testPlumbing = new Plumbing("1297 Hillcrest Lane", PropertySize.LARGE, false, 7, 2, true);
    testPlumbing2 = new Plumbing("1297 Hillcrest Lane", PropertySize.LARGE, false, 7, 3, true);
    testInternetTVComputing = new InternetTVComputing("3102 Rainbow Drive", PropertySize.MEDIUM,
        false, 3, 0, false);
  }

  @Test
  void testConstructor() {
    // Cleaning
    assertThrows(PetsNegativeException.class, () -> {
      new Cleaning("1629 Stockert Hollow Road", PropertySize.SMALL, false, 1, -1);
    });
    // WindowCleaning
    assertThrows(FloorsExceedException.class, () -> {
      new WindowCleaning("478 Wilkinson Court", PropertySize.LARGE, false, 2, 4);
    });
    assertThrows(FloorsNonPositiveException.class, () -> {
      new WindowCleaning("478 Wilkinson Court", PropertySize.SMALL, false, 2, 0);
    });
    // RoofAndGutterCleaning
    assertThrows(RoofSquareFootageNonPositiveException.class, () -> {
      new RoofAndGutterCleaning("3034 Hart Street", PropertySize.MEDIUM, false, 0, 0.0,
          RoofType.MANSARD);
    });
    // Electrical
    assertThrows(EmployeesExceedException.class, () -> {
      new Electrical("1675 Godfrey Road", PropertySize.SMALL, false, 4, 5, false);
    });
    // InternetTVComputing
    assertThrows(EmployeesExceedException.class, () -> {
      new InternetTVComputing("3102 Rainbow Drive", PropertySize.MEDIUM, false, 3, 3, false);
    });
  }

  @Test
  void getPropertyAddress() {
    assertEquals("1629 Stockert Hollow Road", testCleaning.getPropertyAddress());
  }

  @Test
  void getPropertySize() {
    assertEquals(PropertySize.SMALL, testCleaning.getPropertySize());
  }

  @Test
  void getMonthly() {
    assertEquals(false, testCleaning.getMonthly());
  }

  @Test
  void getNumberOfPastServices() {
    assertEquals(1, testCleaning.getNumberOfPastServices());
  }

  @Test
  void calculatePrice()
      throws PetsNegativeException, FloorsExceedException, FloorsNonPositiveException, RoofSquareFootageNonPositiveException {
    // Cleaning
    assertEquals(80, testCleaning.calculatePrice());
    Cleaning testCleaning2 = new Cleaning("1629 Stockert Hollow Road", PropertySize.MEDIUM, false,
        1, 2);
    assertEquals(168, testCleaning2.calculatePrice());
    Cleaning testCleaning3 = new Cleaning("1629 Stockert Hollow Road", PropertySize.LARGE, true, 1,
        3);
    assertEquals(308.16, testCleaning3.calculatePrice());
    // Painting
    assertEquals(1008, testPainting.calculatePrice());
    Painting testPainting2 = new Painting("3004 Libby Street", PropertySize.MEDIUM, true, 9, 1);
    assertEquals(672, testPainting2.calculatePrice());
    // Gardening
    assertEquals(162, testGardening.calculatePrice());
    // WindowCleaning
    assertEquals(336, testWindowCleaning.calculatePrice());
    WindowCleaning testWindowCleaning2 = new WindowCleaning("478 Wilkinson Court",
        PropertySize.LARGE, false, 2, 1);
    assertEquals(320, testWindowCleaning2.calculatePrice());
    // RoofAndGutterCleaning
    assertEquals(160, testRoofAndGutterCleaning.calculatePrice());
    RoofAndGutterCleaning testRoofAndGutterCleaning2 = new RoofAndGutterCleaning("3034 Hart Street",
        PropertySize.LARGE, true, 0, 3100.0, RoofType.MANSARD);
    assertEquals(648, testRoofAndGutterCleaning2.calculatePrice());
    // Electrical
    assertEquals(450, testElectrical.calculatePrice());
    // Plumbing
    assertEquals(620, testPlumbing.calculatePrice());
    // InternetTVComputing
    assertEquals(215, testInternetTVComputing.calculatePrice());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testCleaning.equals(testCleaning));
    assertTrue(testGardening.equals(testGardening));
    assertTrue(testWindowCleaning.equals(testWindowCleaning));
    assertTrue(testRoofAndGutterCleaning.equals(testRoofAndGutterCleaning));
    assertTrue(testElectrical.equals(testElectrical));
  }

  @Test
  void testEquals_DifferentObject() {
    assertFalse(testCleaning.equals(testPainting));
    assertFalse(testGardening.equals(testWindowCleaning));
    assertFalse(testWindowCleaning.equals(testGardening));
    assertFalse(testRoofAndGutterCleaning.equals(testGardening));
    assertFalse(testElectrical.equals(testPlumbing));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testCleaning.equals(null));
    assertFalse(testGardening.equals(null));
    assertFalse(testWindowCleaning.equals(null));
    assertFalse(testRoofAndGutterCleaning.equals(null));
    assertFalse(testElectrical.equals(null));
  }

  @Test
  void testEquals_DifferentPropertyAddress()
      throws PetsNegativeException, FloorsExceedException, FloorsNonPositiveException, RoofSquareFootageNonPositiveException, EmployeesExceedException {
    Cleaning myOtherCleaning = new Cleaning("4401 Stoney Lane", PropertySize.SMALL, false, 1, 0);
    assertFalse(testCleaning.equals(myOtherCleaning));
    Gardening myOtherGardening = new Gardening("4401 Stoney Lane", PropertySize.MEDIUM, true, 5);
    assertFalse(testGardening.equals(myOtherGardening));
    WindowCleaning otherWindowCleaning = new WindowCleaning("4401 Stoney Lane", PropertySize.LARGE,
        false, 2, 3);
    assertFalse(testWindowCleaning.equals(otherWindowCleaning));
    RoofAndGutterCleaning myOtherRoofAndGutterCleaning = new RoofAndGutterCleaning("4401 Stoney Lane", PropertySize.MEDIUM,
        false, 0, 1000.0, RoofType.FLAT_AND_HIP_ROOF);
    assertFalse(testRoofAndGutterCleaning.equals(myOtherRoofAndGutterCleaning));
    Electrical myOtherElectrical = new Electrical("4401 Stoney Lane", PropertySize.SMALL, false, 4, 1, true);
    assertFalse(testElectrical.equals(myOtherElectrical));
  }

  @Test
  void testEquals_DifferentPropertySize()
      throws PetsNegativeException, FloorsExceedException, FloorsNonPositiveException, RoofSquareFootageNonPositiveException, EmployeesExceedException {
    Cleaning myOtherCleaning = new Cleaning("1629 Stockert Hollow Road", PropertySize.MEDIUM, false,
        1, 0);
    assertFalse(testCleaning.equals(myOtherCleaning));
    Gardening myOtherGardening = new Gardening("4432 Davisson Street", PropertySize.LARGE, true, 5);
    assertFalse(testGardening.equals(myOtherGardening));
    WindowCleaning otherWindowCleaning = new WindowCleaning("478 Wilkinson Court",
        PropertySize.MEDIUM, false, 2, 3);
    assertFalse(testWindowCleaning.equals(otherWindowCleaning));
    RoofAndGutterCleaning myOtherRoofAndGutterCleaning = new RoofAndGutterCleaning("3034 Hart Street", PropertySize.LARGE,
        false, 0, 1000.0, RoofType.FLAT_AND_HIP_ROOF);
    assertFalse(testRoofAndGutterCleaning.equals(myOtherRoofAndGutterCleaning));
    Electrical myOtherElectrical = new Electrical("1675 Godfrey Road", PropertySize.MEDIUM, false, 4, 1, true);
    assertFalse(testElectrical.equals(myOtherElectrical));
  }

  @Test
  void testEquals_DifferentIsMonthly()
      throws PetsNegativeException, FloorsExceedException, FloorsNonPositiveException, RoofSquareFootageNonPositiveException, EmployeesExceedException {
    Cleaning myOtherCleaning = new Cleaning("1629 Stockert Hollow Road", PropertySize.SMALL, true,
        1, 0);
    assertFalse(testCleaning.equals(myOtherCleaning));
    Gardening myOtherGardening = new Gardening("4432 Davisson Street", PropertySize.MEDIUM, false, 5);
    assertFalse(testGardening.equals(myOtherGardening));
    WindowCleaning otherWindowCleaning = new WindowCleaning("478 Wilkinson Court",
        PropertySize.LARGE, true, 2, 3);
    assertFalse(testWindowCleaning.equals(otherWindowCleaning));
    RoofAndGutterCleaning myOtherRoofAndGutterCleaning = new RoofAndGutterCleaning("3034 Hart Street", PropertySize.MEDIUM,
        true, 0, 1000.0, RoofType.FLAT_AND_HIP_ROOF);
    assertFalse(testRoofAndGutterCleaning.equals(myOtherRoofAndGutterCleaning));
    Electrical myOtherElectrical = new Electrical("1675 Godfrey Road", PropertySize.SMALL, true, 4, 1, true);
    assertFalse(testElectrical.equals(myOtherElectrical));
  }

  @Test
  void testEquals_DifferentNumberOfPastServices()
      throws PetsNegativeException, FloorsExceedException, FloorsNonPositiveException, RoofSquareFootageNonPositiveException, EmployeesExceedException {
    Cleaning myOtherCleaning = new Cleaning("1629 Stockert Hollow Road", PropertySize.SMALL, false,
        2, 0);
    assertFalse(testCleaning.equals(myOtherCleaning));
    Gardening myOtherGardening = new Gardening("4432 Davisson Street", PropertySize.MEDIUM, true, 6);
    assertFalse(testGardening.equals(myOtherGardening));
    WindowCleaning otherWindowCleaning = new WindowCleaning("478 Wilkinson Court",
        PropertySize.LARGE, false, 0, 3);
    assertFalse(testWindowCleaning.equals(otherWindowCleaning));
    RoofAndGutterCleaning myOtherRoofAndGutterCleaning = new RoofAndGutterCleaning("3034 Hart Street", PropertySize.MEDIUM,
        false, 1, 1000.0, RoofType.FLAT_AND_HIP_ROOF);
    assertFalse(testRoofAndGutterCleaning.equals(myOtherRoofAndGutterCleaning));
    Electrical myOtherElectrical = new Electrical("1675 Godfrey Road", PropertySize.SMALL, false, 5, 1, true);
    assertFalse(testElectrical.equals(myOtherElectrical));
  }

  @Test
  void testEquals_DifferentNumberOfPets() throws PetsNegativeException {
    Cleaning myOtherCleaning = new Cleaning("1629 Stockert Hollow Road", PropertySize.SMALL, false,
        1, 1);
    assertFalse(testCleaning.equals(myOtherCleaning));
  }

  @Test
  void testEquals_DifferentNumberOfFloors()
      throws FloorsExceedException, FloorsNonPositiveException {
    WindowCleaning otherWindowCleaning = new WindowCleaning("478 Wilkinson Court",
        PropertySize.LARGE, false, 2, 2);
    assertFalse(testWindowCleaning.equals(otherWindowCleaning));
  }

  @Test
  void testEquals_DifferentRoofSquareFootage() throws RoofSquareFootageNonPositiveException {
    RoofAndGutterCleaning myOtherRoofAndGutterCleaning = new RoofAndGutterCleaning("3034 Hart Street", PropertySize.MEDIUM,
        false, 0, 2000.0, RoofType.FLAT_AND_HIP_ROOF);
    assertFalse(testRoofAndGutterCleaning.equals(myOtherRoofAndGutterCleaning));
  }

  @Test
  void testEquals_DifferentRoofType() throws RoofSquareFootageNonPositiveException {
    RoofAndGutterCleaning myOtherRoofAndGutterCleaning = new RoofAndGutterCleaning("3034 Hart Street", PropertySize.MEDIUM,
        false, 0, 1000.0, RoofType.GABLE);
    assertFalse(testRoofAndGutterCleaning.equals(myOtherRoofAndGutterCleaning));
  }

  @Test
  void testEquals_DifferentNumberOfEmployees() throws EmployeesExceedException {
    Electrical myOtherElectrical = new Electrical("1675 Godfrey Road", PropertySize.SMALL, false, 4, 3, true);
    assertFalse(testElectrical.equals(myOtherElectrical));
  }

  @Test
  void testEquals_DifferentIfComplex() throws EmployeesExceedException {
    Electrical myOtherElectrical = new Electrical("1675 Godfrey Road", PropertySize.SMALL, false, 4, 1, false);
    assertFalse(testElectrical.equals(myOtherElectrical));
  }

  @Test
  void testEquals_DifferentNumberOfEmployeesAndIfComplex() throws EmployeesExceedException {
    Electrical myOtherElectrical = new Electrical("1675 Godfrey Road", PropertySize.SMALL, false, 4, 2, false);
    assertFalse(testElectrical.equals(myOtherElectrical));
  }

  @Test
  void testEquals_DifferentObjectsSameAttributes()
      throws PetsNegativeException, FloorsExceedException, FloorsNonPositiveException, RoofSquareFootageNonPositiveException, EmployeesExceedException {
    Cleaning myOtherCleaning = new Cleaning("1629 Stockert Hollow Road", PropertySize.SMALL, false,
        1, 0);
    assertTrue(testCleaning.equals(myOtherCleaning));
    Gardening myOtherGardening = new Gardening("4432 Davisson Street", PropertySize.MEDIUM, true, 5);
    assertTrue(testGardening.equals(myOtherGardening));
    WindowCleaning otherWindowCleaning = new WindowCleaning("478 Wilkinson Court",
        PropertySize.LARGE, false, 2, 3);
    assertTrue(testWindowCleaning.equals(otherWindowCleaning));
    RoofAndGutterCleaning myOtherRoofAndGutterCleaning = new RoofAndGutterCleaning("3034 Hart Street", PropertySize.MEDIUM,
        false, 0, 1000.0, RoofType.FLAT_AND_HIP_ROOF);
    assertTrue(testRoofAndGutterCleaning.equals(myOtherRoofAndGutterCleaning));
    Electrical myOtherElectrical = new Electrical("1675 Godfrey Road", PropertySize.SMALL, false, 4, 1, true);
    assertTrue(testElectrical.equals(myOtherElectrical));
  }

  @Test
  void testHashCode() {
    int expectedHashcode = Objects.hash("1629 Stockert Hollow Road", PropertySize.SMALL, false, 1);
    expectedHashcode = Objects.hash(expectedHashcode, 0);
    assertEquals(expectedHashcode, testCleaning.hashCode());
    int expectedHashcode2 = Objects.hash("4432 Davisson Street", PropertySize.MEDIUM, true, 5);
    assertEquals(expectedHashcode2, testGardening.hashCode());
    int expectedHashcode3 = Objects.hash("478 Wilkinson Court", PropertySize.LARGE, false, 2);
    expectedHashcode3 = Objects.hash(expectedHashcode3, 3);
    assertEquals(expectedHashcode3, testWindowCleaning.hashCode());
    int expectedHashcode4 = Objects.hash("3034 Hart Street", PropertySize.MEDIUM, false, 0);
    expectedHashcode4 = Objects.hash(expectedHashcode4, 1000.0, RoofType.FLAT_AND_HIP_ROOF);
    assertEquals(expectedHashcode4, testRoofAndGutterCleaning.hashCode());
    int expectedHashcode5 = Objects.hash("1675 Godfrey Road", PropertySize.SMALL, false, 4);
    expectedHashcode5 = Objects.hash(expectedHashcode5, testElectrical.getNumberOfEmployees(), true);
    assertEquals(expectedHashcode5, testElectrical.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "InteriorService{" +
        "numberOfPets=" + testCleaning.numberOfPets +
        ", petFeeRate=" + testCleaning.petFeeRate +
        '}';
    assertEquals(expectedString, testCleaning.toString());
    String expectedString2 = "Service{" +
        "propertyAddress='" + testGardening.getPropertyAddress() + '\'' +
        ", propertySize=" + testGardening.getPropertySize() +
        ", isMonthly=" + testGardening.getMonthly() +
        ", numberOfPastServices=" + testGardening.getNumberOfPastServices() +
        '}';
    assertEquals(expectedString2, testGardening.toString());
    String expectedString3 = "WindowCleaning{" +
        "numberOfFloors=" + testWindowCleaning.getNumberOfFloors() +
        '}';
    assertEquals(expectedString3, testWindowCleaning.toString());
    String expectedString4 = "RoofAndGutterCleaning{" +
        "roofSquareFootage=" + testRoofAndGutterCleaning.getRoofSquareFootage() +
        ", roofType=" + testRoofAndGutterCleaning.getRoofType() +
        '}';
    assertEquals(expectedString4, testRoofAndGutterCleaning.toString());
    String expectedString5 = "SpecialistService{" +
        "numberOfEmployees=" + testElectrical.getNumberOfEmployees() +
        ", ifComplex=" + testElectrical.getIfComplex() +
        '}';
    assertEquals(expectedString5, testElectrical.toString());
  }

  @Test
  void getNumberOfPets() {
    assertEquals(0, testCleaning.getNumberOfPets());
  }

  @Test
  void getNumberOfFloors() {
    assertEquals(3, testWindowCleaning.getNumberOfFloors());
  }

  @Test
  void getRoofSquareFootage() {
    assertEquals(1000.0, testRoofAndGutterCleaning.getRoofSquareFootage());
  }

  @Test
  void getRoofType() {
    assertEquals(RoofType.FLAT_AND_HIP_ROOF, testRoofAndGutterCleaning.getRoofType());
  }

  @Test
  void getNumberOfEmployees() {
    assertEquals(2, testElectrical.getNumberOfEmployees());
  }

  @Test
  void getIfComplex() {
    assertEquals(true, testElectrical.getIfComplex());
  }
}