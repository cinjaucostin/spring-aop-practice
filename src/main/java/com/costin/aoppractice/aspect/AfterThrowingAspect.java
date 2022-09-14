package com.costin.aoppractice.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterThrowingAspect {

    @Pointcut("execution(* com.costin.aoppractice.dao.AccountDAO.findAccounts(..))")
    private void findAccountsPointcut() {}

    @AfterThrowing(pointcut = "findAccountsPointcut()", throwing = "theException")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable theException) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        System.out.println("\n========>>>> Executing @AfterThrowing advice for method " + signature);
        System.out.println(theException);
    }

}
