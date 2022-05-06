package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PriorityQueueTest {

  PriorityQueue testPQ1;
  PriorityQueue testPQ2;

  @BeforeEach
  void setUp() {
    testPQ1 = PriorityQueue.createEmpty();
    testPQ2 = PriorityQueue.createEmpty();
    testPQ2 = testPQ2.add(2, "sleep");
    testPQ2 = testPQ2.add(1, "eat");
  }

  @Test
  void isEmpty() {
    assertTrue(testPQ1.isEmpty());
    assertFalse(testPQ2.isEmpty());
  }

  @Test
  void add() {
    testPQ2 = testPQ2.add(3, "code");
    assertEquals("code", testPQ2.peek());
  }

  @Test
  void peek() {
    assertThrows(IllegalQueueOperationException.class, () -> {
      testPQ1.peek();
    });
  }

  @Test
  void pop() {
    assertThrows(IllegalQueueOperationException.class, () -> {
      testPQ1.pop();
    });
    assertEquals("sleep", testPQ2.peek());
    testPQ2 = testPQ2.pop();
    assertEquals("eat", testPQ2.peek());
  }

  @Test
  void equals() {
    assertTrue(testPQ1.equals(testPQ1));
    assertTrue(testPQ2.equals(testPQ2));
    assertFalse(testPQ1.equals(null));
    assertFalse(testPQ2.equals(null));
    assertFalse(testPQ1.equals(testPQ2));
    assertFalse(testPQ2.equals(testPQ1));
    PriorityQueue testPQ3 = PriorityQueue.createEmpty();
    testPQ3 = testPQ3.add(1, "sleep");
    testPQ3 = testPQ3.add(2, "eat");
    assertFalse(testPQ2.equals(testPQ3));
    PriorityQueue testPQ4 = PriorityQueue.createEmpty();
    testPQ4 = testPQ4.add(2, "sleep");
    testPQ4 = testPQ4.add(1, "eat");
    assertTrue(testPQ2.equals(testPQ4));
  }

  @Test
  void testHashCode() {
    assertEquals(123, testPQ1.hashCode());
    int expectedHashCode = Objects.hash(1, "eat", new ConsPQ(2, "sleep", new EmptyPQ()));
    assertEquals(expectedHashCode, testPQ2.hashCode());
  }

  @Test
  void testToString() {
    assertEquals("EmptyPQ{}", testPQ1.toString());
    assertEquals(
        "ConsPQ{priority=1, value='eat', priorityQueue=ConsPQ{priority=2, value='sleep', priorityQueue=EmptyPQ{}}}",
        testPQ2.toString());
  }
}