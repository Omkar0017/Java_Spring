package com.in28minutes.learn_spring_aop.aopexample.aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {

    private Logger log = LoggerFactory.getLogger(getClass());
    //Point cut - when?
    @Before("com.in28minutes.learn_spring_aop.aopexample.CommonPointcutConfig.businessAndDataConfig()")
    public void logMethodBeforeCall(JoinPoint joinPoint){
        //Logic - What?
        log.info("Before Aspect {} called with rguments {}",joinPoint, joinPoint.getArgs());
    }

    @After("com.in28minutes.learn_spring_aop.aopexample.CommonPointcutConfig.businessAndDataConfig()")
    public void logMethodAfterCall(JoinPoint joinPoint){
        //Logic - What?
        log.info("After Aspect {} called",joinPoint);
    }

    @AfterThrowing(
            pointcut = "com.in28minutes.learn_spring_aop.aopexample.CommonPointcutConfig.dataConfig())",
            throwing = "exception")
    public void logMethodAfterException(JoinPoint joinPoint,Exception exception){
        log.info("After throwing Aspect {} has thrown an exception {}",joinPoint,exception.toString());
    }

    @AfterReturning(
            pointcut = "com.in28minutes.learn_spring_aop.aopexample.CommonPointcutConfig.businessConfig())",
            returning = "result")
    public void logMethodAfterExecution(JoinPoint joinPoint,Object result){
        log.info("After execution Aspect {} has returned {}",joinPoint,result);
    }
}
