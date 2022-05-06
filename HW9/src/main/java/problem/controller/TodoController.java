package problem.controller;

import problem.exception.InvalidArgumentException;
import problem.exception.InvalidIDException;
import java.io.IOException;
import java.text.ParseException;
import problem.model.TodoModel;
import problem.view.TodoView;

/**
 * The TodoController class implements an command-line TODO application that allows a user to add
 * and track the status of their TODOs by due date, category, priority, and status
 * (complete/incomplete).
 */
public class TodoController {

  /**
   * Entry point for the TODO application
   *
   * @param args - arguments provided by the user
   * @throws InvalidArgumentException if the arguments supplied are invalid
   * @throws ParseException           if an error has been reached unexpectedly while parsing
   * @throws IOException              if an I/O exception has occurred
   * @throws InvalidIDException       if the provided id does not exist
   */
  public static void main(String[] args)
      throws InvalidArgumentException, ParseException, IOException, InvalidIDException {
    CommandLineParser parser = new CommandLineParser(args);
    TodoModel todoModel = new TodoModel(parser.getCsvFile());
    todoModel.addTodoItem(parser.getNewTodo());
    todoModel.completeTodos(parser.getCompleteTodoList());
    TodoView todoView = new TodoView();
    if (parser.getDisplay()) {
      todoView.display(todoModel.getTodoList(), parser.getShowIncomplete(),
          parser.getShowCategory(), parser.getSortRule());
    }
  }
}
