package com.zmg.hello.factory;

import com.zmg.hello.main.Car;

import java.util.HashMap;
import java.util.Map;

/**
 * 静态工厂方法
 */
public class StaticFactory {
    private static Map<String,Car> cars = new HashMap<>();

    static {
        cars.put("Audi",new Car("Audi","shanghai",1000));
        cars.put("Xiaomi",new Car("Xiaomi","beijing",2000));
    }

    public static Car getCars(String name) {
        return cars.get(name);
    }

}
