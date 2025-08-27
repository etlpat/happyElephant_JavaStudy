package com._02_monitor._01_synchronized;


// synchronized的使用方法1：添加到方法内的任意代码块上————锁是指定的对象
class Counter1 {
    // 不同线程的共享资源
    private int count = 0;

    public void increment() {
        // 互斥锁（由于不同线程调用同一个Counter对象，因此以本对象this为锁即可）
        // 注意：increment、decrement、getCount都以this为锁，因此这三个方法互斥！
        synchronized (this) {
            count++;
        }
    }

    public void decrement() {
        synchronized (this) {
            count--;
        }
    }

    public int getCount() {
        synchronized (this) {
            return count;
        }
    }
}


public class _01_synchronized01 {
    public static void main(String[] args) throws InterruptedException {
        Counter1 counter = new Counter1();

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
