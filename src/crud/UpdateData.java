package crud;

import constants.Constants;
import utils.DbConn;
import validators.CheckBase;
import validators.CheckData;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UpdateData {

    static int id;
    static String name;
    static String position;
    static String phone;

    public static void main(String[] args) throws SQLException {

        id = 10;
        //name = "Игорь";
        //position = "директор";
        name = "Бронислав";
        position = "водитель";


        if (CheckBase.isExists()) {
            if (CheckData.isExist(name)) {   //проверка существования изменяемых данных
                update(name, position);
            } else {                         //но в validators CheckData не смогла правильно обработать ответ
                System.out.println("Такого имени нет в таблице!");
            }
            //update(10, name, position);
        } else {
            System.out.println("Базы нет!");
        }
    }

    private static void update(int id, String name, String position) {

        String sql = "UPDATE "
                + Constants.TABLE_NAME
                + " SET " + Constants.COLUMN_NAME + " = ? , "
                + Constants.COLUMN_POSITION + " = ? "
                + "WHERE " + Constants.COLUMN_ID + " = ?";

        try (PreparedStatement stmt = DbConn.connect().prepareStatement(sql)) {
            // установка соответствующих параметров
            stmt.setString(1, name);
            stmt.setString(2, position);
            stmt.setInt(3, id);
            // выполнение запроса в БД
            stmt.executeUpdate();
            System.out.println("Обновлено.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void update(String name, String position) {

        String sql = "UPDATE "
                + Constants.TABLE_NAME
                + " SET " + Constants.COLUMN_POSITION + " = ? "
                + "WHERE " + Constants.COLUMN_NAME + " = ?";

        //UPDATE employees SET position = 'uuu' WHERE name = 'Боря'

        try (PreparedStatement stmt = DbConn.connect().prepareStatement(sql)) {
            // установка соответствующих параметров
            stmt.setString(1, position);
            stmt.setString(2, name);
            // выполнение запроса в БД
            stmt.executeUpdate();
            System.out.println("Обновлено.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
