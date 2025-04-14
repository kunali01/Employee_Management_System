Employee Management System (Spring Boot)
This is an Employee Management System developed using Spring Boot, Spring Data JPA, and MySQL. It allows you to perform CRUD operations on employee records and includes input validation and exception handling.

Features:
CRUD Operations: Create, Read, Update, and Delete employee records.

Search and Filters: Find employees by name, department, or salary range.

Validation:

* Name (required, min length 2, max length 50).

* Email (valid format, unique).

* Contact number (exactly 10 digits).

* Department (cannot be empty).

* Salary (minimum ₹10,000, maximum ₹10,00,000).

* Date of Joining (cannot be a future date).

Exception Handling: Handles missing fields, invalid inputs, and not found errors with clear messages.

API Endpoints:
POST /employees: Add a new employee.

GET /employees: Retrieve all employees.

GET /employees/{id}: Retrieve employee by ID.

PUT /employees/{id}: Update employee details.

DELETE /employees/{id}: Delete an employee.

GET /employees/search?name={name}: Search employees by name.

GET /employees/department/{department}: Filter employees by department.

GET /employees/salary-above/{amount}: Filter employees by salary.

GET /employees/count: Get the total number of employees.

* Technologies Used:
Spring Boot for backend development.
Spring Data JPA for ORM and database integration.
MySQL for relational database management.
Maven for dependency management.

