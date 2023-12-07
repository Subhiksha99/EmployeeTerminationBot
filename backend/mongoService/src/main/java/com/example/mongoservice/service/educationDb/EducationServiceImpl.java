package com.example.mongoservice.service.educationDb;

import com.example.mongoservice.exception.EmployeeFoundException;
import com.example.mongoservice.exception.EmployeeNotFoundException;
import com.example.mongoservice.exception.InternalErrorException;
import com.example.mongoservice.model.educationDb.Education;
import com.example.mongoservice.repository.educationDb.IEducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationServiceImpl implements IEducationService{
    // Injecting the repository to service
    @Autowired
    IEducationRepository educationRepo;

    // method implementation of getAllEducationDetails method of the Service Interface
    @Override
    public List<Education> getAllEducationDetails(){
        return educationRepo.findAll();
    }

    @Override
    public Education getEducationDetailsById(long empId) throws EmployeeNotFoundException {
        Optional<Education> optionalEducation = educationRepo.findById(empId);
        if(optionalEducation.isPresent()){
            return optionalEducation.get();
        }
        throw new EmployeeNotFoundException("Employee Not Found with ID: "+empId);
    }

    // method implementation to add education details of an employee to the database
    @Override
    public Education addEducationDetails(Education education) throws EmployeeFoundException {
        Optional<Education> optionalEducation = educationRepo.findById(education.getEmployeeId());
        if(optionalEducation.isPresent()){
            throw new EmployeeFoundException("Employee already exists with ID: "+education.getEmployeeId());
        }
        return educationRepo.save(education);
    }

    @Override
    public Education updateEducationDetails(Education education) throws EmployeeNotFoundException, InternalErrorException {
        Optional<Education> optionalEducation = educationRepo.findById(education.getEmployeeId());
        if(optionalEducation.isPresent()){
            try{
                Education updatedDetails = educationRepo.save(education);
                return updatedDetails;
            }
            catch(Exception e){
                throw new InternalErrorException("An error occurred while updating the address. Please try again with some other value!!!");
            }
        }
        throw new EmployeeNotFoundException("Employee Not Found with ID: "+education.getEmployeeId());
    }

    // implementation method to delete education details of an employee from the database
    @Override
    public Education deleteEducationDetails(long id) throws EmployeeNotFoundException, InternalErrorException {
        Optional<Education> optionalEducation = educationRepo.findById(id);
        if(optionalEducation.isEmpty()){
            throw new EmployeeNotFoundException("Employee Not Found with ID: "+id);
        }
        else{
            try{
                educationRepo.deleteById(id);
                return optionalEducation.get();
            }
            catch(Exception e){
                throw new InternalErrorException("Something went wrong. Please try again later!!");
            }
        }
    }
}
