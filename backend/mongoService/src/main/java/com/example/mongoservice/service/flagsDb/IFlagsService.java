package com.example.mongoservice.service.flagsDb;

import com.example.mongoservice.dto.flagsDb.TerminationMail;
import com.example.mongoservice.exception.EmployeeFoundException;
import com.example.mongoservice.exception.EmployeeNotFoundException;
import com.example.mongoservice.model.flagsDb.Flags;

import java.util.List;

public interface IFlagsService {
    // Get: all Flags
    List<Flags> getAllFlags();
    // Get: flags by id
    Flags getFlagsById(long empId) throws EmployeeNotFoundException;
    // Delete: flags by id
    Flags deleteFlagsById(long empId) throws EmployeeNotFoundException;
    // Post: new flags
    Flags addFlags(Flags flags) throws EmployeeFoundException;
    // Update: an already existing flags
    Flags updateFlags(Flags flags) throws EmployeeNotFoundException;

    String sendMail(TerminationMail mailcontent);

    String sendMailToCancelResign(TerminationMail mailcontent);
}
