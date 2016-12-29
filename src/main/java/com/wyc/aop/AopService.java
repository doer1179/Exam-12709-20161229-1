package com.wyc.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopService {
    @Pointcut("execution(* com.wyc.service.*.Insert*(..))")
    public void run(){

    }
    @Before("run()")
    public void beforeAdvice(){
    	System.out.println("Before Insert Film Data");
    }
    @After("run()")
    public void afterAdvice(){
    	System.out.println("After Insert Film Data");
    }
    

}
