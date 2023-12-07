package com.example.mongoservice.model.issuesDb;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
@AllArgsConstructor
public class Issues {
    @Id
    private long employeeId;
    private List<Issue> issuesList;

}
