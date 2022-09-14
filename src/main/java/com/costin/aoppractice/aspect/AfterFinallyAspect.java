package com.costin.aoppractice.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterFinallyAspect {
    @Pointcut("execution(* com.costin.aoppractice.dao.AccountDAO.findAccounts(..))")
    private void findAccountsPointcut() {}

    @After("findAccountsPointcut()")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        System.out.println("\n========>>>> Executing @After advice for method " + signature);
    }

}
