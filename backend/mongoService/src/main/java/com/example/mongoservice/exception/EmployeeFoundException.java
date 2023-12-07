package com.example.mongoservice.exception;

// Exception class when user is trying to create an employee who is already present in the database
public class EmployeeFoundException extends Exception{
    public EmployeeFoundException(String msg){
        super(msg);
    }
}
