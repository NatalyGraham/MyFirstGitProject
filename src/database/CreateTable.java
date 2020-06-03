package database;

import constants.Constants;
import validators.CheckBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    public static void main(String[] args) {

        if (CheckBase.isExists()) {
            createTable();
        } else {
           System.out.println("База " + Constants.DB_NAME + " не существует. Создайте ее!");
        }
    }

    public static void createTable() {
        String url = Constants.DB_DRIVER + ":"+ Constants.DB_BASE_URL + Constants.DB_NAME;
        String sql = "CREATE TABLE IF NOT EXISTS "
                + Constants.TABLE_NAME + "("
                + Constants.COLUMN_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                + Constants.COLUMN_NAME + " TEXT NOT NULL,"
                + Constants.COLUMN_POSITION + " TEXT NOT NULL,"
                + Constants.COLUMN_PHONE + " TEXT NOT NULL"
                + ");";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Таблица создана.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
