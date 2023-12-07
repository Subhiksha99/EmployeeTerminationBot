package com.example.mongoservice.model.flagsDb;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "flags")
@Getter
@Setter
public class Flags {
    @Id
    private long employeeId;
    private String issuesDb="none";
    private String possessionsDb="none";
    private String projectsDb="none";
    private String leavesDb="none";
    private String educationDetailsDb="none";
    private String personalDetailsDb="none";
    private Date terminationDate;
}
