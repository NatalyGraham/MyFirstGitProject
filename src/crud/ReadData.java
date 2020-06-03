package crud;

import constants.Constants;
import utils.DbConn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadData {
    public static void main(String[] args) {
        ReadData readData = new ReadData();
        readData.selectAll();
    }

    public void selectAll() {

        String sql = "SELECT "
                + Constants.COLUMN_NAME + ","
                + Constants.COLUMN_POSITION + ","
                + Constants.COLUMN_PHONE + " "
                + "FROM "
                + Constants.TABLE_NAME;

        try (Statement stmt = DbConn.connect().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(
                        rs.getString("name") + "\t" +
                                rs.getString("position") + "\t" +
                                rs.getString("phone"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
