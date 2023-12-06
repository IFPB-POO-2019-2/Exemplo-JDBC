package database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConFactory {

    private Connection connection;

    public Connection getConnection() throws SQLException, ClassNotFoundException, IOException {
        Class.forName("org.postgresql.Driver");

        FileInputStream in = new FileInputStream("database.properties");
        Properties props = new Properties();
        props.load(in);

        String url = props.getProperty("url");
        connection = DriverManager.getConnection(url, props);
        return connection;
    }

}
