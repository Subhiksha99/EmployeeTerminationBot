package com.example.mongoservice.aspect.possessionsDb;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PossessionsInterceptorAspect {
    @Before("execution(* deletePossessionsById(..))")
    public void beforeAdvice(){
        System.out.println("deletePossessionsById functions is going to be executed");
    }
    @After("execution(* deletePossessionsById(..))")
    public void afterAdvice(){
        System.out.println("deletePossessionsById function is executed");
    }
}
