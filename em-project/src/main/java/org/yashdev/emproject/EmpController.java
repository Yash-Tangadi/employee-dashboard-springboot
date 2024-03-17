package org.yashdev.emproject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {

    // List<Employee> employees = new ArrayList<>();

    @Autowired
    EmployeeService employeeService;

    @GetMapping("employees")
    public List<Employee> getAllEmployees() {
        return employeeService.readEmployees();
    }

    @PostMapping("employees")
    public String createEmployee(@RequestBody Employee employee) {
        // employees.add(employee);
        return employeeService.createEmployee(employee);

    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable Long id){

       if ( employeeService.deleteEmployee(id)){
        return "Deleted Successfully";
       }
       return "Not Found";

    }


}
