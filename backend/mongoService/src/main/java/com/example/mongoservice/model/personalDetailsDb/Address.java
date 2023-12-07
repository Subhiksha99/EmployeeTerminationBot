package com.example.mongoservice.model.personalDetailsDb;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Address {
    @Id
    private long empId;
    private String houseNo;
    private String state;
    private String country;
    private int pinCode;

}
