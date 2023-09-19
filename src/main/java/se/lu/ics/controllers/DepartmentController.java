package se.lu.ics.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Scene;


import se.lu.ics.models.Department;
import se.lu.ics.data.DepartmentDAO;

public class DepartmentController {
    @FXML
    private TableView<Department> tableViewDepartment;
    @FXML
    private TableColumn<Department, String> tableColumnDepartmentName;
    @FXML
    private TableColumn<Department, String> tableColumnDepartmentAddress;
    @FXML
    private TableColumn<Department, Integer> tableColumnDepartmentBudget;
    @FXML
    private TextField textFieldDepartmentName;
    @FXML
    private TextField textFieldDepartmentAddress;
    @FXML
    private TextField textFieldDepartmentBudget;
    @FXML
    private Button buttonDepartmentAdd;
    @FXML
    private Button buttonNavigateToEmployee;

    public void initialize() {
        tableColumnDepartmentName.setCellValueFactory(new PropertyValueFactory<Department, String>("name"));
        tableColumnDepartmentAddress.setCellValueFactory(new PropertyValueFactory<Department, String>("address"));
        tableColumnDepartmentBudget.setCellValueFactory(new PropertyValueFactory<Department, Integer>("budget"));

        tableViewDepartment.setItems(DepartmentDAO.getDepartments());
    }

    @FXML
    public void buttonDepartmentAdd_OnClick() {
        String departmentName = textFieldDepartmentName.getText();
        String departmentAddress = textFieldDepartmentAddress.getText();
        int departmentBudget = Integer.parseInt(textFieldDepartmentBudget.getText());

        DepartmentDAO.addDepartment(departmentName, departmentAddress, departmentBudget);
    }

    @FXML
    public void buttonNavigateToEmployee_OnClick() {
        String path = "/fxml/Employee.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(path));

        try {
            AnchorPane root = loader.load();
            Scene employeeScene = new Scene(root);
            Stage employeeStage = new Stage();
            employeeStage.setScene(employeeScene);

            employeeStage.setTitle("Employees");
            employeeStage.show();

            // Close the current stage
            Stage currentStage = (Stage) buttonNavigateToEmployee.getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {
            // TODO: Proper error handling
            e.printStackTrace();
        }

    }
    
}
