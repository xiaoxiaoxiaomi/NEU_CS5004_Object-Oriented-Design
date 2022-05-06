package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RecipientTest {

  private Recipient testRecipient;

  @BeforeEach
  void setUp() {
    testRecipient = new Recipient("Ruxue", "Jiang", "jiang.rux@northeastern.edu");
  }

  @Test
  void getFirstName() {
    assertEquals("Ruxue", testRecipient.getFirstName());
  }

  @Test
  void getLastName() {
    assertEquals("Jiang", testRecipient.getLastName());
  }

  @Test
  void getEmailAddress() {
    assertEquals("jiang.rux@northeastern.edu", testRecipient.getEmailAddress());
  }

  @Test
  void testEquals_SameMemoryLocation() {
    assertTrue(testRecipient.equals(testRecipient));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testRecipient.equals(null));
  }

  @Test
  void testEquals_DifferentDataTypes() {
    String newRecipient = "Ruxue Jiang";
    assertFalse(testRecipient.equals(newRecipient));
  }

  @Test
  void testEquals_SameFieldsOverall() {
    Recipient newRecipient = new Recipient("Ruxue", "Jiang", "jiang.rux@northeastern.edu");
    assertTrue(testRecipient.equals(newRecipient));
  }

  @Test
  void testEquals_DifferentFirstName() {
    Recipient newRecipient = new Recipient("Snow", "Jiang", "jiang.rux@northeastern.edu");
    assertFalse(testRecipient.equals(newRecipient));
  }

  @Test
  void testEquals_DifferentLastName() {
    Recipient newRecipient = new Recipient("Ruxue", "J", "jiang.rux@northeastern.edu");
    assertFalse(testRecipient.equals(newRecipient));
  }

  @Test
  void testEquals_DifferentEmailAddress() {
    Recipient newRecipient = new Recipient("Ruxue", "Jiang", "12345@outlook.com");
    assertFalse(testRecipient.equals(newRecipient));
  }

  @Test
  void testHashCode() {
    Recipient newRecipient = new Recipient("Ruxue", "Jiang", "jiang.rux@northeastern.edu");
    assertEquals(newRecipient.hashCode(), testRecipient.hashCode());
  }
}