package com.example.mongoservice.model.possessionsDb;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "possession")
@Getter
@Setter
public class Possession {
    @Id
    private int possessionId;
    private String type;
    private String purpose;
    private Date offeringDate;
    private Date returnedDate;
}
