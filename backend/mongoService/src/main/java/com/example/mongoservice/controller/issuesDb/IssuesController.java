package com.example.mongoservice.controller.issuesDb;

import com.example.mongoservice.exception.*;
import com.example.mongoservice.model.issuesDb.Issue;
import com.example.mongoservice.model.issuesDb.Issues;
import com.example.mongoservice.service.issuesDb.IIssuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("issues/")
public class IssuesController {

    // Injecting the IssuesService to this controller
    @Autowired
    private IIssuesService issuesService;

    // Creating an API to fetch all Issues from the database
    @GetMapping("/all")
    public ResponseEntity<List<Issues>> getAllIssues(){
        List<Issues> issuesList = issuesService.getAllIssues();
        return new ResponseEntity<>(issuesList, HttpStatus.OK);
    }

    // Creating an API to fetch all Issues of an employee based on employeeId
    @GetMapping("/{employeeId}")
    public ResponseEntity<Issues> getIssuesById(@PathVariable long employeeId) throws EmployeeNotFoundException {
        // return a ResponseEntity with response and status code
        return new ResponseEntity<>(issuesService.getIssuesById(employeeId), HttpStatus.OK);
    }

    // Creating an API to fetch an Issue based on complaintId
    @GetMapping("/{employeeId}/issue/{complaintId}")
    public ResponseEntity<Issue> getIssueByComplaintId(@PathVariable long employeeId, @PathVariable long complaintId) throws ComplaintNotFoundException, EmployeeNotFoundException {
        // returning a ResponseEntity with response and status code
        return new ResponseEntity<>(issuesService.getIssueById(employeeId, complaintId), HttpStatus.OK);
    }

    // Creating an API to add an employee's Issue in the database
    @PostMapping("/add")
    public ResponseEntity<Issues> addIssues(@RequestBody Issues issues) throws EmployeeFoundException, EmployeeNotFoundException {
        // calling service method to add issue of an employee to the database
        Issues addedIssues = issuesService.addIssues(issues);
        return new ResponseEntity<>(addedIssues, HttpStatus.ACCEPTED);
    }

    // Creating an API to DELETE a complaint based on the ComplaintId
    @DeleteMapping("deleteById")
    public ResponseEntity<Issues> deleteIssuesById(@RequestParam("id") long complaintId) throws ComplaintNotFoundException, InternalErrorException{
        return new ResponseEntity<>(issuesService.deleteIssuesById(complaintId), HttpStatus.OK);
    }

    // Creating an API to UPDATE a complaint based on ComplaintId
    @PutMapping("update")
    public ResponseEntity<Issues> updateIssuesById(@RequestBody Issues issues) throws EmployeeNotFoundException{
        return new ResponseEntity<>(issuesService.updateIssuesById(issues), HttpStatus.OK);
    }

}
