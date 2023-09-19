package se.lu.ics.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Department {
    private String name;
    private String address;
    private int budget;
    private ObservableList<Employee> employees;

    public Department(String name, String address, int budget) {
        this.name = name;
        this.address = address;
        this.budget = budget;
        this.employees = FXCollections.observableArrayList();
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }   

    public int getBudget() {
        return budget;
    }

    public ObservableList<Employee> getEmployees() {
        return employees;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address= address;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
}
