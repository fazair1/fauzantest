package com.fauzan.fauzantest.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectTest {

    @Before("execution(* com.fauzan.fauzantest.Service.*.*(..))")
    public void logBeforeServiceMethod(JoinPoint joinPoint) {
        System.out.println("📌 Called method: " + joinPoint.getSignature().getName());
    }

}
