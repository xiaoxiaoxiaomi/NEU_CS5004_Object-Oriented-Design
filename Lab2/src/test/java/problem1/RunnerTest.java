package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RunnerTest {

  Runner testRunner;
  Name expectedName;
  Double expectedHeight;
  Double expectedWeight;
  Double expected5KTime;
  Double expectedHalfMarathonTime;
  String expectedLeague;
  String expectedFavoriteEvent;

  @BeforeEach
  void setUp() {
    Name name = new Name("Allyson", "Michelle", "Felix");
    testRunner = new Runner(name, 168.0, 95.0, "US Track and Field", 35.0, 178.0, "Olympics");
    expectedName = new Name("Allyson", "Michelle", "Felix");
    expectedHeight = 168.0;
    expectedWeight = 95.0;
    expected5KTime = 35.0;
    expectedHalfMarathonTime = 178.0;
    expectedLeague = "US Track and Field";
    expectedFavoriteEvent = "Olympics";
  }

  @Test
  void getAthletesName() {
    assertEquals(expectedName, testRunner.getAthletesName());
  }

  @Test
  void getHeight() {
    assertEquals(expectedHeight, testRunner.getHeight());
  }

  @Test
  void getWeight() {
    assertEquals(expectedWeight, testRunner.getWeight());
  }

  @Test
  void getLeague() {
    assertEquals(expectedLeague, testRunner.getLeague());
  }

  @Test
  void getBest5KTime() {
    assertEquals(expected5KTime, testRunner.getBest5KTime());
  }

  @Test
  void setBest5KTime() {
    testRunner.setBest5KTime(39.0);
    assertEquals(39.0, testRunner.getBest5KTime());
  }

  @Test
  void getBestHalfMarathonTime() {
    assertEquals(expectedHalfMarathonTime, testRunner.getBestHalfMarathonTime());
  }

  @Test
  void setBestHalfMarathonTime() {
    testRunner.setBestHalfMarathonTime(175.0);
    assertEquals(175.0, testRunner.getBestHalfMarathonTime());
  }

  @Test
  void getFavoriteRunningEvent() {
    assertEquals(expectedFavoriteEvent, testRunner.getFavoriteRunningEvent());
  }

  @Test
  void setFavoriteRunningEvent() {
    testRunner.setFavoriteRunningEvent("Boston Marathon");
    assertEquals("Boston Marathon", testRunner.getFavoriteRunningEvent());
  }

  @Test
  void testEquals_SameMemoryLocation() {
    assertTrue(testRunner.equals(testRunner));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testRunner.equals(null));
  }

  @Test
  void testEquals_DifferentDataTypes() {
    BaseballPlayer testBaseballPlayer = new BaseballPlayer(expectedName, 195.0, 165.0, "NFC",
        "Mariners", 23.5, 5);
    assertFalse(testRunner.equals(testBaseballPlayer));
  }

  @Test
  void testEquals_DifferentInheritedFields() {
    Name newName = new Name("Hussain", "NA", "Bolt");
    Runner newTestRunner = new Runner(newName, 168.0, 95.0, "US Track and Field", 35.0, 178.0,
        "Olympics");
    assertFalse(testRunner.equals(newTestRunner));
  }

  @Test
  void testEquals_SameFieldsOverall() {
    Name newName = new Name("Allyson", "Michelle", "Felix");
    Runner newTestRunner = new Runner(newName, 168.0, 95.0, "US Track and Field", 35.0, 178.0,
        "Olympics");
    assertTrue(testRunner.equals(newTestRunner));
  }

  @Test
  void testEquals_Different5KTime() {
    Name newName = new Name("Allyson", "Michelle", "Felix");
    Runner newTestRunner = new Runner(newName, 168.0, 95.0, "US Track and Field", 25.0, 178.0,
        "Olympics");
    assertFalse(testRunner.equals(newTestRunner));
  }

  @Test
  void testEquals_DifferentHalfMarathonTime() {
    Name newName = new Name("Allyson", "Michelle", "Felix");
    Runner newTestRunner = new Runner(newName, 168.0, 95.0, "US Track and Field", 35.0, 165.0,
        "Olympics");
    assertFalse(testRunner.equals(newTestRunner));
  }

  @Test
  void testEquals_DifferentVenue() {
    Name newName = new Name("Allyson", "Michelle", "Felix");
    Runner newTestRunner = new Runner(newName, 168.0, 95.0, "US Track and Field", 35.0, 178.0,
        "Rock'n'Roll Marathon");
    assertFalse(testRunner.equals(newTestRunner));
  }

  @Test
  void testHashCode() {
    Name newName = new Name("Allyson", "Michelle", "Felix");
    Runner newTestRunner = new Runner(newName, 168.0, 95.0, "US Track and Field", 35.0, 178.0,
        "Olympics");
    assertEquals(newTestRunner.hashCode(), testRunner.hashCode());
  }

  @Test
  void testToString() {
  assertEquals("Runner{best5KTime=35.0, bestHalfMarathonTime=178.0, favoriteRunningEvent='Olympics'}", testRunner.toString());
  }
}