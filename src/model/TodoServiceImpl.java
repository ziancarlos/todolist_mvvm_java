package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tools.Connector;

public class TodoServiceImpl implements TodoService {

    @Override
    public void add(Todo todo) throws ClassNotFoundException, SQLException, IOException {
        Connection connection = Connector.getConnection();
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO todos(owner, text) VALUES(?, ?)");
        statement.setString(1, todo.getOwner());
        statement.setString(2, todo.getText());

        statement.executeUpdate();

        Connector.closeQueryOperation(connection, statement);
    }

    @Override
    public void update(Todo todo) throws SQLException, ClassNotFoundException, IOException {
        Connection connection = Connector.getConnection();
        PreparedStatement statement = connection.prepareStatement(
                "UPDATE todos SET owner = ?, text = ?, isCompleted = ? WHERE id = ?");
        statement.setString(1, todo.getOwner());
        statement.setString(2, todo.getText());
        statement.setInt(3, (todo.getIsCompleted() == true) ? 1 : 0);
        statement.setInt(4, todo.getId());

        statement.executeUpdate();

        Connector.closeQueryOperation(connection, statement);
    }

    @Override
    public void delete(int id) throws ClassNotFoundException, SQLException, IOException {
        Connection connection = Connector.getConnection();
        PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM todos WHERE id = ?");
        statement.setInt(1, id);

        statement.executeUpdate();

        connection.close();
        statement.close();

        Connector.closeQueryOperation(connection, statement);
    }

    @Override
    public List<Todo> getAll() throws ClassNotFoundException, SQLException, IOException {
        List<Todo> list = new ArrayList<>();

        Connection connection = Connector.getConnection();
        PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM todos");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            list.add(new Todo(resultSet.getInt("id"), resultSet.getString("owner"), resultSet.getString("text"),
                    (resultSet.getInt("isCompleted") == 1) ? true : false));
        }

        Connector.closeQueryOperation(connection, statement, resultSet);

        return list;
    }

    @Override
    public Todo get(int id) throws ClassNotFoundException, SQLException, IOException {
        Todo res = null;

        Connection connection = Connector.getConnection();
        PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM todos WHERE id = ?");
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            res = new Todo(resultSet.getInt("id"), resultSet.getString("owner"), resultSet.getString("text"),
                    (resultSet.getInt("isCompleted") == 1) ? true : false);
        }

        Connector.closeQueryOperation(connection, statement, resultSet);

        return res;
    }

}
