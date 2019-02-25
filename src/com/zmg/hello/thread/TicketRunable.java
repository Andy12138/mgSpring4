package com.zmg.hello.thread;

/**
 * 推荐使用这个实现Runable的方法来写多线程
 * 1.因为可以避免单一继承性问题
 * 2.可以方便实现线程之间的共享资源，如这个票ticket，就不用了static静态化
 */
class Ticket1 implements Runnable {
    int ticket = 100;
    @Override
    public void run() {
        while (true) {
//            synchronized (this) {//这里的this,可以代表独立的对象锁
//                if (ticket > 0) {
//                    System.out.println(Thread.currentThread().getName() + ":" + ticket--);
//                } else {
//                    break;
//                }
//            }
            sale();
        }
    }

    synchronized void sale() {//类似于同步代码的this对象
        if (ticket > 0) {
            try {
                Thread.currentThread().sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":" + ticket--);
        }
    }
}

public class TicketRunable {
    public static void main(String[] args) {
        Ticket1 tk = new Ticket1();
        Thread t1 = new Thread(tk);
        Thread t2 = new Thread(tk);
        Thread t3 = new Thread(tk);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();

    }
}
