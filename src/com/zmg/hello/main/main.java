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

        Person person = (Person) applicationContext.getBean("person");
        System.out.println("set注入的人是："+person.toString());

        NewPerson newPerson = applicationContext.getBean(NewPerson.class);
        System.out.println("构造器注入的人是："+newPerson.toString());

//        关闭容器
        System.out.println("关闭容器");
        applicationContext.close();

    }
}
