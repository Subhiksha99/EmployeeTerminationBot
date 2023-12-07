package com.example.mongoservice.exception;

// This exception occur when the user is giving different ids for the same entity (Employee)
public class IdMismatchException extends Exception{
    public IdMismatchException(String msg){
        super(msg);
    }
}
