package com.example.mongoservice.service.employeeListDb;

import com.example.mongoservice.exception.EmployeeNotFoundException;
import com.example.mongoservice.model.employeeListDb.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IEmployeeService {
    public Employee getEmployeeById(int id) throws EmployeeNotFoundException;
    public Employee getEmployeeByName(String name);
    public List<Employee> getAllEmployee();
    public Employee addEmployee(Employee employee);

    Employee updateEmployee(Employee employee);
}
