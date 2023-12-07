package com.example.mongoservice.model.projectsDb;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Getter
@Setter
@Document(collection = "Projects")
public class Projects {
    @Id
    private long employeeId;
    private List<Project> ProjectList;
}