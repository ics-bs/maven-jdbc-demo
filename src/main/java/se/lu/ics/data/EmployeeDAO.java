package se.lu.ics.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import se.lu.ics.models.Department;
import se.lu.ics.models.Employee;

public class EmployeeDAO {
    
    private static ObservableList<Employee> employees = FXCollections.observableArrayList();

    static {
        updateEmployeesFromDatabase();
    }

    public static void updateEmployeesFromDatabase() {
        // LEFT OUTER JOIN to get all employees, even those without a department
        String query = "SELECT Employee.EmpId, EmpName, EmpSalary, Department.DeptName, DeptAddress, DeptBudget"
        + "FROM Employee "
        + "LEFT OUTER JOIN Department "
        + "ON Employee.DeptName = Department.DeptName";

        
        try (Connection connection = ConnectionHandler.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            employees.clear();

            while (resultSet.next()) {
                String employeeId = resultSet.getString("EmpId");
                String employeeName = resultSet.getString("EmpName");
                int employeeSalary = resultSet.getInt("EmpSalary");
                String departmentName = resultSet.getString("DeptName");
                String departmentAddress = resultSet.getString("DeptAddress");
                int departmentBudget = resultSet.getInt("DeptBudget");

                // If the employee has a department, create a department object
                Department department = new Department(departmentName, departmentAddress, departmentBudget);

                // Create an employee object with the department object
                Employee employee = new Employee(employeeId, employeeName, employeeSalary, department);

                // Add the employee to the observable list
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

 
    public static void addEmployee(String employeeId, String employeeName, int employeeSalary) {
        String query = "INSERT INTO Employee (EmpId, EmpName, EmpSalary) VALUES (?, ?, ?)";
        
        try (Connection connection = ConnectionHandler.getConnection()) {
            // Create a PreparedStatement to insert the employee
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, employeeId);
            statement.setString(2, employeeName);
            statement.setInt(3, employeeSalary);
            
            int rowsInserted = statement.executeUpdate();

            // If the insertion was successful, add to the observable list
            if (rowsInserted > 0) {
                Employee employee = new Employee(employeeId, employeeName, employeeSalary);
                employees.add(employee);
            }
        } catch (SQLException e) {
            // TODO: Error handling
            e.printStackTrace();
        }
    }

    public static ObservableList<Employee> getEmployees() {
        return employees;
    }
}
