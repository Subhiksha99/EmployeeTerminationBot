package com.example.mongoservice.service.possessionsDb;

import com.example.mongoservice.exception.EmployeeFoundException;
import com.example.mongoservice.exception.EmployeeNotFoundException;
import com.example.mongoservice.model.possessionsDb.Possessions;

import java.util.List;
public interface IPossessionsService {
    // Get: all possessions
    List<Possessions> getAllPossessions();
    // Get: possession by id
    Possessions getPossessionById(long empId) throws EmployeeNotFoundException;
    // Delete: possession by id
    Possessions deletePossessionById(long empId) throws EmployeeNotFoundException;
    // Post: new possession
    Possessions addPossessions(Possessions possessions) throws EmployeeFoundException;
    // Update: an already existing possession
    Possessions updatePossessions(Possessions possessions) throws EmployeeNotFoundException;

}
