package com.example.mongoservice.aspect.leavesDb;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LeavesInterceptorAspect {
    @Before("execution(* deleteLeavesById(..))")
    public void beforeAdvice(){
        System.out.println("Executing the getAllCustomers function");
    }
    @After("execution(* deleteLeavesById(..))")
    public void afterAdvice(){
        System.out.println("Executed the getAllCustomers function");
    }

}
