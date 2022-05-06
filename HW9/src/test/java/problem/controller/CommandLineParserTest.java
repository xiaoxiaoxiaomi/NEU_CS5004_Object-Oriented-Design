package problem.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import problem.controller.CommandLineParser;
import problem.exception.InvalidArgumentException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import problem.model.TodoItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CommandLineParserTest {

  static final String DEFAULT_MESSAGE =
      "\n\nUsage:\n"
          + "--csv-file <path/to/file> The CSV file containing the todos. This option is required.\n"
          + "--add-todo Add a new todo. If this option is provided, then --todo-text must also be provided.\n"
          + "--todo-text <description of todo> A description of the todo.\n"
          + "--completed (Optional) Sets the completed status of a new todo to true.\n"
          + "--due <due date> (Optional) Sets the due date of a new todo. You may choose how the date should be formatted.\n"
          + "--priority <1, 2, or 3> (Optional) Sets the priority of a new todo. The value can be 1, 2, or 3.\n"
          + "--category <a category name> (Optional) Sets the category of a new todo. The value can be any String. Categories do not need to be pre-defined.\n"
          + "--complete-todo <id> Mark the Todo with the provided ID as complete.\n"
          + "--display Display todos. If none of the following optional arguments are provided, displays all todos.\n"
          + "--show-incomplete (Optional) If --display is provided, only incomplete todos should be displayed.\n"
          + "--show-category <category> (Optional) If --display is provided, only todos with the given category should be displayed.\n"
          + "--sort-by-date (Optional) If --display is provided, sort the list of todos by date order (ascending). Cannot be combined with --sort-by-priority.\n"
          + "--sort-by-priority (Optional) If --display is provided, sort the list of todos by priority (ascending). Cannot be combined with --sort-by-date.\n"
          + "\nExamples:\n"
          + "--csv-file todos.csv --add-todo --todo-text \"Finish HW10\" --completed, --due 2022-4-26 --priority 1 --category school --complete-todo 4 --complete-todo 5 --display --show-incomplete --show-category school --sort-by-priority";
  String[] testArgs;
  CommandLineParser testCommandLineParser;

  @BeforeEach
  void setUp() throws InvalidArgumentException, ParseException {
    testArgs = new String[]{"--csv-file", "todos.csv", "--add-todo", "--todo-text", "Finish HW10",
        "--completed", "--due", "2022-4-26", "--priority", "1", "--category", "school",
        "--complete-todo", "4", "--complete-todo", "5", "--display", "--show-incomplete",
        "--show-category", "school", "--sort-by-priority"};
    testCommandLineParser = new CommandLineParser(testArgs);
  }

  @Test
  void testInvalidArgument() throws InvalidArgumentException, ParseException {
    String[] newArgs1 = new String[]{"todos.csv", "--add-todo", "--todo-text", "Finish HW10",
        "--completed", "--due", "2022-4-26", "--priority", "1", "--category", "school",
        "--complete-todo", "4", "--complete-todo", "5", "--display", "--show-incomplete",
        "--show-category", "school", "--sort-by-priority"};
    Exception e1 = assertThrows(InvalidArgumentException.class, () -> {
      new CommandLineParser(newArgs1);
    });
    assertEquals("Error: no csv file was given." + DEFAULT_MESSAGE, e1.getMessage());
    String[] newArgs2 = new String[]{"--csv-file", "todos.csv", "--add-todo", "--completed",
        "--due", "2022-4-26", "--priority", "1", "--category", "school", "--complete-todo", "4",
        "--complete-todo", "5", "--display", "--show-incomplete", "--show-category", "school",
        "--sort-by-priority"};
    Exception e2 = assertThrows(InvalidArgumentException.class, () -> {
      new CommandLineParser(newArgs2);
    });
    assertEquals("Error: --add-todo was given but no --todo-text was provided." + DEFAULT_MESSAGE,
        e2.getMessage());
    String[] newArgs3 = new String[]{"--csv-file", "todos.csv", "--add-todo", "--todo-text",
        "Finish HW10", "--completed", "--due", "2022-4-26", "--priority", "0", "--category",
        "school", "--complete-todo", "4", "--complete-todo", "5", "--display", "--show-incomplete",
        "--show-category", "school", "--sort-by-priority"};
    Exception e3 = assertThrows(InvalidArgumentException.class, () -> {
      new CommandLineParser(newArgs3);
    });
    assertEquals("Error: priority should be 1, 2, or 3." + DEFAULT_MESSAGE, e3.getMessage());
    String[] newArgs4 = new String[]{"--csv-file", "todos.csv", "--add-todo", "--todo-text",
        "Finish HW10", "--completed", "--due", "2022-4-26", "--priority", "4", "--category",
        "school", "--complete-todo", "4", "--complete-todo", "5", "--display", "--show-incomplete",
        "--show-category", "school", "--sort-by-priority"};
    Exception e4 = assertThrows(InvalidArgumentException.class, () -> {
      new CommandLineParser(newArgs4);
    });
    assertEquals("Error: priority should be 1, 2, or 3." + DEFAULT_MESSAGE, e4.getMessage());
    String[] newArgs5 = new String[]{"--csv-file", "todos.csv", "--add-todo", "--todo-text",
        "Finish HW10", "--completed", "--due", "2022-4-26", "--priority", "1", "--category",
        "school", "--complete-todo", "4", "--complete-todo", "5", "--display", "--show-incomplete",
        "--show-category", "school", "--sort-by-date", "--sort-by-priority"};
    Exception e5 = assertThrows(InvalidArgumentException.class, () -> {
      new CommandLineParser(newArgs5);
    });
    assertEquals(
        "Error: --sort-by-date cannot be combined with --sort-by-priority" + DEFAULT_MESSAGE,
        e5.getMessage());
    String[] newArgs6 = new String[]{"--csv-file", "todos.csv", "--add-todo", "--todo-text",
        "Finish HW10", "--completed", "--due", "2022-4-26", "--priority", "1", "--category",
        "school", "--complete-todo", "4", "--complete-todo", "5", "--display", "--show-incomplete",
        "--show-category", "school", "--sort-by-date"};
    new CommandLineParser(newArgs6);
    String[] newArgs7 = new String[]{"--csv-file", "todos.csv", "--complete-todo", "4",
        "--complete-todo", "5", "--display", "--show-incomplete", "--show-category", "school"};
    new CommandLineParser(newArgs7);
  }

  @Test
  void getCsvFile() {
    assertEquals("todos.csv", testCommandLineParser.getCsvFile());
  }

  @Test
  void getNewTodo() throws ParseException {
    Date due = new SimpleDateFormat("yyyy-MM-dd").parse("2022-4-26");
    TodoItem newTodo = new TodoItem(null, "Finish HW10", true, due, 1, "school");
    assertEquals(newTodo, testCommandLineParser.getNewTodo());
  }

  @Test
  void getCompleteTodoList() {
    List<Integer> completeTodoList = new ArrayList<>(Arrays.asList(4, 5));
    assertEquals(completeTodoList, testCommandLineParser.getCompleteTodoList());
  }

  @Test
  void getDisplay() {
    assertEquals(true, testCommandLineParser.getDisplay());
  }

  @Test
  void getShowIncomplete() {
    assertEquals(true, testCommandLineParser.getShowIncomplete());
  }

  @Test
  void getShowCategory() {
    assertEquals("school", testCommandLineParser.getShowCategory());
  }

  @Test
  void getSortRule() {
    assertEquals("priority", testCommandLineParser.getSortRule());
  }

  @Test
  void testEquals() throws InvalidArgumentException, ParseException {
    assertTrue(testCommandLineParser.equals(testCommandLineParser));
    assertFalse(testCommandLineParser.equals(null));
    assertFalse(testCommandLineParser.equals(testArgs));
    String[] newArgs1 = new String[]{"--csv-file", "nothing.csv", "--add-todo", "--todo-text",
        "Finish HW10", "--completed", "--due", "2022-4-26", "--priority", "1", "--category",
        "school", "--complete-todo", "4", "--complete-todo", "5", "--display", "--show-incomplete",
        "--show-category", "school", "--sort-by-priority"};
    CommandLineParser newCommandLineParser1 = new CommandLineParser(newArgs1);
    assertFalse(testCommandLineParser.equals(newCommandLineParser1));
    String[] newArgs2 = new String[]{"--csv-file", "todos.csv", "--add-todo", "--todo-text",
        "Finish HW9", "--completed", "--due", "2022-4-26", "--priority", "1", "--category",
        "school", "--complete-todo", "4", "--complete-todo", "5", "--display", "--show-incomplete",
        "--show-category", "school", "--sort-by-priority"};
    CommandLineParser newCommandLineParser2 = new CommandLineParser(newArgs2);
    assertFalse(testCommandLineParser.equals(newCommandLineParser2));
    String[] newArgs3 = new String[]{"--csv-file", "todos.csv", "--add-todo", "--todo-text",
        "Finish HW10", "--completed", "--due", "2022-4-26", "--priority", "1", "--category",
        "school", "--complete-todo", "1", "--complete-todo", "3", "--display", "--show-incomplete",
        "--show-category", "school", "--sort-by-priority"};
    CommandLineParser newCommandLineParser3 = new CommandLineParser(newArgs3);
    assertFalse(testCommandLineParser.equals(newCommandLineParser3));
    String[] newArgs4 = new String[]{"--csv-file", "todos.csv", "--add-todo", "--todo-text",
        "Finish HW10", "--completed", "--due", "2022-4-26", "--priority", "1", "--category",
        "school", "--complete-todo", "4", "--complete-todo", "5", "--show-incomplete",
        "--show-category", "school", "--sort-by-priority"};
    CommandLineParser newCommandLineParser4 = new CommandLineParser(newArgs4);
    assertFalse(testCommandLineParser.equals(newCommandLineParser4));
    String[] newArgs5 = new String[]{"--csv-file", "todos.csv", "--add-todo", "--todo-text",
        "Finish HW10", "--completed", "--due", "2022-4-26", "--priority", "1", "--category",
        "school", "--complete-todo", "4", "--complete-todo", "5", "--display", "--show-category",
        "school", "--sort-by-priority"};
    CommandLineParser newCommandLineParser5 = new CommandLineParser(newArgs5);
    assertFalse(testCommandLineParser.equals(newCommandLineParser5));
    String[] newArgs6 = new String[]{"--csv-file", "todos.csv", "--add-todo", "--todo-text",
        "Finish HW10", "--completed", "--due", "2022-4-26", "--priority", "1", "--category",
        "school", "--complete-todo", "4", "--complete-todo", "5", "--display", "--show-incomplete",
        "--show-category", "home", "--sort-by-priority"};
    CommandLineParser newCommandLineParser6 = new CommandLineParser(newArgs6);
    assertFalse(testCommandLineParser.equals(newCommandLineParser6));
    String[] newArgs7 = new String[]{"--csv-file", "todos.csv", "--add-todo", "--todo-text",
        "Finish HW10", "--completed", "--due", "2022-4-26", "--priority", "1", "--category",
        "school", "--complete-todo", "4", "--complete-todo", "5", "--display", "--show-incomplete",
        "--show-category", "school", "--sort-by-date"};
    CommandLineParser newCommandLineParser7 = new CommandLineParser(newArgs7);
    assertFalse(testCommandLineParser.equals(newCommandLineParser7));
    String[] newArgs8 = new String[]{"--csv-file", "todos.csv", "--add-todo", "--todo-text",
        "Finish HW10", "--completed", "--due", "2022-4-26", "--priority", "1", "--category",
        "school", "--complete-todo", "4", "--complete-todo", "5", "--display", "--show-incomplete",
        "--show-category", "school", "--sort-by-priority"};
    CommandLineParser newCommandLineParser8 = new CommandLineParser(newArgs8);
    assertTrue(testCommandLineParser.equals(newCommandLineParser8));
  }

  @Test
  void testHashCode() throws ParseException {
    int expectedHashCode = Objects.hash("todos.csv", testCommandLineParser.getNewTodo(),
        testCommandLineParser.getCompleteTodoList(), true, true, "school", "priority");
    assertEquals(expectedHashCode, testCommandLineParser.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "CommandLineParser{" +
        "csvFile='" + "todos.csv" + '\'' +
        ", newTodo=" + testCommandLineParser.getNewTodo() +
        ", completeTodoList=" + testCommandLineParser.getCompleteTodoList() +
        ", display=" + true +
        ", showIncomplete=" + true +
        ", showCategory='" + "school" + '\'' +
        ", sortRule='" + "priority" + '\'' +
        '}';
    assertEquals(expectedString, testCommandLineParser.toString());
  }
}