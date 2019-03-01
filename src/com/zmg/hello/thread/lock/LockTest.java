package com.zmg.hello.thread.lock;

import org.aspectj.weaver.ast.Test;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock和synchronized的区别
 * lock优于synchronized，原因是A抢了资源如果休眠了，B就需要持续等待。但是如果使用lock，就可以中断B的等待
 * lock不会自动释放锁，需要在finally中自己用lock.unlock()释放
 */
public class LockTest {
    private ArrayList<Integer> arrayList = new ArrayList<Integer>();
    public static void main(String[] args)  {
        final LockTest test = new LockTest();

        new Thread(){
            public void run() {
                test.insert(Thread.currentThread());
            };
        }.start();

        new Thread(){
            public void run() {
                test.insert(Thread.currentThread());
            };
        }.start();
    }

    public void insert(Thread thread) {
        Lock lock = new ReentrantLock();    //注意这个地方
        lock.lock();
        try {
            System.out.println(thread.getName()+"得到了锁");
            for(int i=0;i<5;i++) {
                arrayList.add(i);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }finally {
            System.out.println(thread.getName()+"释放了锁");
            lock.unlock();
        }
    }
}