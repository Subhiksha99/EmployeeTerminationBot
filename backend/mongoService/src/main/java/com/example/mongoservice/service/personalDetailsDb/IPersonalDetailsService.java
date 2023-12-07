package com.example.mongoservice.service.personalDetailsDb;

import com.example.mongoservice.model.personalDetailsDb.Address;
import com.example.mongoservice.model.personalDetailsDb.PersonalDetails;
import com.example.mongoservice.exception.EmployeeFoundException;
import com.example.mongoservice.exception.EmployeeNotFoundException;
import com.example.mongoservice.exception.IdMismatchException;
import com.example.mongoservice.exception.InternalErrorException;

import java.util.List;

public interface IPersonalDetailsService {

    // abstract method to get all personal details from personal details collection
    List<PersonalDetails> getAllPersonalDetails();

    // method to get personalDetails of an employee based on Id
    PersonalDetails getPersonalDetailsById(long id) throws EmployeeNotFoundException;

    // abstract method to add personal details to the database
    PersonalDetails addPersonalDetails(PersonalDetails details) throws EmployeeFoundException, IdMismatchException;

    // abstract method to update Address to the database
    PersonalDetails updateAddress(long employeeId, long addressId, Address address) throws InternalErrorException, IdMismatchException, EmployeeNotFoundException;

    // abstract method to update Personal Details to the database
    PersonalDetails updatePersonalDetails(PersonalDetails personalDetails) throws IdMismatchException, EmployeeNotFoundException, InternalErrorException;

    // method to delete an Employee's Personal Details
    PersonalDetails deleteDetailsById(long id) throws EmployeeNotFoundException, InternalErrorException;
}
