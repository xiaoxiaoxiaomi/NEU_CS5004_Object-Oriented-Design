package problem.model;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import problem.exception.InvalidIDException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Class todoModel stores the todoList and supports two functionality: add a new todo and complete
 * an existing todo
 */
public class TodoModel {

  private List<TodoItem> todoList = new ArrayList<>();
  private String path;

  /**
   * Constructor fot TodoModel
   *
   * @param csvFile - csv file path
   * @throws IOException    if an I/O exception has occurred
   * @throws ParseException if an error has been reached unexpectedly while parsing
   */
  public TodoModel(String csvFile) throws IOException, ParseException {
    this.csvToModel(csvFile);
  }

  /**
   * Load data from csv file into ArrayList
   *
   * @param csvFile - csv file path
   * @throws IOException    if an I/O exception has occurred
   * @throws ParseException if an error has been reached unexpectedly while parsing
   */
  private void csvToModel(String csvFile) throws IOException, ParseException {
    this.path = csvFile;
    CSVReader reader = new CSVReader(new FileReader(this.path), ',');
    List<String[]> csvBody = reader.readAll();
    reader.close();
    // for each line, construct a todoItem object, and put it into todoList
    for (int i = 1; i < csvBody.size(); i++) {
      String[] row = csvBody.get(i);
      // deal with id
      Integer id = Integer.valueOf(row[0]);
      // deal with text
      String text = row[1];
      // deal with completed
      Boolean completed = row[2].equals("true");
      // deal with due
      Date due = row[3].equals("?") ? null : new SimpleDateFormat("yyyy-MM-dd").parse(row[3]);
      // deal with priority
      Integer priority = Integer.valueOf(row[4]);
      // deal with category
      String category = row[5].equals("?") ? null : row[5];
      // construct a todoItem object
      TodoItem item = new TodoItem(id, text, completed, due, priority, category);
      // put into todoList
      this.todoList.add(item);
    }
  }

  /**
   * Add a todoItem to the todoList, and when a new todo is added, the csv file will be updated
   *
   * @param item - item to be added
   * @throws IOException if an I/O exception has occurred
   */
  public void addTodoItem(TodoItem item) throws IOException {
    if (item == null) {
      return;
    }
    item.setId(this.todoList.size() + 1);
    this.todoList.add(item);
    // transform fields of todoItem to string
    String id = String.valueOf(item.getId());
    String text = item.getText();
    String completed = item.getCompleted() ? "true" : "false";
    String due;
    if (item.getDue() == null) {
      due = "?";
    } else {
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      due = formatter.format(item.getDue());
    }
    String priority = String.valueOf(item.getPriority());
    String category = item.getCategory() == null ? "?" : item.getCategory();
    // write item into csv file
    CSVWriter writer = new CSVWriter(new FileWriter(this.path, true), ',');
    writer.writeNext(new String[]{id, text, completed, due, priority, category});
    writer.flush();
    writer.close();
  }

  /**
   * Set the completed status of an existing todo to true, when the status is changed, the csv file
   * will be updated
   *
   * @param ids - list of completed todos' id
   * @throws IOException        if an I/O exception has occurred
   * @throws InvalidIDException if the provided id does not exist
   */
  public void completeTodos(List<Integer> ids) throws IOException, InvalidIDException {
    CSVReader reader = new CSVReader(new FileReader(this.path), ',');
    List<String[]> csvBody = reader.readAll();
    reader.close();
    for (int id : ids) {
      if (id > this.todoList.size()) {
        throw new InvalidIDException("Error: you attempt to complete a Todo that does not exist!");
      }
      // update todoList
      this.todoList.get(id - 1).setCompleted(true);
      // update the csv file
      csvBody.get(id)[2] = "true";
    }
    // write the updated todoList to csv file
    CSVWriter writer = new CSVWriter(new FileWriter(this.path), ',');
    writer.writeAll(csvBody);
    writer.flush();
    writer.close();
  }

  /**
   * Getter for todoList
   *
   * @return the current todoList
   */
  public List<TodoItem> getTodoList() {
    return todoList;
  }

  /**
   * Indicates whether some other object is "equal to" this one.
   *
   * @param o - the reference object with which to compare.
   * @return true if this object is the same as the obj argument; false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TodoModel todoModel = (TodoModel) o;
    return Objects.equals(todoList, todoModel.todoList);
  }

  /**
   * Returns a hash code value for the object.
   *
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(todoList);
  }

  /**
   * Returns a string representation of the object.
   *
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "TodoModel{" +
        "todoList=" + todoList +
        '}';
  }
}
