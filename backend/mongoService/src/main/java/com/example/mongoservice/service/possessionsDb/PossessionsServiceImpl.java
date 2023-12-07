package com.example.mongoservice.service.possessionsDb;

import com.example.mongoservice.exception.EmployeeFoundException;
import com.example.mongoservice.exception.EmployeeNotFoundException;
import com.example.mongoservice.model.possessionsDb.Possessions;
import com.example.mongoservice.repository.possessionsDb.IPossessionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PossessionsServiceImpl implements IPossessionsService{
    @Autowired
    private IPossessionsRepository possessionsRepo;
    @Override
    public List<Possessions> getAllPossessions() {
        return possessionsRepo.findAll();
    }

    @Override
    public Possessions getPossessionById(long empId) throws EmployeeNotFoundException {
        Optional<Possessions> tempPossession=possessionsRepo.findById(empId);
        if(tempPossession.isEmpty()){
            throw new EmployeeNotFoundException("Employee with the given id:"+empId+" does not exist");
        }
        return tempPossession.get();
    }

    @Override
    public Possessions deletePossessionById(long empId) throws EmployeeNotFoundException {
        Optional<Possessions> tempPossession=possessionsRepo.findById(empId);
        if(tempPossession.isEmpty()){
            throw new EmployeeNotFoundException("Employee with the given id:"+empId+" does not exist");
        }
        possessionsRepo.deleteById(empId);
        return tempPossession.get();
    }

    @Override
    public Possessions addPossessions(Possessions possessions) throws EmployeeFoundException {
        long empId=possessions.getEmployeeId();
        Optional<Possessions> tempPossession=possessionsRepo.findById(empId);
        if(tempPossession.isPresent()) {
            throw new EmployeeFoundException("Employee with the given id:" + empId + " already exists");
        }
        return possessionsRepo.save(possessions);
    }

    @Override
    public Possessions updatePossessions(Possessions possessions) throws EmployeeNotFoundException {
        long empId=possessions.getEmployeeId();
        Optional<Possessions> tempPossession=possessionsRepo.findById(empId);
        if(tempPossession.isEmpty()){
            throw new EmployeeNotFoundException("Employee with the given id:"+empId+" does not exist");
        }
        return possessionsRepo.save(possessions);
    }
}
