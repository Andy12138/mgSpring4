package com.zmg.hello.main;

public class HelloZmg {
    private String name;

    public HelloZmg() {
        System.out.println("HelloZMG初始化...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("HelloZmg开始name赋值");
        this.name = name;
    }
}
