package crud;

import constants.Constants;
import models.Employee;
import utils.DbConn;
import validators.CheckBase;

import java.sql.PreparedStatement;
import java.sql.SQLException;

class AddSingleData {
    public static void main(String[] args) {
        String name = "Юрий";
        String position = "охранник";
        String phone = "+38-067-968-52-11";


        Employee employee = new Employee();

        if (CheckBase.isExists()) {

            employee.setName(name);
            employee.setPosition(position);
            employee.setPhone(phone);
            insert(employee.getName(),
                    employee.getPosition(),
                    employee.getPhone()
            );
        } else {
            System.out.println("База " + Constants.DB_NAME + " не существует. Создайте ее!");
        }
    }

    public static void insert(String name, String position, String phone) {

        String sql = "INSERT INTO "
                + Constants.TABLE_NAME
                + "("
                + Constants.COLUMN_NAME + ","
                + Constants.COLUMN_POSITION + ","
                + Constants.COLUMN_PHONE + " "
                + ") VALUES(?,?,?)";


        try (
                PreparedStatement stmt = DbConn.connect().prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, position);
            stmt.setString(3, phone);
            stmt.executeUpdate();
            System.out.println("Сотрудник в базе: " + name);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
