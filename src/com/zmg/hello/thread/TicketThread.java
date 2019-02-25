package com.zmg.hello.thread;

/**
 * 线程生命周期：新建、就绪、运行、阻塞、结束
 * 线程安全：
 * --多个线程操作共享资源需要显示线程同步；不然会导致共享资源出错，比如线程一挂起，线程二获取得到
 * --资源，输出后，线程一获得cpu资源后也接着输出已经被线程二输出的资源，就造成共享资源错误了
 * 解决方案：
 * 1.同步代码
 * --将操作共享资源的代码块用synchronized（）{}抱起来
 * --然后小括号里面放入一个主线程级别的对象：如果是通过实现Runable接口的可以放入this，但是继承Thread的不行（多个，无法得到统一）
 * 2.同步方法
 * --用synchronized修饰方法（就等同于同步代码的synchronized(this){}），然后在run方法中调用此方法，但是通过继承Thread类的不能通过同步方法解决线程安全问题
 */
class Ticket extends Thread {
    static int ticket = 100;
    static Object obj = new Object();
    public void run() {
        while (true) {
            synchronized (obj) {
                if (ticket > 0) {
                    try {
                        Thread.currentThread().sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + ticket--);
                } else {
                    break;
                }
            }
        }
    }
}

public class TicketThread {
    public static void main(String[] args) {
        Ticket t1 = new Ticket();
        Ticket t2 = new Ticket();
        Ticket t3 = new Ticket();
        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");
        t1.start();
        t2.start();
        t3.start();
    }
}
