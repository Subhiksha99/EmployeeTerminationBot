package com.example.mongoservice.controller.employeeListDb;

import com.example.mongoservice.model.employeeListDb.Employee;
import com.example.mongoservice.service.employeeListDb.EmployeeServiceImpl;
import com.example.mongoservice.service.employeeListDb.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class EmployeeController {

     @Autowired
    IEmployeeService employeeService;

     @GetMapping("/employee/welcome")
     public String greet(){
         return "Employee controller";
     }
    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable int id) throws Exception
    {
          return employeeService.getEmployeeById(id);
    }

    @GetMapping("/employee/getname/{name}")
    public Employee getEmployeeByName(@PathVariable String name)
    {
        return employeeService.getEmployeeByName(name);
    }
    @GetMapping("/employee/all")
    public List<Employee> getAllEmployee(){
         return employeeService.getAllEmployee();
    }

    // POST
    @PostMapping ("/employee/add")
    public Employee addEmployee(@RequestBody Employee employee)  {
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/employee/update")
    public Employee updateEmployee(@RequestBody Employee employee){
         return employeeService.updateEmployee(employee);
    }

}
