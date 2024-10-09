package com.in28minutes.learn_spring_aop.aopexample.aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {

    private Logger log = LoggerFactory.getLogger(getClass());
    //Point cut - when?
    @Before("execution(* com.in28minutes.learn_spring_aop.aopexample.*.*.*(..))")
    public void logMethodCall(JoinPoint joinPoint){
        //Logic - What?
        log.info("Before Aspect {} called with rguments {}",joinPoint, joinPoint.getArgs());
    }
}
