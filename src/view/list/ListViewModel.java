package view.list;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Todo;
import model.TodoService;

public class ListViewModel {
    TodoService todoService;
    private ObservableList<Todo> todos = FXCollections.observableArrayList();

    public ListViewModel(TodoService todoService) {
        this.todoService = todoService;
    }

    public void loadData() throws ClassNotFoundException, SQLException, IOException {
        List<Todo> todos = todoService.getAll();

        this.todos.addAll(todos);
    }

    public ObservableList<Todo> getTodos() {
        return todos;
    }

    public void todoCompleted(Todo todo) throws ClassNotFoundException, SQLException, IOException {
        todo.setIsCompleted(true);

        todoService.update(todo);

    }

    public void deleteTodo(Todo todo) throws ClassNotFoundException, SQLException, IOException {
        todoService.delete(todo.getId());
    }

}
