package com.example.mongoservice.exception;

public class LeaveNotFoundException extends Exception{
    public LeaveNotFoundException(String message){
        super(message);
    }
}
