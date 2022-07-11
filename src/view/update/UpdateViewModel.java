package view.update;

import java.io.IOException;
import java.sql.SQLException;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Todo;
import model.TodoService;

public class UpdateViewModel {
    TodoService todoService;

    StringProperty owner = new SimpleStringProperty();
    StringProperty text = new SimpleStringProperty();

    public UpdateViewModel(TodoService todoService) {
        this.todoService = todoService;
    }

    public StringProperty getOwner() {
        return owner;
    }

    public StringProperty getText() {
        return text;
    }

    public void updateTodo(Todo todo) throws ClassNotFoundException, SQLException, IOException {
        todo.setOwner(owner.getValue());
        todo.setText(text.getValue());

        todoService.update(todo);
    }

}
