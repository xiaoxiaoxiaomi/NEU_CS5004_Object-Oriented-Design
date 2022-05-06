package problem2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BagOfWordsTest {

  BagOfWords testBag1;
  BagOfWords testBag2;

  @BeforeEach
  void setUp() {
    testBag1 = BagOfWords.emptyBagOfWords();
    testBag2 = BagOfWords.emptyBagOfWords();
    testBag2 = testBag2.add("eat");
    testBag2 = testBag2.add("eat");
    testBag2 = testBag2.add("sleep");
  }

  @Test
  void isEmpty() {
    assertTrue(testBag1.isEmpty());
    assertFalse(testBag2.isEmpty());
  }

  @Test
  void add() {
    testBag1 = testBag1.add("eat");
    assertEquals(1, testBag1.size());
    assertEquals(3, testBag2.size());
    testBag2 = testBag2.add("code");
    assertEquals(4, testBag2.size());
  }

  @Test
  void contains() {
    assertFalse(testBag1.contains("eat"));
    assertTrue(testBag2.contains("eat"));
    assertFalse(testBag2.contains("code"));
  }

  @Test
  void remove() {
    testBag1 = testBag1.remove("code");
    testBag2 = testBag2.remove("eat");
    testBag2 = testBag2.remove("eat");
    assertFalse(testBag2.contains("eat"));
    testBag2 = testBag2.remove("code");
  }

  @Test
  void equals() {
    assertTrue(testBag1.equals(testBag1));
    assertTrue(testBag2.equals(testBag2));
    assertFalse(testBag1.equals(null));
    assertFalse(testBag2.equals(null));
    assertFalse(testBag1.equals(testBag2));
    assertFalse(testBag2.equals(testBag1));
    BagOfWords testBag3 = BagOfWords.emptyBagOfWords();
    testBag3 = testBag3.add("eat");
    testBag3 = testBag3.add("sleep");
    assertFalse(testBag2.equals(testBag3));
    testBag3 = testBag3.add("sleep");
    assertFalse(testBag2.equals(testBag3));
    testBag3 = testBag3.remove("sleep");
    testBag3 = testBag3.add("eat");
    assertTrue(testBag2.equals(testBag3));
  }

  @Test
  void testHashCode() {
    assertEquals(123, testBag1.hashCode());
    int expectedHashCode = Objects.hash("sleep", new ConsBag("eat", new ConsBag("eat", new EmptyBag())));
    assertEquals(expectedHashCode, testBag2.hashCode());
  }

  @Test
  void testToString() {
    assertEquals("EmptyBag{}", testBag1.toString());
    assertEquals(
        "ConsBag{s='sleep', bagOfWords=ConsBag{s='eat', bagOfWords=ConsBag{s='eat', bagOfWords=EmptyBag{}}}}",
        testBag2.toString());
  }
}