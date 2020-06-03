package utils;

import constants.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConn {
    public static Connection connect() {
        String url = Constants.DB_DRIVER + ":" + Constants.DB_BASE_URL + Constants.DB_NAME;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
