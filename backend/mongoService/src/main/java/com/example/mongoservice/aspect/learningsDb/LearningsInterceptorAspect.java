package com.example.mongoservice.aspect.learningsDb;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LearningsInterceptorAspect {
    @Before("execution(* deleteLearningsById(..))")
    public void beforeAdvice(){
        System.out.println("deleteLearningsById function is going to be executed");
    }
    @After("execution(* deleteLearningsById(..))")
    public void afterAdvice(){
        System.out.println("deleteLearningsById function is executed");
    }
}
