package com.example.mongoservice.exception;

import com.example.mongoservice.model.issuesDb.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.LocalDateTime;

// Annotation to handle exceptions across the whole application globally
@ControllerAdvice
public class ExceptionHandler {

    // Defining exception handler for the EmployeeNotFoundException exception
    @org.springframework.web.bind.annotation.ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(EmployeeNotFoundException exception){
        // Creating an ErrorResponse object to create an error to be displayed when an EmployeeNotFoundException occurs
        ErrorResponse error = new ErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exception.getMessage());
        error.setTimeStamp(LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // Defining exception handler for the EmployeeNotFoundException exception
    @org.springframework.web.bind.annotation.ExceptionHandler(EmployeeFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(EmployeeFoundException exception){
        //  Creating an ErrorResponse object to create an error to be displayed when EmployeeFoundException occurs
        ErrorResponse error = new ErrorResponse();
        error.setStatus(HttpStatus.FOUND.value());
        error.setMessage(exception.getMessage());
        error.setTimeStamp(LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.FOUND);
    }

    // Defining exception handler for the IdMismatchException exception
    @org.springframework.web.bind.annotation.ExceptionHandler(IdMismatchException.class)
    public ResponseEntity<ErrorResponse> handleException(IdMismatchException exception){
        //  Creating an ErrorResponse object to create an error to be displayed when an IdMismatchException occurs
        ErrorResponse error = new ErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exception.getMessage());
        error.setTimeStamp(LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    // Defining exception handler for the InternalErrorException exception
    @org.springframework.web.bind.annotation.ExceptionHandler(InternalErrorException.class)
    public ResponseEntity<ErrorResponse> handleException(InternalErrorException exception){
        //  Creating an ErrorResponse object to create an error to be displayed when an InternalErrorException occurs
        ErrorResponse error = new ErrorResponse();
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setMessage(exception.getMessage());
        error.setTimeStamp(LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Defining exception handler for the ComplaintNotFoundException exception
    @org.springframework.web.bind.annotation.ExceptionHandler(ComplaintNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(ComplaintNotFoundException exception){
        //  Creating an ErrorResponse object to create an error to be displayed when an ComplaintNotFoundException occurs
        ErrorResponse error = new ErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exception.getMessage());
        error.setTimeStamp(LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // Defining exception handler for the ComplaintFoundException exception
    @org.springframework.web.bind.annotation.ExceptionHandler(ComplaintFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(ComplaintFoundException exception){
        //  Creating an ErrorResponse object to create an error to be displayed when an ComplaintFoundException occurs
        ErrorResponse error = new ErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exception.getMessage());
        error.setTimeStamp(LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
