package com.example.mongoservice.service.personalDetailsDb;

import com.example.mongoservice.model.personalDetailsDb.Address;
import com.example.mongoservice.model.personalDetailsDb.PersonalDetails;
import com.example.mongoservice.exception.EmployeeFoundException;
import com.example.mongoservice.exception.EmployeeNotFoundException;
import com.example.mongoservice.exception.IdMismatchException;
import com.example.mongoservice.exception.InternalErrorException;
import com.example.mongoservice.repository.personalDetailsDb.IAddressRepository;
import com.example.mongoservice.repository.personalDetailsDb.IPersonalDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalDetailsServiceImpl implements IPersonalDetailsService{

    // Injecting personal details repository to the service
    @Autowired
    IPersonalDetailsRepository personalDetailsRepository;

    // Injecting address repository to the service
    @Autowired
    IAddressRepository addressRepo;

    // method implementation to GET all personal details from personal details collection
    @Override
    public List<PersonalDetails> getAllPersonalDetails() {
        return personalDetailsRepository.findAll();
    }

    // method implementation to GET personalDetails of an employee based on Id
    @Override
    public PersonalDetails getPersonalDetailsById(long id) throws EmployeeNotFoundException {
        Optional<PersonalDetails> optionalDetails = personalDetailsRepository.findById(id);
        if(optionalDetails.isPresent())
            return optionalDetails.get();
        // throw a custom exception when employee is present with the given "id"
        throw new EmployeeNotFoundException("Employee not found with id: "+id);
    }

    // method implementation to ADD PersonalDetails of an Employee
    @Override
    public PersonalDetails addPersonalDetails(PersonalDetails personalDetails) throws EmployeeFoundException, IdMismatchException {
        Optional<PersonalDetails> optionalDetails = personalDetailsRepository.findById(personalDetails.getId());
        if(optionalDetails.isEmpty()){
            if(personalDetails.getAddress().getEmpId() == personalDetails.getId()){
                // Saving the Address first
                Address addedAddress = addressRepo.save(personalDetails.getAddress());
                // Setting the saved Address in the Personal Details object
                personalDetails.setAddress(addedAddress);
                // Saving the Personal Details in the database
                return personalDetailsRepository.save(personalDetails);
            }
            throw new IdMismatchException("Id of the Employee in Personal Details and Address are different!!");
        }
        // Throwing EmployeeFoundException if user is trying to add personal details of an employee who is already present in the database
        throw new EmployeeFoundException("Employee with id "+ personalDetails.getId() +" already present in the database");
    }

    // method implementation to UPDATE the ADDRESS of an employee
    @Override
    public PersonalDetails updateAddress(long employeeId, long addressId, Address address) throws InternalErrorException, IdMismatchException, EmployeeNotFoundException {
        if(employeeId == addressId){
            if(addressId != address.getEmpId())
                throw new IdMismatchException("The address id given in the url is different from that of id of the address to be updated. Please give different ids!!!");
            if(addressRepo.findById(addressId).isPresent()){
                try{
                    Optional<PersonalDetails> optionalDetails = personalDetailsRepository.findById(addressId);
                    if(optionalDetails.isPresent()){
                        Address updatedAddress = addressRepo.save(address);
                        PersonalDetails existingDetails = optionalDetails.get();
                        existingDetails.setAddress(updatedAddress);
                        PersonalDetails updatedDetails = personalDetailsRepository.save(existingDetails);
                        return updatedDetails;
                    }
                }
                catch(Exception e){
                    throw new InternalErrorException("An error occurred while updating the address. Please try again with some other value!!!");
                }
            }
            throw new EmployeeNotFoundException("Employee not found with the given id: "+addressId);
        }
        throw new IdMismatchException("Id given for the Personal Details and Address collections are different!!! Please give same id for both and try again!!");
    }

    // method implementation to UPDATE PersonalDetails of an Employee
    @Override
    public PersonalDetails updatePersonalDetails(PersonalDetails personalDetails) throws IdMismatchException, EmployeeNotFoundException, InternalErrorException {
        if(personalDetails.getId() != personalDetails.getAddress().getEmpId()){
            throw new IdMismatchException("Id given for the Personal Details and Address collections are different!!! Please give same id for both and try again!!");
        }
        if(personalDetailsRepository.findById(personalDetails.getId()).isEmpty()){
            throw new EmployeeNotFoundException("Employee not found with the given id: "+personalDetails.getId());
        }
        try{
            PersonalDetails updatedDetails = personalDetailsRepository.save(personalDetails);
            addressRepo.save(personalDetails.getAddress());
            return updatedDetails;
        }
        catch(Exception e){
            throw new InternalErrorException("An error occurred while updating the address. Please try again with some other value!!!");
        }
    }

    // method implementation to DELETE personalDetails of an employee based on Id
    @Override
    public PersonalDetails deleteDetailsById(long id) throws EmployeeNotFoundException, InternalErrorException {
        Optional<PersonalDetails> optionalDetails = personalDetailsRepository.findById(id);
        // Throwing an exception if employee is not present with the given id
        if(!optionalDetails.isPresent()){
            throw new EmployeeNotFoundException("Employee not found with given ID: "+id);
        }
        else{
            try{
                personalDetailsRepository.deleteById(id);
                addressRepo.deleteById(id);
                return optionalDetails.get();
            }
            catch(Exception e){
                throw new InternalErrorException("Something went wrong. Please try again later!!");
            }
        }
    }

}
