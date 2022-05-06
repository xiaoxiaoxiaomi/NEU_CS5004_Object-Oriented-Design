package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LockerTest {

  private Locker testLocker;
  private Recipient testRecipient;
  private MailItem testMailItem;

  @BeforeEach
  void setUp() throws DimensionNumericException {
    testLocker = new Locker(15, 12, 18);
    testRecipient = new Recipient("Ruxue", "Jiang", "jiang.rux@northeastern.edu");
    testMailItem = new MailItem(10, 10, 12, testRecipient);
  }

  @Test
  void testLockerConstructor() {
    assertThrows(DimensionNumericException.class, () -> {
      new Locker(0, 12, 18);
    });
    assertThrows(DimensionNumericException.class, () -> {
      new Locker(15, -1, 18);
    });
    assertThrows(DimensionNumericException.class, () -> {
      new Locker(15, 12, -2);
    });
  }

  @Test
  void getMaximumWidth() {
    assertEquals(15, testLocker.getMaximumWidth());
  }

  @Test
  void getMaximumHeight() {
    assertEquals(12, testLocker.getMaximumHeight());
  }

  @Test
  void getMaximumDepth() {
    assertEquals(18, testLocker.getMaximumDepth());
  }

  @Test
  void getMailItem() throws DimensionNumericException {
    assertEquals(null, testLocker.getMailItem());
  }

  @Test
  void addMail() throws LargerThanLockerException, OccupiedLockerException {
    testLocker.addMail(testMailItem);
    assertEquals(testMailItem, testLocker.getMailItem());
  }

  @Test
  void addMail_OccupiedLockerException() throws LargerThanLockerException, OccupiedLockerException {
    testLocker.addMail(testMailItem);
    assertThrows(OccupiedLockerException.class, () -> {
      testLocker.addMail(testMailItem);
    });
  }

  @Test
  void addMail_LargerThanLockerException() throws DimensionNumericException {
    MailItem testMailItem1 = new MailItem(16, 10, 10, testRecipient);
    assertThrows(LargerThanLockerException.class, () -> {
      testLocker.addMail(testMailItem1);
    });
    MailItem testMailItem2 = new MailItem(10, 13, 10, testRecipient);
    assertThrows(LargerThanLockerException.class, () -> {
      testLocker.addMail(testMailItem2);
    });
    MailItem testMailItem3 = new MailItem(10, 10, 19, testRecipient);
    assertThrows(LargerThanLockerException.class, () -> {
      testLocker.addMail(testMailItem3);
    });
  }

  @Test
  void pickupMail()
      throws LargerThanLockerException, OccupiedLockerException, EmptyLockerException, RecipientNotMatchedException {
    testLocker.addMail(testMailItem);
    assertEquals(testMailItem, testLocker.pickupMail(testRecipient));
  }

  @Test
  void pickupMail_EmptyLockerException() {
    assertThrows(EmptyLockerException.class, () -> {
      testLocker.pickupMail(testRecipient);
    });
  }

  @Test
  void pickupMail_RecipientNotMatchedException()
      throws LargerThanLockerException, OccupiedLockerException {
    Recipient newRecipient = new Recipient("James", "Bond", "12345@outlook.com");
    testLocker.addMail(testMailItem);
    assertThrows(RecipientNotMatchedException.class, () -> {
      testLocker.pickupMail(newRecipient);
    });
  }
}