package com.in28minutes.learn_spring_aop.aopexample;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutConfig {

    @Pointcut("execution(* com.in28minutes.learn_spring_aop.aopexample.*.*.*(..))")
    public void businessAndDataConfig(){}

    @Pointcut("execution(* com.in28minutes.learn_spring_aop.aopexample.business.*.*(..))")
    public void businessConfig(){}

    @Pointcut("execution(* com.in28minutes.learn_spring_aop.aopexample.data.*.*(..))")
    public void dataConfig(){}
}
