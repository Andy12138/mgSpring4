package com.zmg.hello.factory;

import com.zmg.hello.main.Car;
import org.springframework.beans.factory.FactoryBean;

public class CarFactoryBean implements FactoryBean {

    private String brand;

    public void setBrand(String brand){
        this.brand=brand;
    }

//    返回bean对象
    @Override
    public Object getObject() throws Exception {
        return new Car(brand,"guangzhou",1000);
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
