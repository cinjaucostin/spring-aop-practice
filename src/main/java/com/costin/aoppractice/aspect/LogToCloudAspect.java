package com.costin.aoppractice.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class LogToCloudAspect {

    @Before("com.costin.aoppractice.aspect.PointcutExpressions.forDaoPackageWithoutGettersAndSetters()")
    public void logToCloudAdvice(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        System.out.println("\n========>>>> Executing the log to cloud for method " + signature);
    }

}
