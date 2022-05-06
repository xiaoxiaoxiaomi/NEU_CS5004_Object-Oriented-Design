package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FoodItemTest {

  private Fruit testFruit;
  private LocalDateTime testOrderDate;
  private LocalDateTime testExpirationDate;
  private Pasta myTestPasta;
  private FoodItem myTestRice;

  @BeforeEach
  void setUp() {
    testOrderDate = LocalDateTime.now();
    testExpirationDate = LocalDateTime.of(2022, 3, 1, 11, 59, 59);
    testFruit = new Fruit("Apple", 2.99, 25, FoodItem.MAX_PERISHABLE_QUANTITY, testOrderDate,
        testExpirationDate);
    myTestPasta = new Pasta("Rigatoni", 2.50, 35, FoodItem.MAX_NON_PERISHABLE_QUANTITY);
    myTestRice = new Rice("Jasmine rice", 3.99, 50, FoodItem.MAX_NON_PERISHABLE_QUANTITY);
  }

  @Test
  void getName() {
    assertEquals("Apple", testFruit.getName());
  }

  @Test
  void getCurrentPrice() {
    assertEquals(2.99, testFruit.getCurrentPrice());
  }

  @Test
  void getCurrentQuantity() {
    assertEquals(25, testFruit.getCurrentQuantity());
  }

  @Test
  void getMaxAllowedQuantity() {
    assertEquals(FoodItem.MAX_PERISHABLE_QUANTITY, testFruit.getMaxAllowedQuantity());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testFruit.equals(testFruit));
    // assertEquals(testFruit, testFruit); - not preferred
  }

  @Test
  void testEquals_DifferentObject() {
    assertFalse(testFruit.equals(myTestPasta));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testFruit.equals(null));
  }

  @Test
  void testEquals_DifferentOrderDate() {
    Fruit myOtherFruit = new Fruit("Apple", 2.99, 25, FoodItem.MAX_PERISHABLE_QUANTITY,
        testExpirationDate,
        testExpirationDate);
    assertFalse(testFruit.equals(myOtherFruit));
  }

  @Test
  void testEquals_DifferentExpirationDate() {
    Fruit myOtherFruit = new Fruit("Apple", 2.99, 25, FoodItem.MAX_PERISHABLE_QUANTITY,
        testOrderDate,
        testOrderDate);
    assertFalse(testFruit.equals(myOtherFruit));
  }

  @Test
  void testEquals_DifferentObjectsSameAttributes() {
    Fruit myOtherFruit = new Fruit("Apple", 2.99, 25, FoodItem.MAX_PERISHABLE_QUANTITY,
        testOrderDate,
        testExpirationDate);
    assertTrue(testFruit.equals(myOtherFruit));
  }

  // Testing equals for FoodItem
  @Test
  void testEquals_SameObjectRice() {
    assertTrue(myTestRice.equals(myTestRice));
  }

  @Test
  void testEquals_DifferentObjectRice() {
    assertFalse(myTestRice.equals(myTestPasta));
  }

  @Test
  void testEquals_NullObjectRice() {
    assertFalse(myTestRice.equals(null));
  }

  @Test
  void testEquals_OtherRiceObject() {
    FoodItem myOtherRice = new Rice("Jasmine rice", 3.99, 50, FoodItem.MAX_NON_PERISHABLE_QUANTITY);
    assertTrue(myTestRice.equals(myOtherRice));
  }

  @Test
  void testEquals_OtherRiceObject_DifferentName() {
    FoodItem myOtherRice = new Rice("Brown rice", 3.99, 50, FoodItem.MAX_NON_PERISHABLE_QUANTITY);
    assertFalse(myTestRice.equals(myOtherRice));
  }

  @Test
  void testEquals_OtherRiceObject_DifferentPrice() {
    FoodItem myOtherRice = new Rice("Jasmine rice", 5.99, 50, FoodItem.MAX_NON_PERISHABLE_QUANTITY);
    assertFalse(myTestRice.equals(myOtherRice));
  }

  @Test
  void testEquals_OtherRiceObject_DifferentQuantity() {
    FoodItem myOtherRice = new Rice("Jasmine rice", 3.99, 100,
        FoodItem.MAX_NON_PERISHABLE_QUANTITY);
    assertFalse(myTestRice.equals(myOtherRice));
  }

  @Test
  void testEquals_DifferentMaxQuantity() {
    FoodItem myOtherFruit = new Fruit("Apple", 2.99, 25, 123,
        testOrderDate, testExpirationDate);
    assertFalse(testFruit.equals(myOtherFruit));
  }

  @Test
  void testEquals_OtherRiceObject_DifferentMaxQuantity() {
    FoodItem myOtherPasta = new Rice("Rigatoni", 2.50, 35, FoodItem.MAX_NON_PERISHABLE_QUANTITY);
    assertFalse(myTestPasta.equals(myOtherPasta));
  }

  // hashcode test for non-perishable item
  @Test
  void testHashCode() {
    int expectedHashcode = Objects.hash("Rigatoni", 2.50, 35, FoodItem.MAX_NON_PERISHABLE_QUANTITY);
    System.out.println("My hashcode is: " + expectedHashcode);
    assertEquals(expectedHashcode, myTestPasta.hashCode());
  }

  // hashcode test for perishable item
  @Test
  void testHashCode_Perishable() {
    int expectedHashcode = Objects.hash("Apple", 2.99, 25, FoodItem.MAX_PERISHABLE_QUANTITY);
    expectedHashcode = Objects.hash(expectedHashcode, testOrderDate, testExpirationDate);
    System.out.println("My hashcode is: " + expectedHashcode);
    assertEquals(expectedHashcode, testFruit.hashCode());
  }

  // toString() test for perishable item
  @Test
  void testToString() {
    String expectedString = "PerishableFoodItem{" +
        "orderDate=" + testOrderDate.toString() +
        ", expirationDate=" + testExpirationDate.toString() +
        '}';
    assertEquals(expectedString, testFruit.toString());
  }

  // toString() test for non-perishable item
  @Test
  void testToString_NonPerishable() {
    String expectedString = "FoodItem{" +
        "name='" + "Rigatoni" + '\'' +
        ", currentPrice=" + "2.5" +
        ", currentQuantity=" + "35" +
        ", maxAllowedQuantity=" + FoodItem.MAX_NON_PERISHABLE_QUANTITY +
        '}';
    assertEquals(expectedString, myTestPasta.toString());
  }

  @Test
  void testGetOrderDate() {
    Meat testMeat = new Meat("Poultry", 3.00, 10, FoodItem.MAX_PERISHABLE_QUANTITY,
        testOrderDate, testExpirationDate);
    assertEquals(testOrderDate, testMeat.getOrderDate());
  }

  @Test
  void testGetExpirationDate() {
    Vegetable testCarrot = new Vegetable("Purple carrot", 1.50, 20,
        FoodItem.MAX_PERISHABLE_QUANTITY,
        testOrderDate, testExpirationDate);
    assertEquals(testExpirationDate, testCarrot.getExpirationDate());
  }
}