package com.zmg.hello.thread;

/**
 * 线程通信
 */
class ThreadCommunication implements Runnable {
    int num = 1;
    @Override
    public void run() {
        while (true) {
            synchronized (this){
                notify();
                if (num <= 100) {
                    try {
                        Thread.currentThread().sleep(10);
                        System.out.println(Thread.currentThread().getName() + ":" + num++);
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}

public class ThreadCommunicationTest {
    public static void main(String[] args) {
        ThreadCommunication tc = new ThreadCommunication();
        Thread t1 = new Thread(tc);
        Thread t2 = new Thread(tc);
        t1.setName("线程一：");
        t2.setName("线程二：");
        t1.start();
        t2.start();
    }
}
