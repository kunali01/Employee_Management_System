package com.Employee_Management.employee.controller;
import java.util.List;
import com.Employee_Management.employee.entity.Employee;
import com.Employee_Management.employee.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
@Autowired
private EmployeeService empService;

    public EmployeeController(){
        System.out.println("Employee object is created");
    }
@PostMapping("/addEmployee")
  public ResponseEntity<String> addEmployee(@RequestBody @Valid Employee emp){
        String result = empService.addEmployee(emp);
        if(result.contains("successfully")){
            return ResponseEntity.ok("Employee added succesfully");
        }else {
            return ResponseEntity.badRequest().body(result);
        }

  }
  @GetMapping("/getAllEmployees")
public ResponseEntity<?> getAllEmployees(){

        List<Employee> allemp =empService.getEmployees();
         if(allemp != null){
              return ResponseEntity.ok().body(allemp);
          }else {
             return ResponseEntity.status(404).body("no record found");
  }

}
@GetMapping("/getEmployeeById/{id}")
public ResponseEntity<?>getEmployeeById(@PathVariable int id){
    Employee emp = empService.getEmployeeById(id);

    if(emp!=null){
        return ResponseEntity.ok().body(emp);
    }else {
        return ResponseEntity.status(404).body("No record found");
    }

}
@PutMapping("/updateEmployee/{id}")
public ResponseEntity<String> updateEmployee(@PathVariable int id, @RequestBody @Valid Employee emp ){
        String result = empService.updateEmployee(id, emp);
        if(result.contains("successfully")){
            return ResponseEntity.ok(result);
        }else {
            return ResponseEntity.status(404).body(result);
        }
}
@DeleteMapping("/deleteEmployee/{id}")
public ResponseEntity<String> deleteEmployee(@PathVariable int id){
        String result = empService.deleteEmployee(id);
        if(result.contains("successfully")){
            return ResponseEntity.ok(result);
        }else {
            return ResponseEntity.status(404).body(result);
        }
    }
    @GetMapping("/searchEmpName/{name}")
    public ResponseEntity<?>searchByEmployeeName(@PathVariable String name) {
        List<Employee> emp = empService.searchByEmployeeName(name);

        if (emp != null && !emp.isEmpty()) {
            return ResponseEntity.ok().body(emp);
        } else {
            return ResponseEntity.status(404).body("No record found for name " + name);
        }
    }

    @GetMapping("/searchDepartment/{department}")
    public ResponseEntity<?>getByEmployeeDepartment(@PathVariable String department) {
        List<Employee> emp = empService.findByEmployeeDepartment(department);

        if (!emp.isEmpty()) {
            return ResponseEntity.ok().body(emp);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }
    @GetMapping("/findSalary/{amount}")
    public ResponseEntity<?> getEmployeeBySalary(@PathVariable double amount){
        List<Employee> emp = empService.findBySalaryAmount(amount);
        if (!emp.isEmpty()) {
            return ResponseEntity.ok().body(emp);
        } else {
            return ResponseEntity.status(404).body("no employee found with above salary"+amount);
        }
    }
    @GetMapping("/totalemp")
    public ResponseEntity<Long>getTotalEmployees(){
        long count = empService.getTotalEmployee();
        return ResponseEntity.ok(count);
    }
}
