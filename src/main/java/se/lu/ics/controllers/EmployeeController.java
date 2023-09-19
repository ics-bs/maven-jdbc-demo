package se.lu.ics.controllers;
import se.lu.ics.models.Employee;
import se.lu.ics.data.EmployeeDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.Scene;


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
    @FXML
    private Button buttonNavigateToDepartment;


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

    @FXML
    public void buttonNavigateToDepartment_OnClick(){
        String path = "/fxml/Department.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
        try {

            // Load the new root layout
            AnchorPane root = loader.load();

            // Get the current stage or use some method to fetch it.
            Stage departmentStage = new Stage(); 

            // Set the new scene to the stage
            Scene departmentScene = new Scene(root);

            // Set the scene to the stage
            departmentStage.setScene(departmentScene);

            departmentStage.setTitle("Departments");
            departmentStage.show();
            
            // Close the current stage
            Stage currentStage = (Stage) buttonNavigateToDepartment.getScene().getWindow();
            currentStage.close();
            
        } catch (Exception e) {
            // TODO: Proper error handling
            e.printStackTrace();
        }
        
    }
    
}
