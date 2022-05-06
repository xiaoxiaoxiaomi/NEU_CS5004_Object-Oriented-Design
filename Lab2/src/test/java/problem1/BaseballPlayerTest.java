package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BaseballPlayerTest {

  BaseballPlayer testBaseballPlayer;
  Name expectedName;
  Double expectedHeight;
  Double expectedWeight;
  String expectedLeague;
  String expectedTeam;
  Double expectedAvgBattingScore;
  Integer expectedSeasonHomeRuns;

  @BeforeEach
  void setUp() {
    Name name = new Name("Mike", "Nelson", "Trout");
    testBaseballPlayer = new BaseballPlayer(name, 188.0, 235.0, "MLB", "Los Angeles Angels", 0.305, 8);
    expectedName = new Name("Mike", "Nelson", "Trout");
    expectedHeight = 188.0;
    expectedWeight = 235.0;
    expectedLeague = "MLB";
    expectedTeam = "Los Angeles Angels";
    expectedAvgBattingScore = 0.305;
    expectedSeasonHomeRuns = 8;
  }

  @Test
  void getAthletesName() {
    assertEquals(expectedName, testBaseballPlayer.getAthletesName());
  }

  @Test
  void getHeight() {
    assertEquals(expectedHeight, testBaseballPlayer.getHeight());
  }

  @Test
  void getWeight() {
    assertEquals(expectedWeight, testBaseballPlayer.getWeight());
  }

  @Test
  void getLeague() {
    assertEquals(expectedLeague, testBaseballPlayer.getLeague());
  }

  @Test
  void getTeam() {
    assertEquals(expectedTeam, testBaseballPlayer.getTeam());
  }

  @Test
  void setTeam() {
    testBaseballPlayer.setTeam("New York Mets");
    assertEquals("New York Mets", testBaseballPlayer.getTeam());
  }

  @Test
  void getAvgBattingScore() {
    assertEquals(expectedAvgBattingScore, testBaseballPlayer.getAvgBattingScore());
  }

  @Test
  void setAvgBattingScore() {
    testBaseballPlayer.setAvgBattingScore(0.299);
    assertEquals(0.299, testBaseballPlayer.getAvgBattingScore());
  }

  @Test
  void getSeasonHomeRuns() {
    assertEquals(expectedSeasonHomeRuns, testBaseballPlayer.getSeasonHomeRuns());
  }

  @Test
  void setSeasonHomeRuns() {
    testBaseballPlayer.setSeasonHomeRuns(7);
    assertEquals(7, testBaseballPlayer.getSeasonHomeRuns());
  }

  @Test
  void testEquals_SameMemoryLocation() {
    assertTrue(testBaseballPlayer.equals(testBaseballPlayer));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testBaseballPlayer.equals(null));
  }

  @Test
  void testEquals_DifferentDataTypes() {
    Runner testRunner = new Runner(expectedName, 168.0, 95.0, "US Track and Field", 35.0, 178.0, "Olympics");
    assertFalse(testBaseballPlayer.equals(testRunner));
  }

  @Test
  void testEquals_DifferentInheritedFields() {
    Name newName = new Name("Hussain", "NA", "Bolt");
    BaseballPlayer newTestBaseballPlayer = new BaseballPlayer(newName, 188.0, 235.0, "MLB", "Los Angeles Angels", 0.305, 8);
    assertFalse(testBaseballPlayer.equals(newTestBaseballPlayer));
  }

  @Test
  void testEquals_SameFieldsOverall() {
    Name newName = new Name("Mike", "Nelson", "Trout");
    BaseballPlayer newTestBaseballPlayer = new BaseballPlayer(newName, 188.0, 235.0, "MLB", "Los Angeles Angels", 0.305, 8);
    assertTrue(testBaseballPlayer.equals(newTestBaseballPlayer));
  }

  @Test
  void testEquals_DifferentTeam() {
    Name newName = new Name("Mike", "Nelson", "Trout");
    BaseballPlayer newTestBaseballPlayer = new BaseballPlayer(newName, 188.0, 235.0, "MLB", "New York Mets", 0.305, 8);
    assertFalse(testBaseballPlayer.equals(newTestBaseballPlayer));
  }

  @Test
  void testEquals_DifferentAvgBattingScore() {
    Name newName = new Name("Mike", "Nelson", "Trout");
    BaseballPlayer newTestBaseballPlayer = new BaseballPlayer(newName, 188.0, 235.0, "MLB", "Los Angeles Angels", 0.299, 8);
    assertFalse(testBaseballPlayer.equals(newTestBaseballPlayer));
  }

  @Test
  void testEquals_DifferentSeasonHomeRuns() {
    Name newName = new Name("Mike", "Nelson", "Trout");
    BaseballPlayer newTestBaseballPlayer = new BaseballPlayer(newName, 188.0, 235.0, "MLB", "Los Angeles Angels", 0.305, 7);
    assertFalse(testBaseballPlayer.equals(newTestBaseballPlayer));
  }

  @Test
  void testHashCode() {
    Name newName = new Name("Mike", "Nelson", "Trout");
    BaseballPlayer newTestBaseballPlayer = new BaseballPlayer(newName, 188.0, 235.0, "MLB", "Los Angeles Angels", 0.305, 8);
    assertEquals(newTestBaseballPlayer.hashCode(), testBaseballPlayer.hashCode());
  }

  @Test
  void testToString() {
    assertEquals("BaseballPlayer{team='Los Angeles Angels', avgBattingScore=0.305, seasonHomeRuns=8}", testBaseballPlayer.toString());
  }
}