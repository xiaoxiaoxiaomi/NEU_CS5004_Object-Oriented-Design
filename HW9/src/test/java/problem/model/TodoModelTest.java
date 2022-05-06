package problem.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.opencsv.CSVReader;
import problem.exception.InvalidIDException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import problem.model.TodoItem;
import problem.model.TodoModel;

class TodoModelTest {

  TodoModel testTodoModel;
  List<TodoItem> expectedTodoList;

  @BeforeEach
  void setUp() throws IOException, ParseException {
    testTodoModel = new TodoModel("test.csv");
    expectedTodoList = new ArrayList<>();
    CSVReader reader = new CSVReader(new FileReader("test.csv"), ',');
    List<String[]> csvBody = reader.readAll();
    reader.close();
    for (int i = 1; i < csvBody.size(); i++) {
      String[] row = csvBody.get(i);
      Integer id = Integer.valueOf(row[0]);
      String text = row[1];
      Boolean completed = row[2].equals("true");
      Date due = row[3].equals("?") ? null : new SimpleDateFormat("yyyy-MM-dd").parse(row[3]);
      Integer priority = Integer.valueOf(row[4]);
      String category = row[5].equals("?") ? null : row[5];
      TodoItem item = new TodoItem(id, text, completed, due, priority, category);
      expectedTodoList.add(item);
    }
  }

  @Test
  void addTodoItem() throws ParseException, IOException {
    testTodoModel.addTodoItem(null);
    TodoItem newTodoItem1 = new TodoItem(null, "Finish HW10", false,
        new SimpleDateFormat("yyyy-MM-dd").parse("2022-4-26"), 1, "school");
    testTodoModel.addTodoItem(newTodoItem1);
    expectedTodoList.add(newTodoItem1);
    assertEquals(expectedTodoList, testTodoModel.getTodoList());
    TodoItem newTodoItem2 = new TodoItem(null, "Test", true, null, 2, null);
    testTodoModel.addTodoItem(newTodoItem2);
    expectedTodoList.add(newTodoItem2);
    assertEquals(expectedTodoList, testTodoModel.getTodoList());
  }

  @Test
  void completeTodos() throws InvalidIDException, IOException {
    List<Integer> testIds = new ArrayList<>(Arrays.asList(3, 5));
    testTodoModel.completeTodos(testIds);
    for (int id : testIds) {
      expectedTodoList.get(id - 1).setCompleted(true);
    }
    assertEquals(expectedTodoList, testTodoModel.getTodoList());
    Exception e = assertThrows(InvalidIDException.class, () -> {
      testTodoModel.completeTodos(new ArrayList<>(Arrays.asList(10, 11)));
    });
    assertEquals("Error: you attempt to complete a Todo that does not exist!", e.getMessage());
  }

  @Test
  void getTodoList() {
    assertEquals(expectedTodoList, testTodoModel.getTodoList());
  }

  @Test
  void testEquals() throws IOException, ParseException {
    assertTrue(testTodoModel.equals(testTodoModel));
    assertFalse(testTodoModel.equals(null));
    assertFalse(testTodoModel.equals("test.csv"));
    TodoModel newTodoModel1 = new TodoModel("todos.csv");
    assertFalse(testTodoModel.equals(newTodoModel1));
    TodoModel newTodoModel2 = new TodoModel("test.csv");
    assertTrue(testTodoModel.equals(newTodoModel2));
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(expectedTodoList);
    assertEquals(expectedHashCode, testTodoModel.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "TodoModel{" +
        "todoList=" + expectedTodoList +
        '}';
    assertEquals(expectedString, testTodoModel.toString());
  }
}