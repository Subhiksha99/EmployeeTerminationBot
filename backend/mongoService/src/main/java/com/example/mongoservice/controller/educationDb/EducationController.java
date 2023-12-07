package com.example.mongoservice.controller.educationDb;

import com.example.mongoservice.exception.EmployeeFoundException;
import com.example.mongoservice.exception.EmployeeNotFoundException;
import com.example.mongoservice.exception.InternalErrorException;
import com.example.mongoservice.model.educationDb.Education;
import com.example.mongoservice.service.educationDb.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("educationDetails")
public class EducationController {

    // Injecting the service to the controller
    @Autowired
    private IEducationService educationService;

    // Creating an API to GET all Education Details from the DB
    @GetMapping("/all")
    public ResponseEntity<List<Education>> getAllEducationDetails(){
        return new ResponseEntity<>(educationService.getAllEducationDetails(), HttpStatus.OK);
    }

    // Creating an API to GET education details of a particular Employee from the database
    @GetMapping("/{id}")
    public ResponseEntity<Education> getEducationDetailsById(@PathVariable("id") long empId) throws EmployeeNotFoundException {
        return new ResponseEntity<>(educationService.getEducationDetailsById(empId), HttpStatus.FOUND);
    }

    // Creating an API to ADD education details of an employee to the Database
    @PostMapping("/add")
    public ResponseEntity<Education> addEducationDetails(@RequestBody Education education) throws EmployeeFoundException {
        return new ResponseEntity<>(educationService.addEducationDetails(education), HttpStatus.CREATED);
    }

    // Creating an API to UPDATE education details of an employee in the database
    @PutMapping("/update")
    public ResponseEntity<Education> updateEducationDetails(@RequestBody Education education) throws EmployeeNotFoundException, InternalErrorException {
        return new ResponseEntity<>(educationService.updateEducationDetails(education), HttpStatus.OK);
    }

    // Creating an API to DELETE education details of an employee from the database based on employeeId
    @DeleteMapping("deleteById")
    public ResponseEntity<Education> deleteEducationDetails(@RequestParam("id") long id) throws EmployeeNotFoundException, InternalErrorException {
        return new ResponseEntity<>(educationService.deleteEducationDetails(id), HttpStatus.OK);
    }

}
