package com.example.mongoservice.controller.personalDetailsDb;

import com.example.mongoservice.exception.EmployeeNotFoundException;
import com.example.mongoservice.model.personalDetailsDb.Address;
import com.example.mongoservice.model.personalDetailsDb.PersonalDetails;
import com.example.mongoservice.exception.EmployeeFoundException;
import com.example.mongoservice.exception.IdMismatchException;
import com.example.mongoservice.exception.InternalErrorException;
import com.example.mongoservice.service.personalDetailsDb.IPersonalDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personalDetails")
public class PersonalDetailsController {

    // Injecting Service to the Controller
    @Autowired
    IPersonalDetailsService personalDetailsService;

    // Creating an API to fetch all documents from the PersonalDetails collection
    @GetMapping("/all")
    public ResponseEntity<List<PersonalDetails>> getAllPersonalDetails(){
        List<PersonalDetails> personalDetailsList = personalDetailsService.getAllPersonalDetails();
        // return a ResponseEntity with response and status code
        return new ResponseEntity<>(personalDetailsList, HttpStatus.OK);
    }

    // Creating an API to fetch a document based on id from the PersonalDetails collection
    @GetMapping("/{id}")
    public ResponseEntity<PersonalDetails> getPersonalDetailsById(@PathVariable long id) throws EmployeeNotFoundException {
        // return a ResponseEntity with response and status code
        return new ResponseEntity<>(personalDetailsService.getPersonalDetailsById(id), HttpStatus.OK);
    }

    // Creating an API to add an employee's PersonalDetails in the database
    @PostMapping("/add")
    public ResponseEntity<PersonalDetails> addPersonalDetails(@RequestBody PersonalDetails details) throws EmployeeFoundException, IdMismatchException {
        // calling service method to add personal details of an employee to the database
        PersonalDetails addedDetails = personalDetailsService.addPersonalDetails(details);
        return new ResponseEntity<>(addedDetails, HttpStatus.ACCEPTED);
    }

    // Creating an API to update an employee's Address in the database
    @PutMapping("/{employeeId}/update/{addressId}")
    public ResponseEntity<PersonalDetails> updateAddress(@PathVariable long employeeId, @PathVariable long addressId, @RequestBody Address address) throws InternalErrorException, IdMismatchException, EmployeeNotFoundException {
        PersonalDetails updatedDetails = personalDetailsService.updateAddress(employeeId, addressId, address);
        return new ResponseEntity<>(updatedDetails, HttpStatus.OK);
    }

    // Creating an API to update an employee's personal details in the database
    @PutMapping("update/")
    public ResponseEntity<PersonalDetails> updatePersonalDetails(@RequestBody PersonalDetails personalDetails) throws IdMismatchException, EmployeeNotFoundException, InternalErrorException{
        PersonalDetails updatedDetails = personalDetailsService.updatePersonalDetails(personalDetails);
        return new ResponseEntity<>(updatedDetails, HttpStatus.OK);
    }

    // Creating an API to delete the personal details of an employee
    @DeleteMapping("deleteById")
    public ResponseEntity<PersonalDetails> deletePersonalDetailsById(@RequestParam("id") long id) throws EmployeeNotFoundException, InternalErrorException {
        return new ResponseEntity<>(personalDetailsService.deleteDetailsById(id), HttpStatus.OK);
    }

}
