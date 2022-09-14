package com.costin.aoppractice.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PointcutExpressions {
    @Pointcut("execution(* com.costin.aoppractice.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("execution(* com.costin.aoppractice.dao.*.get*())")
    private void forGetter() {}

    @Pointcut("execution(* com.costin.aoppractice.dao.*.set*(*))")
    private void forSetter() {}

    @Pointcut("forDaoPackage() && !(forGetter() || forSetter())")
    public void forDaoPackageWithoutGettersAndSetters() {}

}
