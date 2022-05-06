package problem.view;

import java.text.SimpleDateFormat;
import java.util.*;

import problem.model.TodoItem;

/**
 * Class todoView supports todos displaying
 */
public class TodoView {

  /**
   * Display the customized list of Todos
   *
   * @param todoList       - the todoList
   * @param showIncomplete - if show incomplete Todos only
   * @param showCategory   - the particular category to be shown
   * @param sortRule       - sort by which property
   */
  public void display(List<TodoItem> todoList, Boolean showIncomplete, String showCategory,
      String sortRule) {
    List<TodoItem> filteredTodoList = new ArrayList<>(todoList);
    // filter incomplete
    if (showIncomplete) {
      filteredTodoList.removeIf(TodoItem::getCompleted);
    }
    // filter category
    if (showCategory != null) {
      filteredTodoList.removeIf(todoItem -> !Objects.equals(todoItem.getCategory(), showCategory));
    }
    // sort by date
    if (Objects.equals(sortRule, "date")) {
      // o2.getDue().compareTo(o1.getDue())
      filteredTodoList.sort(
          (o1, o2) -> Comparator.nullsLast(Date::compareTo).compare(o1.getDue(), o2.getDue()));
    }
    // sort by priority
    if (Objects.equals(sortRule, "priority")) {
      filteredTodoList.sort((o1, o2) -> o1.getPriority().compareTo(o2.getPriority()));
    }
    // break if the user attempts to display a subset of Todos that returns no results
    if (filteredTodoList.size() == 0) {
      System.out.println("The subset of Todos returns no results.");
      return;
    }
    // convert fields of todoItem to string
    List<String[]> stringTodoList = this.formatTodo(filteredTodoList);
    // display
    for (String[] row : stringTodoList) {
      System.out.format("%-5s%-45s%-15s%-15s%-15s%-15s\n", (Object[]) row);
    }
  }

  /**
   * Helper method to convert fields of todoItem to string
   *
   * @param filteredTodoList - list of todoItem
   * @return list of string list
   */
  private List<String[]> formatTodo(List<TodoItem> filteredTodoList) {
    List<String[]> stringTodoList = new ArrayList<>();
    String[] header = new String[]{"id", "text", "completed", "due", "priority", "category"};
    stringTodoList.add(header);
    for (TodoItem todoItem : filteredTodoList) {
      String[] str = new String[header.length];
      // id
      str[0] = String.valueOf(todoItem.getId());
      // text
      str[1] = todoItem.getText();
      // completed
      str[2] = todoItem.getCompleted() ? "true" : "false";
      // due
      str[3] = todoItem.getDue() == null ? "?" :
          new SimpleDateFormat("yyyy-MM-dd").format(todoItem.getDue());
      // priority
      str[4] = String.valueOf(todoItem.getPriority());
      // category
      str[5] = todoItem.getCategory() == null ? "?" : todoItem.getCategory();
      stringTodoList.add(str);
    }
    return stringTodoList;
  }
}
