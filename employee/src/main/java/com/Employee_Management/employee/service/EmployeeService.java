package com.Employee_Management.employee.service;

import com.Employee_Management.employee.entity.Employee;
import com.Employee_Management.employee.exception.EmployeeNotFoundException;
import com.Employee_Management.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
@Autowired
private EmployeeRepository empRepo;

public String addEmployee(Employee emp){
    try{
        empRepo.save(emp);
        return "Employee added successfully";
    } catch (Exception e) {
        e.printStackTrace();
        return "unable to added employee"+e.getMessage();
    }

}
public List<Employee> getEmployees(){
       List<Employee> allemployees= empRepo.findAll();
         if(allemployees!=null && !allemployees.isEmpty()){
           return allemployees;
         }else{
             return null;
         }
    }

    public Employee getEmployeeById(int id){
        return empRepo.findById(id).orElseThrow(()-> new EmployeeNotFoundException("Employee not found " +
                "with id" +id));
    }

    public String updateEmployee(int id, Employee updatedEmp){
        Employee existingEmp = empRepo.findById(id).orElseThrow(()-> new EmployeeNotFoundException("Employee not found " +
                "with id" +id));
        existingEmp.setName(updatedEmp.getName());
        existingEmp.setEmail(updatedEmp.getEmail());
        existingEmp.setDepartment(updatedEmp.getDepartment());
        existingEmp.setSalary(updatedEmp.getSalary());
        existingEmp.setDoj(updatedEmp.getDoj());
        empRepo.save(existingEmp);
        return "Employee Updated Successfully";
       }

    public String deleteEmployee(int id){
       Employee emp = empRepo.findById(id).orElseThrow(()-> new EmployeeNotFoundException("Employee not found " +
                "with id" +id));
            empRepo.deleteById(id);
            return "Employee deleted succesfully";

    }
    public List<Employee>searchByEmployeeName(String name){
    return empRepo.findByName(name);
    }

    public List<Employee>findByEmployeeDepartment(String department){
        return empRepo.findByDepartment(department);
    }

    public List<Employee> findBySalaryAmount(double amount){
        return empRepo.findBySalary(amount);
  }

    public long getTotalEmployee(){
        return empRepo.count();
    }
}
