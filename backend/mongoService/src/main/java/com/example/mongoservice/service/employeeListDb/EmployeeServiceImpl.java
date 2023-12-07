package com.example.mongoservice.service.employeeListDb;

import com.example.mongoservice.exception.EmployeeNotFoundException;
import com.example.mongoservice.model.employeeListDb.Employee;
import com.example.mongoservice.repository.employeeListDb.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee getEmployeeById(int id) throws EmployeeNotFoundException {

        Optional<Employee> opt=employeeRepository.findById(id);
        if(opt.isPresent()){
            return opt.get();
        }
        throw new EmployeeNotFoundException("The Employee is not found with given id: "+id);
    }

    @Override
    public Employee getEmployeeByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
