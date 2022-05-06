package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.DateTimeException;
import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;
import jdk.vm.ci.meta.Local;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NonProfitTest {

  OneTimeDonation testOneTimeDonation1;
  OneTimeDonation testOneTimeDonation2;
  MonthlyDonation testMonthlyDonation1;
  MonthlyDonation testMonthlyDonation2;
  MonthlyDonation testMonthlyDonation3;
  MonthlyDonation testMonthlyDonation4;
  MonthlyDonation testMonthlyDonation5;
  Pledge testPledge1;
  Pledge testPledge2;
  Pledge testPledge3;
  ArrayList<Donation> testDonationList;
  NonProfit testNonProfit;

  @BeforeEach
  void setUp() {
    testOneTimeDonation1 = new OneTimeDonation(1000.0, LocalDateTime.of(2020, 5, 1, 12, 0));
    testOneTimeDonation2 = new OneTimeDonation(100.1, LocalDateTime.of(2021, 2, 13, 14, 14));
    testMonthlyDonation1 = new MonthlyDonation(200.2, LocalDateTime.of(2022, 2, 24, 9, 30));
    testMonthlyDonation2 = new MonthlyDonation(300.3, LocalDateTime.of(2019, 8, 16, 15, 59));
    testMonthlyDonation2.setCancellationDateTime(LocalDateTime.of(2020, 9, 11, 11, 11));
    testMonthlyDonation3 = new MonthlyDonation(400.4, LocalDateTime.of(2020, 12, 8, 20, 20));
    testMonthlyDonation4 = new MonthlyDonation(500.5, LocalDateTime.of(2021, 3, 15, 17, 36));
    testMonthlyDonation4.setCancellationDateTime(LocalDateTime.of(2023, 4, 5, 16, 16));
    testMonthlyDonation5 = new MonthlyDonation(600.6, LocalDateTime.of(2021, 1, 22, 6, 45));
    testMonthlyDonation5.setCancellationDateTime(LocalDateTime.of(2021, 7, 21, 23, 56));
    testPledge1 = new Pledge(700.7, LocalDateTime.of(2016, 7, 24, 17, 21));
    testPledge2 = new Pledge(800.8, LocalDateTime.of(2018, 1, 1, 0, 0));
    testPledge2.setProcessingDateTime(LocalDateTime.of(2020, 1, 1, 0, 0));
    testPledge3 = new Pledge(900.9, LocalDateTime.of(2019, 8, 10, 5, 20),
        LocalDateTime.of(2021, 6, 1, 18, 1));
    testDonationList = new ArrayList<>(
        Arrays.asList(testOneTimeDonation1, testOneTimeDonation2, testMonthlyDonation1,
            testMonthlyDonation2, testMonthlyDonation3, testMonthlyDonation4, testMonthlyDonation5,
            testPledge1, testPledge2, testPledge3));
    testNonProfit = new NonProfit("Non-profit Organization", testDonationList);
  }

  @Test
  void getAmount() {
    assertEquals(1000.0, testOneTimeDonation1.getAmount());
  }

  @Test
  void getCreationDateTime() {
    assertEquals(LocalDateTime.of(2020, 5, 1, 12, 0), testOneTimeDonation1.getCreationDateTime());
  }

  @Test
  void getCancellationDateTime() {
    assertEquals(LocalDateTime.of(2020, 9, 11, 11, 11),
        testMonthlyDonation2.getCancellationDateTime());
  }

  @Test
  void setCancellationDateTime() {
    testMonthlyDonation2.setCancellationDateTime(LocalDateTime.of(2024, 3, 8, 0, 0));
    assertEquals(LocalDateTime.of(2024, 3, 8, 0, 0),
        testMonthlyDonation2.getCancellationDateTime());
    Exception e = assertThrows(DateTimeException.class, () -> {
      testMonthlyDonation2.setCancellationDateTime(LocalDateTime.of(2017, 6, 7, 12, 0));
    });
    assertEquals("The proposed cancellation should not be prior to the creation date and time.",
        e.getMessage());
  }

  @Test
  void getProcessingDateTime() {
    assertEquals(LocalDateTime.of(2021, 6, 1, 18, 1), testPledge3.getProcessingDateTime());
  }

  @Test
  void setProcessingDateTime() {
    testPledge3.setProcessingDateTime(LocalDateTime.of(2021, 7, 8, 10, 0));
    assertEquals(LocalDateTime.of(2021, 7, 8, 10, 0), testPledge3.getProcessingDateTime());
    Exception e = assertThrows(DateTimeException.class, () -> {
      testPledge3.setProcessingDateTime(LocalDateTime.of(2017, 6, 7, 12, 0));
    });
    assertEquals(
        "The proposed new processing date should not be prior to the creation date and time",
        e.getMessage());
  }

  @Test
  void removeProcessingDateTime() {
    testPledge3.removeProcessingDateTime();
    assertEquals(null, testPledge3.getProcessingDateTime());
  }

  @Test
  void getOrganizationName() {
    assertEquals("Non-profit Organization", testNonProfit.getOrganizationName());
  }

  @Test
  void getDonationList() {
    assertEquals(testDonationList, testNonProfit.getDonationList());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testOneTimeDonation1.equals(testOneTimeDonation1));
    assertTrue(testMonthlyDonation2.equals(testMonthlyDonation2));
    assertTrue(testPledge3.equals(testPledge3));
    assertTrue(testNonProfit.equals(testNonProfit));
  }

  @Test
  void testEquals_DifferentObject() {
    assertFalse(testOneTimeDonation1.equals(testMonthlyDonation1));
    assertFalse(testMonthlyDonation2.equals(testPledge1));
    assertFalse(testPledge3.equals(testOneTimeDonation1));
    assertFalse(testNonProfit.equals(testDonationList));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testOneTimeDonation1.equals(null));
    assertFalse(testMonthlyDonation2.equals(null));
    assertFalse(testPledge3.equals(null));
    assertFalse(testNonProfit.equals(null));
  }

  @Test
  void testEquals_DifferentAmount() {
    Donation newOneTimeDonation = new OneTimeDonation(999.9, LocalDateTime.of(2020, 5, 1, 12, 0));
    assertFalse(testOneTimeDonation1.equals(newOneTimeDonation));
    MonthlyDonation newMonthlyDonation = new MonthlyDonation(300.0,
        LocalDateTime.of(2019, 8, 16, 15, 59));
    newMonthlyDonation.setCancellationDateTime(LocalDateTime.of(2020, 9, 11, 11, 11));
    assertFalse(testMonthlyDonation2.equals(newMonthlyDonation));
    Pledge newPledge = new Pledge(900.0, LocalDateTime.of(2019, 8, 10, 5, 20),
        LocalDateTime.of(2021, 6, 1, 18, 1));
    assertFalse(testPledge3.equals(newPledge));
  }

  @Test
  void testEquals_DifferentCreationDateTime() {
    Donation newOneTimeDonation = new OneTimeDonation(1000.0, LocalDateTime.of(2021, 1, 1, 1, 1));
    assertFalse(testOneTimeDonation1.equals(newOneTimeDonation));
  }

  @Test
  void testEquals_DifferentCancellationDateTime() {
    MonthlyDonation newMonthlyDonation = new MonthlyDonation(300.3,
        LocalDateTime.of(2019, 8, 16, 15, 59));
    newMonthlyDonation.setCancellationDateTime(LocalDateTime.of(2023, 12, 31, 23, 59));
    assertFalse(testMonthlyDonation2.equals(newMonthlyDonation));
  }

  @Test
  void testEquals_DifferentProcessingTime() {
    Pledge newPledge = new Pledge(900.9, LocalDateTime.of(2019, 8, 10, 5, 20),
        LocalDateTime.of(2021, 7, 8, 18, 0));
    assertFalse(testPledge3.equals(newPledge));
  }

  @Test
  void testEquals_DifferentOrganizationName() {
    NonProfit newNonProfit = new NonProfit("New Name", testDonationList);
    assertFalse(testNonProfit.equals(newNonProfit));
  }

  @Test
  void testEquals_DifferentDonationList() {
    ArrayList<Donation> newDonationList = new ArrayList<>(
        Arrays.asList(testOneTimeDonation1, testMonthlyDonation1, testPledge1));
    NonProfit newNonProfit = new NonProfit("Non-profit Organization", newDonationList);
    assertFalse(testNonProfit.equals(newNonProfit));
  }

  @Test
  void testEquals_SameFieldsOverall() {
    Donation newOneTimeDonation = new OneTimeDonation(1000.0, LocalDateTime.of(2020, 5, 1, 12, 0));
    assertTrue(testOneTimeDonation1.equals(newOneTimeDonation));
    MonthlyDonation newMonthlyDonation = new MonthlyDonation(300.3,
        LocalDateTime.of(2019, 8, 16, 15, 59));
    newMonthlyDonation.setCancellationDateTime(LocalDateTime.of(2020, 9, 11, 11, 11));
    assertTrue(testMonthlyDonation2.equals(newMonthlyDonation));
    Pledge newPledge = new Pledge(900.9, LocalDateTime.of(2019, 8, 10, 5, 20),
        LocalDateTime.of(2021, 6, 1, 18, 1));
    assertTrue(testPledge3.equals(newPledge));
    NonProfit newNonProfit = new NonProfit("Non-profit Organization", testDonationList);
    assertTrue(testNonProfit.equals(newNonProfit));
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash("Non-profit Organization",
        testDonationList.stream().collect(Collectors.groupingBy(p -> p, Collectors.counting())));
    assertEquals(expectedHashCode, testNonProfit.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "NonProfit{" +
        "organizationName='" + "Non-profit Organization" + '\'' +
        ", donationList=" + testDonationList +
        '}';
    assertEquals(expectedString, testNonProfit.toString());
  }

  @Test
  void getTotalDonationsForYear() {
    Double expectedTotal = 100.1 + 400.4 * 12 + 500.5 * 10 + 600.6 * 6 + 900.9;
    assertEquals(expectedTotal, testNonProfit.getTotalDonationsForYear(2021));
  }
}