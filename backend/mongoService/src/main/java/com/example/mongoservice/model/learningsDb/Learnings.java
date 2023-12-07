package com.example.mongoservice.model.learningsDb;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.util.List;
@Getter
@Setter
@Document(collection = "Learnings")
public class Learnings {
    @Id
    private long employeeId;
    private List<Learning> LearningList;
}
