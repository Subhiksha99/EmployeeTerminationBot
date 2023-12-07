package com.example.exception;

public class InvalidCredentialException extends Exception{
    public InvalidCredentialException(String msg)
    {
        super(msg);
    }
}
