package com.example.exception;

import com.example.entity.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(UserNotFoundException exception) {
        ErrorResponse error = new ErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value()); // 404 not found
        error.setMessage(exception.getMessage()); //get message from exception
        error.setTimestamp(LocalDateTime.now()); // system time
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);  //404 Not found
    }

    @ExceptionHandler(InvalidCredentialException.class)
    public ResponseEntity<ErrorResponse> handleException(InvalidCredentialException exception) {
        ErrorResponse error = new ErrorResponse();
        error.setStatus(HttpStatus.NOT_ACCEPTABLE.value()); //
        error.setMessage(exception.getMessage()); //get message from exception
        error.setTimestamp(LocalDateTime.now()); // system time
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);  //404 Not found
    }
}
