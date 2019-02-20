package com.zmg.hello.factory;

import com.zmg.hello.main.Car;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class factoryMain {
    public static void main(String args[]) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-factory.xml");

        //静态工厂方法
        Car car = (Car) ctx.getBean("car1");
        System.out.println(car);

        //实例工厂方法
        Car car1 = (Car) ctx.getBean("car2");
        System.out.println(car1);

//        FactoryBean模式
        Car car3 = (Car) ctx.getBean("car3");
        System.out.println(car3);
    }
}
