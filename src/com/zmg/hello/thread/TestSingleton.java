package com.zmg.hello.thread;

/**
 * 懒汉式线程安全问题
 */
class Singleton {
    public Singleton() {
    }
    private static Singleton instance = null;

    public static Singleton getInstance() {
        synchronized (Singleton.class) {
            if (null == instance) {
                instance = new Singleton();
            }
        }
        return instance;
    }
}
public class TestSingleton {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);
    }
}
