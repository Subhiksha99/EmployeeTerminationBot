package com.example.mongoservice.aspect.flagsDb;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FlaggingInterceptorAspect {
    @Before("execution(* getFlagsById(..))")
    public void beforeGetAdvice(){
        System.out.println("getFlagsById function is going to be executed");
    }
    @After("execution(* getFlagsById(..))")
    public void afterGetAdvice(){
        System.out.println("getFlagsById function is executed");
    }
    @Before("execution(* addFlags(..))")
    public void beforePostAdvice(){
        System.out.println("addFlags function is going to be executed");
    }
    @After("execution(* addFlags(..))")
    public void afterPostAdvice(){
        System.out.println("addFlags function is executed");
    }
}
