package com.example.mongoservice.exception;
import com.example.mongoservice.model.learningsDb.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class LearningsExceptionHandler {
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(EmployeeNotFoundException exception){
        ErrorResponse error = new ErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exception.getMessage());
        error.setTimeStamp(LocalDateTime.now());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(EmployeeFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(EmployeeFoundException exception){
        ErrorResponse error = new ErrorResponse();
        error.setStatus(HttpStatus.FOUND.value());
        error.setMessage(exception.getMessage());
        error.setTimeStamp(LocalDateTime.now());
        return new ResponseEntity<>(error,HttpStatus.FOUND);
    }
}
