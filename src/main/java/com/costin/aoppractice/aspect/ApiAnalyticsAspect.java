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
@Order(3)
public class ApiAnalyticsAspect {
    @Before("com.costin.aoppractice.aspect.PointcutExpressions.forDaoPackageWithoutGettersAndSetters()")
    public void apiAnalyticsAdvice(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        System.out.println("\n========>>>> Executing the API Analytics advice for method " + signature);

//        Object[] args = joinPoint.getArgs();
//
//        for(Object arg : args) {
//            System.out.println(arg);
//        }

    }

}
