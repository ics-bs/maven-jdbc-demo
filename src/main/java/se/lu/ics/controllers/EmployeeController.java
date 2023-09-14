package se.lu.ics.controllers;
import se.lu.ics.models.Employee;
import se.lu.ics.data.EmployeeDAO;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class EmployeeController {
    @FXML
    private TableView<Employee> tableViewEmployee;
    @FXML
    private TableColumn<Employee, String> tableColumnEmployeeId;
    @FXML
    private TableColumn<Employee, String> tableColumnEmployeeName;
    @FXML
    private TableColumn<Employee, Integer> tableColumnEmployeeSalary;

    @FXML
    private TextField textFieldEmployeeId;
    @FXML
    private TextField textFieldEmployeeName;
    @FXML
    private TextField textFieldEmployeeSalary;
    @FXML
    private Button buttonEmployeeAdd;


    // observablelist of employees
    public void initialize() {

        tableColumnEmployeeId.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        tableColumnEmployeeName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableColumnEmployeeSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));

        tableViewEmployee.setItems(EmployeeDAO.getEmployees());
    }

    @FXML
    public void buttonEmployeeAdd_OnClick(){
        String employeeId = textFieldEmployeeId.getText();
        String employeeName = textFieldEmployeeName.getText();
        int employeeSalary = Integer.parseInt(textFieldEmployeeSalary.getText());

        EmployeeDAO.addEmployee(employeeId, employeeName, employeeSalary);

    }
    
}
