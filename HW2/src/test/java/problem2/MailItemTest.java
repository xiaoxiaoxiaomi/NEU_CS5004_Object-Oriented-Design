package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MailItemTest {

  private MailItem testMailItem;
  private Recipient testRecipient;

  @BeforeEach
  void setUp() throws DimensionNumericException {
    testRecipient = new Recipient("Ruxue", "Jiang", "jiang.rux@northeastern.edu");
    testMailItem = new MailItem(12, 8, 15, testRecipient);
  }

  @Test
  void testMailItemConstructor() {
    assertThrows(DimensionNumericException.class, () -> {
      new MailItem(-2, 8, 15, testRecipient);
    });
    assertThrows(DimensionNumericException.class, () -> {
      new MailItem(12, -1, 15, testRecipient);
    });
    assertThrows(DimensionNumericException.class, () -> {
      new MailItem(12, 8, 0, testRecipient);
    });
  }

  @Test
  void getWidth() {
    assertEquals(12, testMailItem.getWidth());
  }

  @Test
  void getHeight() {
    assertEquals(8, testMailItem.getHeight());
  }

  @Test
  void getDepth() {
    assertEquals(15, testMailItem.getDepth());
  }

  @Test
  void getRecipient() {
    assertEquals(testRecipient, testMailItem.getRecipient());
  }
}