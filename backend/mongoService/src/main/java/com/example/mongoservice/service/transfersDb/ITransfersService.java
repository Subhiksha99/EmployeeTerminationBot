package com.example.mongoservice.service.transfersDb;

import com.example.mongoservice.exception.EmployeeFoundException;
import com.example.mongoservice.exception.EmployeeNotFoundException;
import com.example.mongoservice.model.transfersDb.Transfers;

import java.util.List;

public interface ITransfersService {
    // Get: all transfers
    List<Transfers> getAllTransfers();
    // Get: transfers by id
    Transfers getTransfersById(long empId) throws EmployeeNotFoundException;
    // Delete: transfers by id
    Transfers deleteTransfersById(long empId) throws EmployeeNotFoundException;
    // Post: new transfers
    Transfers addTransfers(Transfers transfers) throws EmployeeFoundException;
    // Update: an already existing transfers
    Transfers updateTransfers(Transfers transfers) throws EmployeeNotFoundException;
}
