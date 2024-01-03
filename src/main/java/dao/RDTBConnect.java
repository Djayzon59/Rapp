package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RDTBConnect {

    private static Connection connexion;

    private RDTBConnect() {
    }


    public static Connection getInstance() {
        if (connexion == null) {
            try {
                String dbURL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=RDTB;encrypt=false";
                String user = "sa";
                String pass = "azerty@123456";
                connexion = DriverManager.getConnection(dbURL, user, pass);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connexion;
    }

}
