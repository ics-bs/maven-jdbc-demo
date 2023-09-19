package se.lu.ics.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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

    public void initialize() {
        tableColumnDepartmentName.setCellValueFactory(new PropertyValueFactory<Department, String>("departmentName"));
        tableColumnDepartmentAddress.setCellValueFactory(new PropertyValueFactory<Department, String>("departmentAddress"));
        tableColumnDepartmentBudget.setCellValueFactory(new PropertyValueFactory<Department, Integer>("departmentBudget"));

        tableViewDepartment.setItems(DepartmentDAO.getDepartments());
    }

    @FXML
    public void buttonDepartmentAdd_OnClick() {
        String departmentName = textFieldDepartmentName.getText();
        String departmentAddress = textFieldDepartmentAddress.getText();
        int departmentBudget = Integer.parseInt(textFieldDepartmentBudget.getText());

        DepartmentDAO.addDepartment(departmentName, departmentAddress, departmentBudget);
    }
    
}
