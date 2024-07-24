package com.healthhistoryservice.demo.monitoring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.healthhistoryservice.demo..*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Method execution started: {}", joinPoint.getSignature());
    }

    @After("execution(* com.healthhistoryservice.demo..*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        logger.info("Method execution completed: {}", joinPoint.getSignature());
    }
    
    @AfterThrowing(pointcut = "execution(* com.healthhistoryservice.demo..*.*(..))", throwing = "e")
    public void logException(Throwable e) {
        logger.error("Exception occurred: {}", e.getMessage(), e);
    }
}