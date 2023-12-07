package com.example.mongoservice.aspect.transfersDb;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TransferInterceptorAspect {
    @Before("execution(* addTransfers(..))")
    public void beforeGetAdvice(){
        System.out.println("addTransfers function is going to be executed");
    }
    @After("execution(* addTransfers(..))")
    public void afterGetAdvice(){
        System.out.println("addTransfers function is executed");
    }
    @Before("execution(* updateTransfers(..))")
    public void beforePostAdvice(){
        System.out.println("updateTransfers function is going to be executed");
    }
    @After("execution(* updateTransfers(..))")
    public void afterPostAdvice(){
        System.out.println("updateTransfers function is executed");
    }
}
