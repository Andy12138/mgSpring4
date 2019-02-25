package com.zmg.hello.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;


public class LoggingAspect {


    public void pointcutMethod() {

    }

    public void beforeMethod(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("方法before"+method+"值"+ Arrays.asList(args));
    }

    @After("pointcutMethod()")
    public void afterMethod(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        //Object[] args = joinPoint.getArgs();
        System.out.println("方法after"+method+"值");
    }

    public void afterResultMethod(JoinPoint joinPoint, Object result) {
        String method = joinPoint.getSignature().getName();
        //Object[] args = joinPoint.getArgs();
        System.out.println("AfterReturning"+method+"值"+result);
    }

    public void afterThrowMethod(JoinPoint joinPoint,Exception e) {
        String method = joinPoint.getSignature().getName();
        //Object[] args = joinPoint.getArgs();
        System.out.println("方法after"+method+"值"+"异常："+e);
    }

    public Object aroundMethod(ProceedingJoinPoint pjd) {
        Object result =null;
        String methodName = pjd.getSignature().getName();
        try {
            //前置通知
            System.out.println("前置通知");
            result = pjd.proceed();
            System.out.println("返回通知");

        } catch (Throwable e) {
            System.out.println("异常通知");
            e.printStackTrace();
        }
        System.out.println("后置通知");
        return result;
    }

}
