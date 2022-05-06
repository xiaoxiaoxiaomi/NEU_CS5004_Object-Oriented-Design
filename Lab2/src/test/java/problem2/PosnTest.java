package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PosnTest {

  Posn testPosn1;
  Posn testPosn2;

  @BeforeEach
  void setUp() {
    testPosn1 = new Posn(3, 4);
    testPosn2 = new Posn(null, null);
  }

  @Test
  void getX() {
    assertEquals(3, testPosn1.getX());
  }

  @Test
  void getY() {
    assertEquals(4, testPosn1.getY());
  }

  @Test
  void testEquals_SameMemoryLocation() {
    assertTrue(testPosn1.equals(testPosn1));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testPosn1.equals(null));
  }

  @Test
  void testEquals_DifferentDataTypes() {
    Integer testInteger = 5;
    assertFalse(testPosn1.equals(testInteger));
  };

  @Test
  void testEquals_DifferentOrNullX() {
    Posn newTestPosn1 = new Posn(2, 4);
    assertFalse(testPosn1.equals(newTestPosn1));

    Posn newTestPosn2 = new Posn(3, 4);
    assertFalse(testPosn2.equals(newTestPosn2));

    Posn newTestPosn3 = new Posn(null, 4);
    assertFalse(testPosn2.equals(newTestPosn3));
  };

  @Test
  void testEquals_DifferentOrNullY() {
    Posn newTestPosn1 = new Posn(3, 3);
    assertFalse(testPosn1.equals(newTestPosn1));

    Posn newTestPosn3 = new Posn(null, 4);
    assertFalse(testPosn2.equals(newTestPosn3));

    Posn newTestPosn2 = new Posn(null, null);
    assertTrue(testPosn2.equals(newTestPosn2));
  };

  @Test
  void testHashCode() {
    Posn newTestPosn1 = new Posn(3, 4);
    assertEquals(newTestPosn1.hashCode(), testPosn1.hashCode());

    Posn newTestPosn2 = new Posn(null, null);
    assertEquals(newTestPosn2.hashCode(), testPosn2.hashCode());
  }

  @Test
  void testToString() {
    assertEquals("Posn{x=3, y=4}", testPosn1.toString());
  }
}