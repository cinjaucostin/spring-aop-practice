package com.costin.aoppractice.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class AroundAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.costin.aoppractice.service.TrafficFortuneService.getFortune(..))")
    private void getFortunePointcut() {}

    @Around("getFortunePointcut()")
    public Object aroundGetFortuneAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result = null;
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();

        logger.info("\nExecuting Around Advice for method..." + signature);

        long begin = System.currentTimeMillis();

        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            logger.info("We have some problems: " + e);
            result = "Nimic important in trafic azi varule";
        }

        long end = System.currentTimeMillis();

        long duration = end - begin;

        logger.info("Duration of method execution in seconds: " + duration / 1000);

        return result;
    }

}
