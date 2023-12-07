package com.example.mongoservice.service.learningsDb;

import com.example.mongoservice.exception.EmployeeFoundException;
import com.example.mongoservice.exception.EmployeeNotFoundException;
import com.example.mongoservice.model.learningsDb.Learnings;
import com.example.mongoservice.repository.learningsDb.ILearningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LearningServiceImplementation implements ILearningService{

    @Autowired
    private ILearningRepository learningsRepo;
    @Override
    public List<Learnings> getAllLearnings() {
        return learningsRepo.findAll();
    }

    @Override
    public Learnings getLearningsById(long empId) throws EmployeeNotFoundException {
        Optional<Learnings> tempLearning =  learningsRepo.findById(empId);
        if(tempLearning.isEmpty()){
            throw new EmployeeNotFoundException("Employee with the Given ID"+empId+" does not exist");
        }
        return tempLearning.get();
    }

    @Override
    public Learnings deleteLearningById(long empId) throws EmployeeNotFoundException {
        Optional<Learnings> tempLearning =  learningsRepo.findById(empId);
        if(tempLearning.isEmpty()){
            throw new EmployeeNotFoundException("Employee with the Given ID"+empId+" does not exist");
        }
        learningsRepo.deleteById(empId);
        return tempLearning.get();
    }

    @Override
    public Learnings addLearning(Learnings learnings) throws EmployeeFoundException {
        long empId = learnings.getEmployeeId();
        Optional<Learnings> tempLearning =  learningsRepo.findById(empId);
        if(tempLearning.isPresent()){
            throw new EmployeeFoundException("Employee with the Given ID"+empId+" already exist");
        }
        learningsRepo.save(learnings);
        return learningsRepo.save(learnings);
    }

    @Override
    public Learnings updateLearning(Learnings learnings) throws EmployeeNotFoundException {
        long empId = learnings.getEmployeeId();
        Optional<Learnings> tempLearning =  learningsRepo.findById(learnings.getEmployeeId());
        if(tempLearning.isEmpty()){
            throw new EmployeeNotFoundException("Employee with the Given ID"+empId+" does not exist");
        }
        learningsRepo.save(learnings);
        return tempLearning.get();
    }
}
