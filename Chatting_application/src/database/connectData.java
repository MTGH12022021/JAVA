package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class connectData {
    private Connection connection;
    private String user;
    private String pass;

    public connectData() {
        connection = null;
        user = "";
        pass = "";
        String databasename = "ChatApplication";
        String URL = "jdbc:sqlserver://localhost:1433;databaseName=" + databasename
                + ";encrypt=true;trustServerCertificate=true;";
        user = System.getenv("USER");
        pass = System.getenv("PASSWORD");

        try {
            connection = DriverManager.getConnection(URL, user, pass);
            System.out.println("Connect ");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {

        return connection;
    }


}
