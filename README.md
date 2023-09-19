### Example Maven project with JavaFX, JDBC and DAO pattern

This project exemplifies the following:
- DAO pattern applied to Java and JDBC for two entities (Employee entity is associated to department entity)
- Multiple fxml files
- Multiple Controllers (1 per fxml file)
- Nesting of fxml files (Main.fxml has two tabs that use Employee.fxml and Department.fxml for content)
- Department.fxml and Employee.fxml on separate windows (NOTE: It does not make sense to have both, however this is a demo to show you the stucture)
- The TableView employeeTableView also shows data about departments that the employees work at. This is not possible without some CellValueFactory tricks that you can see in the code

Note
- No error handling implemented
- Illogical GUI structure - meant for demoing different alternatives
- Department-Employee association is only navigable from Employee side

Setup
- Database schema is included in the resources/dbschema folder
- Create a config file (.properties) under resources/config directory (ConnectionHandler.java expects one)

Enjoy!
