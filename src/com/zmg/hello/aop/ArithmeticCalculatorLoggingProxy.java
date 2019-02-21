package com.zmg.hello.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ArithmeticCalculatorLoggingProxy {

//    要代理的对象
    private ArithmeticCalculator target;

    public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target) {
        this.target = target;
    }

    public ArithmeticCalculator getLoggingProxy() {
        ArithmeticCalculator proxy = null;

//        ClassLoader类加载器
        ClassLoader loader = target.getClass().getClassLoader();
        Class [] interfaces = new Class[]{ArithmeticCalculator.class};
        InvocationHandler h = new InvocationHandler() {
            /**
             * ClassLoader：代理对象，一般不使用该对象
             * method: 正在调用的方法
             * args:传入的参数
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                System.out.println("日志打印开始"+method.getName()+ Arrays.asList(args));
                Object result = null;

//                调用目标方法
//                前置通知
                result = method.invoke(target,args);

//                后置通知
                System.out.println("结果"+result);

                return  result;
            }
        };

        /**
         * loader:代理对象使用的类加载器
         * interfaces:指定代理对象的类型、即代理对象中可以有哪些方法
         * h：当前具体调用代理对象的方法时，应该如何进行相应，实际上就是调用invocationHandler的invoke方法
         */
        proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader,interfaces,h);
        return  proxy;
    }
}

