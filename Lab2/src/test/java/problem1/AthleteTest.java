package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AthleteTest {

  Athlete testAthlete;
  Name expectedName;
  Double expectedHeight;
  Double expectedWeight;
  String expectedLeague;

  @BeforeEach
  void setUp() {
    Name name = new Name("Jeremy", "Shu-How", "Lin");
    testAthlete = new Athlete(name, 190.0, 200.0, "CBA");
    expectedName = new Name("Jeremy", "Shu-How", "Lin");
    expectedHeight = 190.0;
    expectedWeight = 200.0;
    expectedLeague = "CBA";
  }

  @Test
  void getAthletesName() {
    assertEquals(expectedName, testAthlete.getAthletesName());
  }

  @Test
  void getHeight() {
    assertEquals(expectedHeight, testAthlete.getHeight());
  }

  @Test
  void getWeight() {
    assertEquals(expectedWeight, testAthlete.getWeight());
  }

  @Test
  void getLeague() {
    assertEquals(expectedLeague, testAthlete.getLeague());
  }

  @Test
  void testEquals_SameMemoryLocation() {
    assertTrue(testAthlete.equals(testAthlete));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testAthlete.equals(null));
  }

  @Test
  void testEquals_SameFieldsOverall() {
    Name newName = new Name("Jeremy", "Shu-How", "Lin");
    Athlete newTestAthlete = new Athlete(newName, 190.0, 200.0, "CBA");
    assertTrue(testAthlete.equals(newTestAthlete));
  }

  @Test
  void testEquals_DifferentAthleteName() {
    Name newName = new Name("Ming", "NA", "Yao");
    Athlete newTestAthlete = new Athlete(newName, 190.0, 200.0, "CBA");
    assertFalse(testAthlete.equals(newTestAthlete));
  }

  @Test
  void testEquals_DifferentHeight() {
    Name newName = new Name("Jeremy", "Shu-How", "Lin");
    Athlete newTestAthlete = new Athlete(newName, 200.0, 200.0, "CBA");
    assertFalse(testAthlete.equals(newTestAthlete));
  }

  @Test
  void testEquals_DifferentWeight() {
    Name newName = new Name("Jeremy", "Shu-How", "Lin");
    Athlete newTestAthlete = new Athlete(newName, 190.0, 201.0, "CBA");
    assertFalse(testAthlete.equals(newTestAthlete));
  }

  @Test
  void testEquals_DifferentLeague() {
    Name newName = new Name("Jeremy", "Shu-How", "Lin");
    Athlete newTestAthlete = new Athlete(newName, 190.0, 200.0, "NBA");
    assertFalse(testAthlete.equals(newTestAthlete));
  }

  @Test
  void testHashCode() {
    Name newName = new Name("Jeremy", "Shu-How", "Lin");
    Athlete newTestAthlete = new Athlete(newName, 190.0, 200.0, "CBA");
    assertEquals(newTestAthlete.hashCode(), testAthlete.hashCode());
  }

  @Test
  void testToString() {
    assertEquals(
        "Athlete{athletesName=Name{firstName='Jeremy', middleName='Shu-How', lastName='Lin'}, height=190.0, weight=200.0, league='CBA'}",
        testAthlete.toString());
  }
}