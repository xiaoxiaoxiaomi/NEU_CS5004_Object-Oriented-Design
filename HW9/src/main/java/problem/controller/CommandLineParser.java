package problem.controller;

import problem.exception.InvalidArgumentException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import problem.model.TodoItem;

/**
 * Processes and validates command line arguments. This class doesn't *do* anything with the values
 * provided by the user beyond initial validation. It is another class' responsibility to determine
 * what to do with the user input.
 */
public class CommandLineParser {

  public static final String CSV_FILE = "--csv-file";
  public static final String ADD_TODO = "--add-todo";
  public static final String TODO_TEXT = "--todo-text";
  public static final String COMPLETED = "--completed";
  public static final String DUE = "--due";
  public static final String PRIORITY = "--priority";
  public static final String CATEGORY = "--category";
  public static final String COMPLETE_TODO = "--complete-todo";
  public static final String DISPLAY = "--display";
  public static final String SHOW_INCOMPLETE = "--show-incomplete";
  public static final String SHOW_CATEGORY = "--show-category";
  public static final String SORT_BY_DATE = "--sort-by-date";
  public static final String SORT_BY_PRIORITY = "--sort-by-priority";
  public static final Integer DEFAULT_PRIORITY = 3;

  private String csvFile = null;

  private Boolean addTodo = false;
  private String todoText = null;
  private Boolean completed = false;
  private Date due = null;
  private Integer priority = DEFAULT_PRIORITY;
  private String category = null;
  private TodoItem newTodo = null;

  private List<Integer> completeTodoList = new ArrayList<>();

  private Boolean display = false;
  private Boolean showIncomplete = false;
  private String showCategory = null;
  private Boolean sortByDate = false;
  private Boolean sortByPriority = false;
  private String sortRule = null;

  /**
   * Constructor for the CommandLineParser class.
   *
   * @param args - arguments provided by the user
   * @throws InvalidArgumentException if the arguments supplied are invalid
   * @throws ParseException           if an error has been reached unexpectedly while parsing
   */
  public CommandLineParser(String[] args) throws InvalidArgumentException, ParseException {
    this.processArgs(args);
  }

  /**
   * Helper method to populate the instance variables.
   *
   * @param args - arguments provided by the user
   * @throws InvalidArgumentException if the arguments supplied are invalid
   * @throws ParseException           if an error has been reached unexpectedly while parsing
   */
  private void processArgs(String[] args) throws InvalidArgumentException, ParseException {
    // scan the string objects in the argument array one by one
    for (int i = 0; i < args.length; i++) {
      switch (args[i]) {
        case CSV_FILE:
          this.csvFile = args[i + 1];
          break;
        case ADD_TODO:
          this.addTodo = true;
          break;
        case TODO_TEXT:
          this.todoText = args[i + 1];
          break;
        case COMPLETED:
          this.completed = true;
          break;
        case DUE:
          this.due = new SimpleDateFormat("yyyy-MM-dd").parse(args[i + 1]);
          break;
        case PRIORITY:
          this.priority = Integer.valueOf(args[i + 1]);
          break;
        case CATEGORY:
          this.category = args[i + 1];
          break;
        case COMPLETE_TODO:
          this.completeTodoList.add(Integer.valueOf(args[i + 1]));
          break;
        case DISPLAY:
          this.display = true;
          break;
        case SHOW_INCOMPLETE:
          this.showIncomplete = true;
          break;
        case SHOW_CATEGORY:
          this.showCategory = args[i + 1];
          break;
        case SORT_BY_DATE:
          this.sortByDate = true;
          break;
        case SORT_BY_PRIORITY:
          this.sortByPriority = true;
          break;
        default:
          break;
      }
    }

    // --csv-file is required
    if (this.csvFile == null) {
      throw new InvalidArgumentException("Error: no csv file was given.");
    }

    if (this.addTodo) {
      // If --add-todo is provided, then --todo-text must also be provided
      if (this.todoText == null) {
        throw new InvalidArgumentException(
            "Error: --add-todo was given but no --todo-text was provided.");
      }
      // priority should be 1, 2, or 3
      if (this.priority < 1 || this.priority > 3) {
        throw new InvalidArgumentException("Error: priority should be 1, 2, or 3.");
      }
      this.newTodo = new TodoItem(null, this.todoText, this.completed, this.due, this.priority,
          this.category);
    }
    // get sort rule
    if (this.sortByDate && this.sortByPriority) {
      throw new InvalidArgumentException(
          "Error: --sort-by-date cannot be combined with --sort-by-priority");
    } else if (this.sortByDate) {
      this.sortRule = "date";
    } else if (this.sortByPriority) {
      this.sortRule = "priority";
    }
  }

  /**
   * Getter for csv file
   *
   * @return the csv file path
   */
  public String getCsvFile() {
    return csvFile;
  }

  /**
   * Getter for new todoItem
   *
   * @return the todoItem to be added, if there is no item to add, return null
   */
  public TodoItem getNewTodo() {
    return newTodo;
  }

  /**
   * Getter for completed todoItems List
   *
   * @return the list of completed todoItems
   */
  public List<Integer> getCompleteTodoList() {
    return completeTodoList;
  }

  /**
   * Getter for whether display
   *
   * @return true if --display is provided, otherwise return false
   */
  public Boolean getDisplay() {
    return display;
  }

  /**
   * Getter for if show incomplete only
   *
   * @return true if --show-incomplete is provided, otherwise return false
   */
  public Boolean getShowIncomplete() {
    return showIncomplete;
  }

  /**
   * Getter for category to be displayed
   *
   * @return the category to be displayed if a category is given, otherwise return null
   */
  public String getShowCategory() {
    return showCategory;
  }

  /**
   * Getter for sort rule
   *
   * @return "date" if --sort-by-date is provided or "priority" if --sort-by-priority is provided,
   * otherwise return null
   */
  public String getSortRule() {
    return sortRule;
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
    CommandLineParser that = (CommandLineParser) o;
    return Objects.equals(csvFile, that.csvFile) && Objects.equals(newTodo,
        that.newTodo) && Objects.equals(completeTodoList, that.completeTodoList)
        && Objects.equals(display, that.display) && Objects.equals(showIncomplete,
        that.showIncomplete) && Objects.equals(showCategory, that.showCategory)
        && Objects.equals(sortRule, that.sortRule);
  }

  /**
   * Returns a hash code value for the object.
   *
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(csvFile, newTodo, completeTodoList, display, showIncomplete, showCategory,
        sortRule);
  }

  /**
   * Returns a string representation of the object.
   *
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "CommandLineParser{" +
        "csvFile='" + csvFile + '\'' +
        ", newTodo=" + newTodo +
        ", completeTodoList=" + completeTodoList +
        ", display=" + display +
        ", showIncomplete=" + showIncomplete +
        ", showCategory='" + showCategory + '\'' +
        ", sortRule='" + sortRule + '\'' +
        '}';
  }
}
