package crud;

import constants.Constants;
import models.Employee;
import utils.DbConn;
import validators.CheckBase;

import java.sql.PreparedStatement;
import java.sql.SQLException;

class CreateData {
    public static void main(String[] args) {
        String[] names = {"Григорий", "Валентина", "Игорь", "Тамара"};
        String[] positions = {"бухгалтер", "секретарь", "менеджер", "менеджер"};
        String[] phones = {"+38-095-123-45-69", "+38-095-123-78-69", "+38-067-123-45-55", "+38-093-123-55-75"};


        Employee employee = new Employee();

        if (CheckBase.isExists()) {
            for (int i = 0; i < names.length; i++) {
                employee.setName(names[i]);
                employee.setPosition(positions[i]);
                employee.setPhone(phones[i]);
                insert(employee.getName(),
                        employee.getPosition(),
                        employee.getPhone()
                );
            }
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
                + ") VALUES(?,?,?)";//*/


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
