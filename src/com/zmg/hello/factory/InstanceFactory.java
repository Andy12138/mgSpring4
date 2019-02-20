package com.zmg.hello.factory;

import com.zmg.hello.main.Car;

import java.util.HashMap;
import java.util.Map;

/**
 * 实例工厂模式
 */
public class InstanceFactory {
    private Map<String, Car> cars = null;

    public InstanceFactory() {
        this.cars = new HashMap<>();
        cars.put("Audi",new Car("Audi","shanghai",1000));
        cars.put("Xiaomi",new Car("Xiaomi","beijing",2000));
    }

    private Car getCar(String name) {
        return cars.get(name);
    }

}
