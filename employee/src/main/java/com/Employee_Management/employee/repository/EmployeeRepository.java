package com.Employee_Management.employee.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Employee_Management.employee.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    List<Employee> findByName(String name);
    List<Employee> findByDepartment(String department);
    List<Employee> findBySalary(double amount);

}
