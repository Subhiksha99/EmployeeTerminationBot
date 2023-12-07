package com.example.mongoservice.model.issuesDb;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

// lombok annotations to include the Getters and Setters for the ErrorResponse class
@Getter
@Setter
// Custom
public class ErrorResponse {
    // message to be displayed when an error occurs (in our code)
    private String message;
    // to store the timestamp
    private LocalDateTime timeStamp;
    // this variable is used to store HttpStatus (in our code)
    private int status;

}

