package com.example.mongoservice.controller.transfersDb;

import com.example.mongoservice.exception.EmployeeFoundException;
import com.example.mongoservice.exception.EmployeeNotFoundException;
import com.example.mongoservice.model.transfersDb.Transfers;
import com.example.mongoservice.service.transfersDb.ITransfersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransfersController {
    @Autowired
    private ITransfersService transfersService;

    @GetMapping("/transfers/all")
    public ResponseEntity<List<Transfers>> getAllTransfers(){
        return new ResponseEntity<>(transfersService.getAllTransfers(), HttpStatus.OK);
    }

    @GetMapping("/transfers/getById")
    public ResponseEntity<Transfers> getTransfersById(@RequestParam("id") long empId) throws EmployeeNotFoundException {
        return new ResponseEntity<>(transfersService.getTransfersById(empId), HttpStatus.OK);
    }

    @DeleteMapping("/transfers/deleteById")
    public ResponseEntity<Transfers> deleteTransfersById(@RequestParam("id") long empId) throws EmployeeNotFoundException {
        return new ResponseEntity<>(transfersService.deleteTransfersById(empId), HttpStatus.OK);
    }

    @PostMapping("/transfers/add")
    public ResponseEntity<Transfers> addTransfers(@RequestBody Transfers transfers) throws EmployeeFoundException {
        return new ResponseEntity<>(transfersService.addTransfers(transfers), HttpStatus.OK);
    }

    @PutMapping("/transfers/update")
    public ResponseEntity<Transfers> updateTransfers(@RequestBody Transfers transfers) throws EmployeeNotFoundException {
        return new ResponseEntity<>(transfersService.updateTransfers(transfers), HttpStatus.OK);
    }
}
