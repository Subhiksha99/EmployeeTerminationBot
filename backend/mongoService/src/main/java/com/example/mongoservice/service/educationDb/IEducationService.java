package com.example.mongoservice.service.educationDb;

import com.example.mongoservice.exception.EmployeeFoundException;
import com.example.mongoservice.exception.EmployeeNotFoundException;
import com.example.mongoservice.exception.InternalErrorException;
import com.example.mongoservice.model.educationDb.Education;

import java.util.List;
public interface IEducationService {
    // abstract method to fetch all Education Details from the database
    List<Education> getAllEducationDetails();

    // abstract method to get education details of an employee based on employeeID
    Education getEducationDetailsById(long empId) throws EmployeeNotFoundException;

    // method to add education details of an employee to the db
    Education addEducationDetails(Education education) throws EmployeeFoundException;

    // abstract method to update education details of an existing employee in the database
    Education updateEducationDetails(Education education) throws EmployeeNotFoundException, InternalErrorException;

    // method to delete education details of an employee from the database
    Education deleteEducationDetails(long id) throws EmployeeNotFoundException, InternalErrorException;
}
