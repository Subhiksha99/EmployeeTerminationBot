package com.example.mongoservice.service.issuesDb;

import com.example.mongoservice.exception.ComplaintNotFoundException;
import com.example.mongoservice.exception.EmployeeFoundException;
import com.example.mongoservice.exception.EmployeeNotFoundException;
import com.example.mongoservice.exception.InternalErrorException;
import com.example.mongoservice.model.issuesDb.Issue;
import com.example.mongoservice.model.issuesDb.Issues;
import com.example.mongoservice.repository.issuesDb.IssuesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IssuesServiceImpl implements IIssuesService {

    // Injecting IssuesRepository to the service
    @Autowired
    private IssuesRepository issuesRepo;

    // method implementation to GET all issues from Issues collection
    @Override
    public List<Issues> getAllIssues() {
        // Fetching IssuesList from the database
        List<Issues> issueList = issuesRepo.findAll();
        // returning the list as response
        return issueList;
    }

    // method implementation to GET Issues based on EmployeeId
    @Override
    public Issues getIssuesById(long employeeId) throws EmployeeNotFoundException {
        Optional<Issues> optionalIssues = issuesRepo.findById(employeeId);
        if(optionalIssues.isPresent()){
            // returning the Issues object as response
            return optionalIssues.get();
        }
        throw new EmployeeNotFoundException("Employee Not Found with ID: "+employeeId);
    }

    @Override
    public Issue getIssueById(long employeeId, long complaintId) throws ComplaintNotFoundException, EmployeeNotFoundException {
        Optional<Issues> optionalIssue = issuesRepo.findById(employeeId);
        if(optionalIssue.isPresent()){
            // Fetching the list of issues under the employee's id
            List<Issue> issuesList = optionalIssue.get().getIssuesList();
            for(int index=0; index<issuesList.size(); index++){
                if(issuesList.get(index).getComplaintId() == complaintId){
                    return issuesList.get(index);
                }
            }
            throw new ComplaintNotFoundException("Complaint Not Found with ID: " + complaintId);
        }
        throw new EmployeeNotFoundException("Employee Not Found with ID: " + employeeId);
    }

    // method implementation to ADD issues to the database
    @Override
    public Issues addIssues(Issues issues) throws EmployeeFoundException {
        Optional<Issues> optionalIssue = issuesRepo.findById(issues.getEmployeeId());
        if(optionalIssue.isEmpty()){
            return issuesRepo.save(issues);
        }
        throw new EmployeeFoundException("Issue already found with ID: "+issues.getEmployeeId());
    }

    // method implementation to delete an Issue from the database
    @Override
    public Issues deleteIssuesById(long employeeId) throws InternalErrorException, ComplaintNotFoundException {
        Optional<Issues> optionalIssues = issuesRepo.findById(employeeId);
        if(optionalIssues.isPresent()){
            try{
                issuesRepo.deleteById(employeeId);
                return optionalIssues.get();
            }
            catch(Exception e){
                throw new InternalErrorException("Something went wrong. Please try again later!!");
            }
        }
        throw new ComplaintNotFoundException("Complaint Not Found with ID: "+employeeId);
    }

    // method implementation to update an Issue based on the Employee id
    @Override
    public Issues updateIssuesById(Issues issues) throws EmployeeNotFoundException{
        Optional<Issues> optionalIssue = issuesRepo.findById(issues.getEmployeeId());
        if(optionalIssue.isPresent()){
            return issuesRepo.save(issues);
        }
        throw new EmployeeNotFoundException("Employee Not Found with the given ID: " + issues.getEmployeeId());
    }

}
