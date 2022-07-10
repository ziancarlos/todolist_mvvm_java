package tools;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import com.mysql.cj.jdbc.Driver;

public class MysqlConnector {

    /**
     * Creating new connection to database
     * 
     * @return the connection
     * @throws ClassNotFoundException
     * 
     */
    public static java.sql.Connection getConnection() throws SQLException, IOException, ClassNotFoundException {
        String databaseName = "";
        String databaseUsername = "";
        String databasePassword = "";

        Properties properties = new Properties();
        properties.load(new FileInputStream("src/config.properties"));

        databaseName = properties.getProperty("database.name");
        databaseUsername = properties.getProperty("database.username");
        databasePassword = properties.getProperty("database.password");

        Driver mysqlDriver = new com.mysql.cj.jdbc.Driver();
        DriverManager.registerDriver(mysqlDriver);
        Class.forName("com.mysql.cj.jdbc.Driver");

        java.sql.Connection conn = null;

        conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseName, databaseUsername,
                databasePassword);

        return conn;
    }

    /**
     * Closing the connection to database
     * 
     * @param conn      the connection
     * @param statement the statement
     * @param resultSet the result set
     * 
     */
    public static void closeQueryOperation(java.sql.Connection conn, Statement statement, ResultSet resultSet)
            throws SQLException {
        if (conn != null)
            conn.close();
        if (statement != null)
            statement.close();
        if (resultSet != null)
            resultSet.close();
    }

    /**
     * Closing the connection to database
     * 
     * @param conn      the connection
     * @param statement the statement
     * 
     */
    public static void closeQueryOperation(java.sql.Connection conn, Statement statement) throws SQLException {
        if (conn != null)
            conn.close();
        if (statement != null)
            statement.close();
    }

    /**
     * Closing the connection to database with prepare statement
     * 
     * @param conn              the connection
     * @param preparedStatement the prepared statement
     * @param resultSet         the result set
     * 
     */
    public static void closeQueryOperationWithPreparedStatement(java.sql.Connection conn, PreparedStatement statement,
            ResultSet resultSet) throws SQLException {
        if (conn != null)
            conn.close();
        if (statement != null)
            statement.close();
        if (resultSet != null)
            resultSet.close();
    }

    /**
     * Closing the connection to database with prepare statement
     * 
     * @param conn              the connection
     * @param preparedStatement the prepared statement
     * 
     */
    public static void closeQueryOperationWithPreparedStatement(java.sql.Connection conn, PreparedStatement statement)
            throws SQLException {
        if (conn != null)
            conn.close();
        if (statement != null)
            statement.close();
    }

}