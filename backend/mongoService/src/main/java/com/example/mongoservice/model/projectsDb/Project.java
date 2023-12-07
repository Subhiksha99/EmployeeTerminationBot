package com.example.mongoservice.model.projectsDb;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import java.util.List;

@Document
@Getter
@Setter
public class Project {
    @Id
    private int projectId;
    private String projectName;
    private Date startingDate;
    private String projectDescription;
    private String projectLead;
    private List<String> contributions;
}
