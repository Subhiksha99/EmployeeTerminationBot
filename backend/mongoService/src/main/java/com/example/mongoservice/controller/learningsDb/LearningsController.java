package com.example.mongoservice.controller.learningsDb;

import com.example.mongoservice.exception.EmployeeFoundException;
import com.example.mongoservice.exception.EmployeeNotFoundException;
import com.example.mongoservice.model.learningsDb.Learnings;
import com.example.mongoservice.service.learningsDb.ILearningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LearningsController {
    @Autowired
    private ILearningService learningsService;

    @GetMapping("/learnings/all")
    public ResponseEntity<List<Learnings>> getAllLearnings(){
        return new ResponseEntity<>(learningsService.getAllLearnings(), HttpStatus.OK);
    }


    @GetMapping("/learnings/getById")
    public ResponseEntity<Learnings> getLearningsById(@RequestParam long empId) throws EmployeeNotFoundException {
            return new ResponseEntity<>(learningsService.getLearningsById(empId), HttpStatus.OK);
    }

    @DeleteMapping("/learnings/deleteById")
    public ResponseEntity<Learnings> deleteLearningsById(@RequestParam("id") long empId) throws EmployeeNotFoundException {
        return new ResponseEntity<>(learningsService.deleteLearningById(empId), HttpStatus.OK);
    }


    @PostMapping("/learnings/add")
    public ResponseEntity<Learnings> addLearning(@RequestBody Learnings learnings) throws EmployeeFoundException {
        return new ResponseEntity<>(learningsService.addLearning(learnings), HttpStatus.OK);
    }

    @PutMapping("/learnings/update")
    public ResponseEntity<Learnings> updateLearning(@RequestBody Learnings learnings) throws EmployeeNotFoundException {
        return new ResponseEntity<>(learningsService.updateLearning(learnings), HttpStatus.OK);
    }
}
