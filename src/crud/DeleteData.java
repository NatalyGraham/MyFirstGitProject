package crud;

import constants.Constants;
import utils.DbConn;
import validators.CheckBase;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteData {

    static int id;
    static String name;
    static String position;

    public static void main(String[] args) {

        id = 3;
        name = "Игорь";
        position = "менеджер";

        if (CheckBase.isExists()) {
            //deleteByID(id);
            //deleteByName(name);
            deleteByPosition(position);
        } else {
            System.out.println("База " + Constants.DB_NAME + " не существует. Создайте ее!");
        }
    }

    private static void deleteByID(int id) {

        String sql = "DELETE FROM "
                + Constants.TABLE_NAME
                + " WHERE id = ?";

        try (PreparedStatement stmt = DbConn.connect().prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Удалено.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void deleteByName(String name) {

        String sql = "DELETE FROM "
                + Constants.TABLE_NAME
                + " WHERE "
                + Constants.COLUMN_NAME
                + " = ?";

        try (PreparedStatement stmt = DbConn.connect().prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.executeUpdate();
            System.out.println("Удалено.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void deleteByPosition(String position) {

        String sql = "DELETE FROM "
                + Constants.TABLE_NAME
                + " WHERE "
                + Constants.COLUMN_POSITION
                + " = ?";

        try (PreparedStatement stmt = DbConn.connect().prepareStatement(sql)) {
            stmt.setString(1, position);
            stmt.executeUpdate();
            System.out.println("Удалено.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
