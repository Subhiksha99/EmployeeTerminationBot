package com.example.mongoservice.controller.possessionsDb;

import com.example.mongoservice.exception.EmployeeFoundException;
import com.example.mongoservice.exception.EmployeeNotFoundException;
import com.example.mongoservice.model.possessionsDb.Possessions;
import com.example.mongoservice.service.possessionsDb.IPossessionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PossessionsController {
    @Autowired
    private IPossessionsService possessionsService;

    @GetMapping("/possessions/all")
    public ResponseEntity<List<Possessions>> getAllPossessions(){
        return new ResponseEntity<>(possessionsService.getAllPossessions(), HttpStatus.OK);
    }

    @GetMapping("/possessions/getById")
    public ResponseEntity<Possessions> getPossessionsById(@RequestParam("id") long empId) throws EmployeeNotFoundException {
        return new ResponseEntity<>(possessionsService.getPossessionById(empId), HttpStatus.OK);
    }

    @DeleteMapping("/possessions/deleteById")
    public ResponseEntity<Possessions> deletePossessionsById(@RequestParam("id") long empId) throws EmployeeNotFoundException {
        return new ResponseEntity<>(possessionsService.deletePossessionById(empId), HttpStatus.OK);
    }

    @PostMapping("/possessions/add")
    public ResponseEntity<Possessions> addPossessions(@RequestBody Possessions possessions) throws EmployeeFoundException{
        return new ResponseEntity<>(possessionsService.addPossessions(possessions), HttpStatus.OK);
    }

    @PutMapping("/possessions/update")
    public ResponseEntity<Possessions> updatePossessions(@RequestBody Possessions possessions) throws EmployeeNotFoundException {
        return new ResponseEntity<>(possessionsService.updatePossessions(possessions), HttpStatus.OK);
    }

}
