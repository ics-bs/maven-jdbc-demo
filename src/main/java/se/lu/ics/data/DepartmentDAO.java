package se.lu.ics.data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import se.lu.ics.models.Department;
import se.lu.ics.models.Employee;

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

    // add
    public static void addDepartment(String name, String address, int budget){
        // add department to db
        String query = "INSERT INTO Department (DeptName, DeptAddress, DeptBudget) VALUES (?, ?, ?)";

        try (Connection connection = ConnectionHandler.getConnection()) {
            // Create a PreparedStatement to insert the employee
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, address);
            statement.setInt(3, budget);
            
            int rowsInserted = statement.executeUpdate();

            // If the insertion was successful, add to the observable list
            if (rowsInserted > 0) {
                Department department = new Department(name, address, budget);
                departments.add(department);
            }
        } catch (SQLException e) {
            // TODO: Error handling
            e.printStackTrace();
        }



    }

    public static ObservableList<Department> getDepartments() {
        return departments;
    }
    
}
