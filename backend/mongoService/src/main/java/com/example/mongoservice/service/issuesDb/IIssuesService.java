package com.example.mongoservice.service.issuesDb;

import com.example.mongoservice.dto.IssueDto;
import com.example.mongoservice.exception.*;
import com.example.mongoservice.model.issuesDb.Issue;
import com.example.mongoservice.model.issuesDb.Issues;

import java.util.List;

public interface IIssuesService {

    // abstract method to GET all issues from Issues collection
    List<Issues> getAllIssues();

    // abstract method to GET an issue from the database based on employeeId
    Issues getIssuesById(long employeeId) throws EmployeeNotFoundException;

    Issue getIssueById(long employeeId, long complaintId) throws ComplaintNotFoundException, EmployeeNotFoundException;

    // method to ADD an issue to the database
    Issues addIssues(Issues issues) throws EmployeeFoundException;

    // abstract method to DELETE an issue based on the complaint id
    Issues deleteIssuesById(long complaintId) throws InternalErrorException, ComplaintNotFoundException;

    // method to UPDATE an issue based on complaint id
    Issues updateIssuesById(Issues issues) throws EmployeeNotFoundException;


}
