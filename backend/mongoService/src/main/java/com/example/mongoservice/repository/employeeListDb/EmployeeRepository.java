package com.example.mongoservice.repository.employeeListDb;

import com.example.mongoservice.model.employeeListDb.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee,Integer> {
    public Employee findByName(String name);
}
