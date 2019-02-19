package com.zmg.hello.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {
    public static void main(String args[]){
//        HelloZmg zmg = new HelloZmg();
//        zmg.setName("名桂");
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloZmg zmg = (HelloZmg) applicationContext.getBean("helloZmg");
        System.out.println(zmg.getName());

        Car car = applicationContext.getBean(Car.class);
        System.out.println(car.toString());
    }
}
