package database;


import constants.Constants;
import validators.CheckBase;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Nataly Haievska
 * @date 29.05.2020
 */
public class DataBase {
    public static void main(String[] args) {

        if (CheckBase.isExists()) {
            System.out.println("База " + Constants.DB_NAME + " уже существует.");
        } else {
            createDatabase(Constants.DB_NAME);
        }
    }

    public static void createDatabase(String fileName) {
        // Путь к создаваемой БД.
        String url = Constants.DB_DRIVER + ":" + Constants.DB_BASE_URL + fileName;

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("Драйвер - " + meta.getDriverName());
                System.out.println("База создана.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
