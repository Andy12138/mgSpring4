package com.zmg.hello.thread;

/**
 * 1.start()：启动线程并执行相应的run（）方法
 * 2.run（）：子线程要执行的代码放入其中
 * 3.currentThread（）：静态的，调取当前线程
 * 4.getName（）：获取此线程的名字
 * 5.setName（）：设置此线程的名字
 * 6.yield():调用此方法的线程释放当前cpu的执行权
 * 7.join（）：在A线程中调用b线程的join方法，表示：当执行到此方法，a线程停止执行，直到b线程执行完毕
 * 8.isAlive（）：判断当前线程是否还存活
 * 9.sleep(long l):显示的让当前线程睡眠l毫秒
 * 10.线程通信：wait() notify() notifyAll()
 */
class ChildThread extends Thread {
    @Override
    public void run() {
        for (int i=1;i<=10;i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
public class TestThread {
    public static void main(String[] args) {
        ChildThread ct = new ChildThread();
        ct.setName("子线程");
        ct.start();
        for (int i=1;i<=10;i++) {
            if (i==5) {
                  //Thread.currentThread().yield();
                try {
                    Thread.currentThread().sleep(2000);
//                    ct.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
        System.out.println(ct.getName()+":"+ct.isAlive());
        //直接写一个子线程3
        new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+":");
                for (int i = 1; i <= 10; i++) {
                    System.out.print(i);
                }
            }
        }.start();
    }
}


