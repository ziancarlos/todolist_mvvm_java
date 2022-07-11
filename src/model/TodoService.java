package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface TodoService {

    void add(Todo todo) throws ClassNotFoundException, SQLException, IOException;

    void update(Todo todo) throws SQLException, ClassNotFoundException, IOException;

    void delete(int id) throws ClassNotFoundException, SQLException, IOException;

    List<Todo> getAll() throws ClassNotFoundException, SQLException, IOException;

    Todo get(int id) throws ClassNotFoundException, SQLException, IOException;
}
