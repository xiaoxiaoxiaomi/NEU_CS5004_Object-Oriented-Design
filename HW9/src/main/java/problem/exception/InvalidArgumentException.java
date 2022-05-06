package problem.exception;

/**
 * Signals an error when the argument is invalid
 */
public class InvalidArgumentException extends Exception {

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

  /**
   * Constructs a new InvalidArgumentException with the specified detail message
   *
   * @param message - the detail message
   */
  public InvalidArgumentException(String message) {
    super(message + DEFAULT_MESSAGE);
  }
}
