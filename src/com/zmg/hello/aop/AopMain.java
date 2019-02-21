package com.zmg.hello.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMain {
    public static void main(String[] args){
//        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculatorImpl();
//        arithmeticCalculator = new ArithmeticCalculatorLoggingProxy(arithmeticCalculator).getLoggingProxy();
//        int result = arithmeticCalculator.add(11,12);
//        System.out.println("结束了，结果是："+result);

        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-aop.xml");
        ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) ctx.getBean("arithmeticCalculator");

        int result = arithmeticCalculator.add(1,2);
        System.out.println("计算结果："+result);
    }
}
