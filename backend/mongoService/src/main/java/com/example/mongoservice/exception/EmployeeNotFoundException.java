package com.example.mongoservice.exception;

// Exception class when user is trying to fetch an employee who is not present in the database
public class EmployeeNotFoundException extends Exception{
    public EmployeeNotFoundException(String msg){
        super(msg);
    }
}
