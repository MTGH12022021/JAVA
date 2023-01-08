package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class connectData {
    private static Connection connection;
    private String user;
    private String pass;

    public connectData() {
        connection = null;
        user = "sa";
        pass = "Han12022021";
        String databasename = "ChatApplication";
        String URL = "jdbc:sqlserver://localhost:1433;databaseName=" + databasename
                + ";encrypt=true;trustServerCertificate=true;";
//        user = System.getenv("USER");
//        pass = System.getenv("PASSWORD");
        System.out.println(user + pass);
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
