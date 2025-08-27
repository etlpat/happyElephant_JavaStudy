package com._02_monitor._01_synchronized;


// synchronized的使用方法2：添加到方法上————锁默认是当前实例对象(this)
class Counter2 {
    private int count = 0;

    // synchronized添加到方法上：锁默认为当前实例对象this
    // 注意：increment、decrement、getCount都以this为锁，因此这三个方法互斥！
    public synchronized void increment() {
        count++;
    }

    public synchronized void decrement() {
        count--;
    }

    public synchronized int getCount() {
        return count;
    }
}


public class _02_synchronized02 {
    public static void main(String[] args) throws InterruptedException {
        Counter2 counter = new Counter2();

        Thread myThread1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                counter.increment();
            }
        });

        Thread myThread2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                counter.decrement();
            }
        });

        myThread1.start();
        myThread2.start();
        myThread1.join();
        myThread2.join();
        System.out.println(counter.getCount());
    }
}
