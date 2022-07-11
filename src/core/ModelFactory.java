package core;

import model.TodoService;
import model.TodoServiceImpl;

public class ModelFactory {
    TodoService todoService;

    public TodoService getTodoService() {
        if (todoService == null) {
            todoService = new TodoServiceImpl();
        }

        return todoService;
    }
}
