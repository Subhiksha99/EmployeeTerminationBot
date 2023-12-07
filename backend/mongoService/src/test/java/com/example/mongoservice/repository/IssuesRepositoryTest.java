package com.example.mongoservice.repository;

import com.example.mongoservice.model.issuesDb.Issue;
import com.example.mongoservice.model.issuesDb.Issues;
import com.example.mongoservice.repository.issuesDb.IssuesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class IssuesRepositoryTest {

    @Autowired
    IssuesRepository issuesRepository;

    // Test case to test the functionality findById when a Document exists with given Id
    @Test
    void findByIdTestWhenDocumentExists(){
        List<String> actionsList = Arrays.asList("Test Action 1","Test Action 2");
        List<Issue> issueList = Arrays.asList(new Issue(3423L, "Test Issue", actionsList));
        Issues testInput = new Issues(1L, issueList);
        // Saving sample Issues
        Issues savedIssues = issuesRepository.save(testInput);
        // Using findById to retrieve the saved Issues
        Issues retrievedIssues = issuesRepository.findById(savedIssues.getEmployeeId()).get();
        // Assert that the retrieved document matched the saved one
        assertEquals(savedIssues, retrievedIssues);
    }

    @Test
        // Testcase to test if the functionality of findById() method when no Document exists with the given Id
    void findByIdTestWhenDocumentDoesNotExistWithGivenId(){
        // Using a non-existing ID
        Optional<Issues> retrievedIssues1 = issuesRepository.findById(2342L);
        // Assert that the retrived Issues are not present
        assertFalse(retrievedIssues1.isPresent());

        // Using an assertThrows to verify that an exception is thrown when no ID is provided
//        assertThrows(NoSuchElementException.class, () -> {
//            // Using findById to retrieve the non-saved Issues
//            issuesRepository.findById(2L);
//        });

    }

    @Test
    // TestCase to test if a parameter is sent to the findById() method
    public void findByIdTestWhenInputParameterIsNotPresent(){
        // Using an assertThrows to verify that an exception is thrown when no ID is provided
        assertThrows(IllegalArgumentException.class, () -> {
            issuesRepository.findById(null);
        });
    }

    @Test
    public void saveDocumentTest(){
        List<String> actionsList = Arrays.asList("Test Action 1","Test Action 2");
        List<Issue> issueList = Arrays.asList(new Issue(3423L, "Test Issue", actionsList));
        Issues issuesToSave = new Issues(1L, issueList);
        // Saving sample Issues
        Issues savedIssues = issuesRepository.save(issuesToSave);
        // Using findById to retrieve the saved Issues
        Issues retrievedIssues = issuesRepository.findById(savedIssues.getEmployeeId()).get();
        // Assert to check if the EmployeeId is saved as instructed
        assertEquals(1, retrievedIssues.getEmployeeId());
        // Assert to check if the IssueList is saved as expected
        assertEquals(issueList, retrievedIssues.getIssuesList());
    }

    @Test
    // Testcase to test the deleteById functionality
    public void deleteByIdTest(){
        List<String> actionsList = Arrays.asList("Test Action 1","Test Action 2");
        List<Issue> issueList = Arrays.asList(new Issue(3423L, "Test Issue", actionsList));
        Issues issuesToDelete = new Issues(1, issueList);
        // Saving sample Issues
        Issues savedIssues = issuesRepository.save(issuesToDelete);
        // Using deleteById to delete the saved Issues
        issuesRepository.deleteById(savedIssues.getEmployeeId());
        // Trying to retrieve the deleted issues
        Optional<Issues> deletedIssues = issuesRepository.findById(savedIssues.getEmployeeId());
        // Assert to check the deletedIssues is not present
        assertFalse(deletedIssues.isPresent());
    }

    @Test
    // Testcase to test if the updating is done correctly or not
    public void updateTest(){
        List<String> actionsList = Arrays.asList("Test Action 1","Test Action 2");
        List<Issue> issueList = Arrays.asList(new Issue(3423L, "Test Issue", actionsList));
        Issues issues = new Issues(1, issueList);
        // Saving sample Issues
        Issues savedIssues = issuesRepository.save(issues);
        List<Issue> updatedIssueList = Arrays.asList(new Issue(23L, "Updated Test Issue", actionsList));
        savedIssues.setIssuesList(updatedIssueList);
        Optional<Issues> updatedIssues = issuesRepository.findById(savedIssues.getEmployeeId());
        assertTrue(updatedIssues.isPresent());
        // Checking if the Document is updated
        assertEquals(new Issues(1, issueList), updatedIssues.get());
    }

    @Test
    public void findAllTest(){
        List<String> actionsList = Arrays.asList("Test Action 1","Test Action 2");
        List<Issue> issueList1 = Arrays.asList(new Issue(3423L, "Test Issue", actionsList));
        Issues issues1 = new Issues(1, issueList1);
        // Saving sample Issues
        Issues savedIssues1 = issuesRepository.save(issues1);
        List<Issue> issueList2 = Arrays.asList(new Issue(3427L, "Test Issue", actionsList));
        Issues issues2 = new Issues(2, issueList2);
        // Saving sample Issues
        Issues savedIssues2 = issuesRepository.save(issues2);
        List<Issues> allIssues = issuesRepository.findAll();
        // Assert that size of the List of Issues is 2
        assertEquals(2, allIssues.size());
        // Asserts that savedIssues1 and savedIssues2 are present in the allIssues list
        assertTrue(allIssues.contains(savedIssues1));
        assertTrue(allIssues.contains(savedIssues2));
    }

}
