/*
-- Uncomment to drop
DROP TABLE Employee
DROP TABLE Department

*/


-- Create tables

CREATE TABLE Department
(
	DeptName	VARCHAR(100),
	DeptAddress VARCHAR(100) CONSTRAINT DF_Department_DeptAddress DEFAULT 'Lund',
	DeptBudget	INT,

	CONSTRAINT PK_Department_DeptName PRIMARY KEY(DeptName),
	CONSTRAINT CK_Department_DeptBudget CHECK(DeptBudget >= 0)
)

CREATE TABLE Employee
(
	EmpId		VARCHAR(100),
	EmpName		VARCHAR(100),
	EmpSalary	INT,
	DeptName	VARCHAR(100),

	CONSTRAINT PK_Employee_EmpId PRIMARY KEY(EmpId),
	CONSTRAINT DK_Employee_Department_DeptName FOREIGN KEY(DeptName) REFERENCES Department(DeptName),
	CONSTRAINT CK_Employee_EmpSalary CHECK(EmpSalary >= 0)
)

-- Inserting data into Department
INSERT INTO Department(DeptName, DeptAddress, DeptBudget)
VALUES 
('HR', 'Lund Building A', 500000),
('Finance', 'Lund Building B', 400000),
('IT', 'Lund Building C', 600000),
('Marketing', 'Lund Building D', 550000),
('Sales', 'Lund Building E', 530000);

-- Inserting data into Employee
INSERT INTO Employee(EmpId, EmpName, EmpSalary, DeptName)
VALUES
('E001', 'Alice Smith', 55000, 'HR'),
('E002', 'Bob Johnson', 60000, 'Finance'),
('E003', 'Charlie Williams', 62000, 'IT'),
('E004', 'David Brown', 53000, 'Marketing'),
('E005', 'Eve Jones', 56000, 'Sales'),
('E006', 'Frank Miller', 54000, 'HR'),
('E007', 'Grace Davis', 57000, 'Finance'),
('E008', 'Henry Garcia', 58000, 'IT'),
('E009', 'Ivy Rodriguez', 52000, 'Marketing'),
('E010', 'Jack Lee', 59000, 'Sales'),
('E011', 'Katie White', 55000, 'HR'),
('E012', 'Louis Martin', 58000, 'Finance'),
('E013', 'Mia Taylor', 52500, 'IT'),
('E014', 'Nathan Wilson', 59500, 'Marketing'),
('E015', 'Olivia Clark', 55500, 'Sales');
