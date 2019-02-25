package com.zmg.hello.aop.xml;

import com.zmg.hello.aop.ArithmeticCalculator;
import org.springframework.stereotype.Component;

public class ArithmeticCalculatorImpl implements ArithmeticCalculator {
    @Override
    public int add(int i, int j) {
        int result = 1+j;
        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result = i-j;
        return result;
    }
}
