package com.example.mongoservice.aspect.projectsDb;
import lombok.extern.apachecommons.CommonsLog;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProjectsInterceptorAspect {
    @Before("execution(* deleteProjectsById(..))")
    public void beforeAdvice(){
        System.out.println("deleteProjectsById function is going in to be executed");
    }
    @After("execution(* deleteProjectsById(..))")
    public void afterAdvice() {
        System.out.println("deleteProjectsById function is executed");
    }
}