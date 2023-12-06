package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConFactory {

    private Connection connection;

    public Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost/test";
        Properties props = new Properties();
        props.setProperty("user", "fred");
        props.setProperty("password", "secret");
        props.setProperty("ssl", "true");
        connection = DriverManager.getConnection(url, props);
        return connection;
    }

}
