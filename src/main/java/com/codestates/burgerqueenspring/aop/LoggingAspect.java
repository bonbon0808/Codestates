package com.codestates.burgerqueenspring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

// 메서드 호출 시와 메서드 호출 후에 로깅 기록이 남도록 AOP를 적용
@Aspect
public class LoggingAspect {
    @Pointcut("execution(* com..*.*(..))")
    private void targetMethod(){}

    @Around("targetMethod()")
    public void Logging(ProceedingJoinPoint joinPoint) throws Throwable {

    }




}
