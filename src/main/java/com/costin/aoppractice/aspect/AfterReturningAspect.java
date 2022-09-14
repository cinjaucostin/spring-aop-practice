package com.costin.aoppractice.aspect;

import com.costin.aoppractice.dao.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class AfterReturningAspect {

    @Pointcut("execution(* com.costin.aoppractice.dao.AccountDAO.findAccounts(..))")
    private void findAccountsMethodPointcut() {}

    @AfterReturning(pointcut = "findAccountsMethodPointcut()",
                    returning = "result")
    public void afterReturningFindAccountsMethodAdvice(
            JoinPoint joinPoint,
            List<Account> result) {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        System.out.println("\n========>>>> Executing @AfterReturning advice for method " + signature);
        System.out.println("The result: " + result);

        convertNamesToUpperCase(result);

    }

    public void convertNamesToUpperCase(List<Account> accounts) {
        for(Account account : accounts) {
            account.setName(account.getName().toUpperCase());
        }
    }

}
