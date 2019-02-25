package com.zmg.hello.aop.xml;

import com.zmg.hello.aop.ArithmeticCalculator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMain {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-aop-xml.xml");
        ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) ctx.getBean("arithmeticCalculator");
        arithmeticCalculator.add(1,2);
    }
}
