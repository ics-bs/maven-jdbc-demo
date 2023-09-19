package se.lu.ics.data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import se.lu.ics.models.Department;

public class DepartmentDAO {
    private static ObservableList<Department> departments = FXCollections.observableArrayList();

    static {
        updateDepartmentsFromDatabase();
    }

    public static void updateDepartmentsFromDatabase() {
        String query = "SELECT * FROM Department";

        try (Connection connection = ConnectionHandler.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            departments.clear();

            while (resultSet.next()) {
                String departmentId = resultSet.getString("DeptName");
                String name = resultSet.getString("DeptAddress");
                int budget = resultSet.getInt("DeptBudget");
                Department department = new Department(departmentId, name, budget);
                departments.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    

    public static ObservableList<Department> getDepartments() {
        return departments;
    }
    
}
