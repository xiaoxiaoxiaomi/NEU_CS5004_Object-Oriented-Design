package problem.view;

import java.io.IOException;
import java.text.ParseException;
import problem.model.TodoModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import problem.view.TodoView;

class TodoViewTest {

  TodoModel testTodoModel;
  TodoView testTodoView;

  @BeforeEach
  void setUp() throws IOException, ParseException {
    testTodoModel = new TodoModel("test.csv");
    testTodoView = new TodoView();
  }

  @Test
  void display() {
    testTodoView.display(testTodoModel.getTodoList(), true, "school", "date");
    testTodoView.display(testTodoModel.getTodoList(), false, null, "priority");
    testTodoView.display(testTodoModel.getTodoList(), true, "company", null);
  }
}