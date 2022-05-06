package problem.model;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import problem.model.TodoItem;

class TodoItemTest {

  TodoItem testTodoItem;
  Date testDue;

  @BeforeEach
  void setUp() throws ParseException {
    testDue = new SimpleDateFormat("yyyy-MM-dd").parse("2022-4-26");
    testTodoItem = new TodoItem(6, "Finish HW10", false, testDue, 2, "school");
  }

  @Test
  void getId() {
    assertEquals(6, testTodoItem.getId());
  }

  @Test
  void getText() {
    assertEquals("Finish HW10", testTodoItem.getText());
  }

  @Test
  void getCompleted() {
    assertEquals(false, testTodoItem.getCompleted());
  }

  @Test
  void getDue() {
    assertEquals(testDue, testTodoItem.getDue());
  }

  @Test
  void getPriority() {
    assertEquals(2, testTodoItem.getPriority());
  }

  @Test
  void getCategory() {
    assertEquals("school", testTodoItem.getCategory());
  }

  @Test
  void setId() {
    testTodoItem.setId(7);
    assertEquals(7, testTodoItem.getId());
  }

  @Test
  void setCompleted() {
    testTodoItem.setCompleted(true);
    assertEquals(true, testTodoItem.getCompleted());
  }

  @Test
  void testEquals() throws ParseException {
    assertTrue(testTodoItem.equals(testTodoItem));
    assertFalse(testTodoItem.equals(null));
    assertFalse(testTodoItem.equals("Finish HW10"));
    TodoItem newTodoItem = new TodoItem(7, "Finish HW10", false, testDue, 2, "school");
    assertFalse(testTodoItem.equals(newTodoItem));
    newTodoItem = new TodoItem(6, "Finish HW9", false, testDue, 2, "school");
    assertFalse(testTodoItem.equals(newTodoItem));
    newTodoItem = new TodoItem(6, "Finish HW10", true, testDue, 2, "school");
    assertFalse(testTodoItem.equals(newTodoItem));
    Date newDue = new SimpleDateFormat("yyyy-MM-dd").parse("2022-4-29");
    newTodoItem = new TodoItem(6, "Finish HW10", false, newDue, 2, "school");
    assertFalse(testTodoItem.equals(newTodoItem));
    newTodoItem = new TodoItem(6, "Finish HW10", false, testDue, 1, "school");
    assertFalse(testTodoItem.equals(newTodoItem));
    newTodoItem = new TodoItem(6, "Finish HW10", false, testDue, 2, "?");
    assertFalse(testTodoItem.equals(newTodoItem));
    newTodoItem = new TodoItem(6, "Finish HW10", false, testDue, 2, "school");
    assertTrue(testTodoItem.equals(newTodoItem));
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(6, "Finish HW10", false, testDue, 2, "school");
    assertEquals(expectedHashCode, testTodoItem.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "TodoItem{" +
        "id=" + 6 +
        ", text='" + "Finish HW10" + '\'' +
        ", completed=" + false +
        ", due=" + testDue +
        ", priority=" + 2 +
        ", category='" + "school" + '\'' +
        '}';
    assertEquals(expectedString, testTodoItem.toString());
  }
}