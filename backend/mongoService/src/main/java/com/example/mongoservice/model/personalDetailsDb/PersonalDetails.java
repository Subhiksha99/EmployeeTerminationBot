package com.example.mongoservice.model.personalDetailsDb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonalDetails {
    @Id
    private long id;
    private String name;
    private String email;
    private String phoneNo;
    @DBRef
    private Address address;
    private String gender;
    private LocalDate dob;
    private int age;

}
