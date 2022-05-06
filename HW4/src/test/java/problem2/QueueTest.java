package problem2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueueTest {

  Integer[] testArr;
  Queue testQueue;
  Queue emptyQueue;

  @BeforeEach
  void setUp() {
    testArr = new Integer[]{1, 2, 1};
    testQueue = new Queue(testArr);
    emptyQueue = new Queue();
  }

  @Test
  void emptyQueue() {
    Queue expectedQueue = new Queue(new Integer[0]);
    assertEquals(expectedQueue, testQueue.emptyQueue());
  }

  @Test
  void isEmpty() {
    assertFalse(testQueue.isEmpty());
    assertTrue(emptyQueue.isEmpty());
  }

  @Test
  void add() {
    Integer[] expectedArr = {1, 2, 1, 3};
    Queue expectedQueue = new Queue(expectedArr);
    assertEquals(expectedQueue, testQueue.add(3));
  }

  @Test
  void contains() {
    assertTrue(testQueue.contains(1));
    assertFalse(testQueue.contains(3));
  }

  @Test
  void remove() {
    Queue expectedQueue = new Queue(new Integer[]{2, 1});
    assertEquals(expectedQueue, testQueue.remove());
    Exception e = assertThrows(RuntimeException.class, () -> {
      emptyQueue.remove();
    });
    assertEquals("Can not remove from an empty queue", e.getMessage());
  }

  @Test
  void removeElement() {
    Queue expectedQueue = new Queue(new Integer[]{2});
    assertEquals(expectedQueue, testQueue.removeElement(1));
  }

  @Test
  void size() {
    assertEquals(3, testQueue.size());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testQueue.equals(testQueue));
  }

  @Test
  void testEquals_DifferentObject() {
    assertFalse(testQueue.equals(testArr));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testQueue.equals(null));
  }

  @Test
  void testHashCode() {
    assertEquals(Arrays.hashCode(testArr), testQueue.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "Queue{" +
        "queue=" + Arrays.toString(testArr) +
        '}';
    assertEquals(expectedString, testQueue.toString());
  }
}