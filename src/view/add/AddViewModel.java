package view.add;

import java.io.IOException;
import java.sql.SQLException;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Todo;
import model.TodoService;

public class AddViewModel {

    TodoService todoService;

    private StringProperty owner = new SimpleStringProperty();

    private StringProperty text = new SimpleStringProperty();

    public AddViewModel(TodoService todoService) {
        this.todoService = todoService;
    }

    public StringProperty getOwner() {
        return owner;
    }

    public StringProperty getText() {
        return text;
    }

    public void addTodo() throws ClassNotFoundException, SQLException, IOException {
        todoService.add(new Todo(owner.getValue(), text.getValue()));
    }

}
