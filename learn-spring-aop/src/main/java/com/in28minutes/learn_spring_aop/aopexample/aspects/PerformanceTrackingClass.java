package com.in28minutes.learn_spring_aop.aopexample.aspects;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class PerformanceTrackingClass {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Around(
            value = "execution(* com.in28minutes.learn_spring_aop.aopexample.*.*.*(..))"
    )
    public Object executionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        //Start time
        long startTime = System.currentTimeMillis();
        //Execute Method
        Object returnValue = proceedingJoinPoint.proceed();
        //Stop time
        long stopTime = System.currentTimeMillis();

        long duration = stopTime -startTime;
        log.info("Around Aspect {},Execution time is -> {}",proceedingJoinPoint,duration);
        return returnValue;
    }
}
