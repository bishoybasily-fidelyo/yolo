/**
 * Copyright (C) 2014 android10.org. All rights reserved.
 *
 * @author Fernando Cejas (the android10 coder)
 */
package com.gmail.bishoybasily.yolo.aspects.aspect;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * Aspect representing the cross cutting-concern: Method and Constructor Tracing.
 */
@Aspect
public class TraceAspect {

    @Pointcut("execution(@com.gmail.bishoybasily.yolo.aspects.annotation.DebugTrace * *(..))")
    public void methodAnnotatedWithDebugTrace() {
    }

    @Pointcut("execution(@com.gmail.bishoybasily.yolo.aspects.annotation.DebugTrace *.new(..))")
    public void constructorAnnotatedDebugTrace() {
    }

    @Around("methodAnnotatedWithDebugTrace() || constructorAnnotatedDebugTrace()")
    public Object weaveJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();

        Object result = joinPoint.proceed();

        Log.d("@@", "class: " + className + ", method: " + methodName);

        return result;
    }

}