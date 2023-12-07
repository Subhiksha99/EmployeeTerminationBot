package com.example.mongoservice.model.employeeListDb;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Employee {
    @Id
    private int employeeId;
    private String mail;
    private String name;
    private String team;
    private String role;
    private String status;

}
