package com.zmg.hello.thread;

/**
 * 生产者消费者案例
 */
public class ProduceConsumeTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        Consumer consumer = new Consumer(clerk);
        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);
        t1.setName("生产者");
        t2.setName("消费者");
        t1.start();
        t2.start();
    }
}

/**
 * 共享资源，产品
 */
class Clerk {
    int product;

    synchronized void AddProduct() {
        if (product < 10) {
            product++;
            System.out.println(Thread.currentThread().getName() + "生产第" + product + "个产品");
            notifyAll();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    synchronized void subProduct() {
        if (product > 0) {
            System.out.println(Thread.currentThread().getName() + "消费第" + product + "个产品");
            product--;
            notifyAll();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 生产者
 */
class Producer implements Runnable {
    Clerk clerk;
    public Producer(Clerk clerk) {
        this.clerk=clerk;
    }

    @Override
    public void run() {
        while (true) {
            clerk.AddProduct();
        }
    }
}

/**
 * 消费者
 */
class Consumer implements Runnable {
    Clerk clerk;
    public Consumer(Clerk clerk) {
        this.clerk=clerk;
    }

    @Override
    public void run() {
        while (true) {
            clerk.subProduct();
        }
    }
}