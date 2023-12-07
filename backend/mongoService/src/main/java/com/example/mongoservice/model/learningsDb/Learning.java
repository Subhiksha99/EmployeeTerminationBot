package com.example.mongoservice.model.learningsDb;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document
@Getter
@Setter

public class Learning {
    @Id
    private int learningId;
    private long courseID;
    private Date startingDate;
    private int score;
}
