package com.bridgelabz.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Purpose: This is Aspect Oriented Programming class to hold all the logging related management
 * of the Whole Application
 *
 * @author Sunil
 * @version 0.0.1
 * @since 07/12/2021
 */
@Aspect
@Component
@Slf4j
public class LogAdvice {

    /**
     * Purpose: method to implement th logging throughout the application
     */
    @Pointcut(value = "execution(* com.bridgelabz.*.*.*(..))")
    public void loggingPointCut() {

    }

    /**
     * Purpose: method to create logging statement throughout the application to track the application flow
     *
     * @param proceedingJoinPoint : manages the reflection of the program for getting the method details
     * @return : JSON format of logger statement before and after the advic
     * @throws Throwable if any exception
     */
    public Object applicationLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ObjectMapper mapper = new ObjectMapper();
        String methodName = proceedingJoinPoint.getSignature().getName();
        String className = proceedingJoinPoint.getTarget().getClass().toString();
        Object[] array = proceedingJoinPoint.getArgs();
        log.info("method invoked" + className + ":" + methodName + "()" + "arguments:" + mapper.writeValueAsString(array));
        Object object = proceedingJoinPoint.proceed();
        log.info(className + ":" + methodName + "()" + "Response:" + mapper.writeValueAsString(object));
        return object;
    }
}
