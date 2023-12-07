package com.example.mongoservice.service.learningsDb;

import com.example.mongoservice.exception.EmployeeFoundException;
import com.example.mongoservice.exception.EmployeeNotFoundException;
import com.example.mongoservice.model.learningsDb.Learnings;
import java.util.*;

public interface ILearningService {

    //Get : all learnings

    List<Learnings> getAllLearnings();
    //Get: get all learnings by ID
    Learnings getLearningsById(long empId) throws EmployeeNotFoundException;

    //Get : delete Learning by Id
    Learnings deleteLearningById(long empId) throws EmployeeNotFoundException;

    //Post: new learning

    Learnings addLearning(Learnings learnings) throws EmployeeFoundException;

    //Update: an already exisiting learning
    Learnings updateLearning(Learnings learnings) throws EmployeeNotFoundException;

}
