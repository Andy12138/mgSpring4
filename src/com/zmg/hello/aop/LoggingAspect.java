package com.zmg.hello.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 可以使用@Order 注解指定切面的优先级，值越小优先级越高
 */
@Order(2)
@Aspect
@Component
public class LoggingAspect {
//    @Before("execution(public int com.zmg.hello.aop.ArithmeticCalculator.*(int, int))")
//    public void beforeMethod(JoinPoint joinPoint) {
//        String method = joinPoint.getSignature().getName();
//        Object[] args = joinPoint.getArgs();
//        System.out.println("方法before"+method+"值"+ Arrays.asList(args));
//    }
//
//    @After("execution(public int com.zmg.hello.aop.ArithmeticCalculator.*(int, int))")
//    public void afterMethod(JoinPoint joinPoint) {
//        String method = joinPoint.getSignature().getName();
//        //Object[] args = joinPoint.getArgs();
//        System.out.println("方法after"+method+"值");
//    }
//
//    @AfterReturning(value = "execution(public int com.zmg.hello.aop.ArithmeticCalculator.*(int, int))",returning = "result")
//    public void afterMethod(JoinPoint joinPoint, Object result) {
//        String method = joinPoint.getSignature().getName();
//        //Object[] args = joinPoint.getArgs();
//        System.out.println("AfterReturning"+method+"值"+result);
//    }
//
//    @AfterThrowing(value = "execution(public int com.zmg.hello.aop.ArithmeticCalculator.*(int, int))",throwing = "e")
//    public void afterMethod(JoinPoint joinPoint,Exception e) {
//        String method = joinPoint.getSignature().getName();
//        //Object[] args = joinPoint.getArgs();
//        System.out.println("方法after"+method+"值"+"异常："+e);
//    }

    @Around("execution(public int com.zmg.hello.aop.ArithmeticCalculator.*(int, int))")
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
