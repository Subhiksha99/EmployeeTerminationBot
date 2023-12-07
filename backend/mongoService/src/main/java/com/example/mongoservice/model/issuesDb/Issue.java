package com.example.mongoservice.model.issuesDb;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@AllArgsConstructor
public class Issue {
    @Id
    private long complaintId;
    private String description;
    private List<String> actions;
}
