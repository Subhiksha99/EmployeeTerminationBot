package com.example.mongoservice.model.possessionsDb;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "possessions")
@Getter
@Setter
public class Possessions {
    @Id
    private long employeeId;
    private List<Possession> possessionsList;
}
