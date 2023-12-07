package com.example.mongoservice.exception;

// This exception will be thrown when we get an Internal Server Error in the application
public class InternalErrorException extends Exception{
    public InternalErrorException(String msg){
        super(msg);
    }
}
