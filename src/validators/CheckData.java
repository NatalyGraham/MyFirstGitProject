package validators;

import constants.Constants;
import utils.DbConn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Nataly Haievska
 * @date 01.06.2020
 */
public class CheckData {
    public static int id;

    public static boolean isExist(String value) throws SQLException {
        boolean isExist = false;
        String sql = "SELECT id FROM "
                + Constants.TABLE_NAME
                + " WHERE "
                + Constants.COLUMN_NAME
                + " = '"
                + value + "'";

        Statement stmt = DbConn.connect().createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            id = rs.getInt("id");   // я так получаю ответ в виде id
            //и если он не 0, то такие данные в таблице существуют.
            isExist = id != 0;
        }

        return isExist;
    }
}
