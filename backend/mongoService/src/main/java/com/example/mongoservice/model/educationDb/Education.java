package com.example.mongoservice.model.educationDb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Education {
    @Id
    private long employeeId;
    private String universityName;
    private String specialization;
    private LocalDate startingDate;
    private LocalDate completionDate;
    private List<String> skills;
    private List<String> languagesKnown;
    private double cgpa;
}
