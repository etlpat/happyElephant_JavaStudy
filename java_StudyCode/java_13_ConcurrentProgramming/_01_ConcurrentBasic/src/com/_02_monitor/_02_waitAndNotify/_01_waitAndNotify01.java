package com._02_monitor._02_waitAndNotify;


// wait & notify
//
// 1.方法功能
//  wait方法：当争抢到锁的线程调用wait()方法，则变为WAITING等待状态，进入WaitSet等待集合，并释放锁。
//  notify方法：当调用notify()方法，则唤醒WAITING等待状态的线程，使其进入EntryList准备下次争抢锁。
//
// 2.语法
//  obj.wait()：让进入object监视器的线程到waitSet等待
//  obj.notify()：在object上正在waitSet等待的线程中随机挑一个唤醒
//  obj.notifyAll()：让object上正在waitSet等待的线程全部唤醒
//  注意：它们都是线程之间进行协作的手段,都属于Object对象的方法。必须获得此对象的锁,才能调用这几个方法。
//
// 3.sleep和wait的区别
//  ①sleep是Thread方法,而wait是Object的方法。
//  ②sleep不需要强制和synchronized配合使用,但wait需要和synchronized一起用。
//  ③sleep在睡眠的同时,不会释放对象锁的,但wait在等待的时候会释放对象锁。
//

public class _01_waitAndNotify01 {
    // 创建对象，作为锁
    static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread myThread = new Thread(() -> {
            synchronized (lock) {
                try {
                    Thread.sleep(1000);
                    System.out.println("myThread:111");
                    // 进入WAITING等待状态，释放锁
                    lock.wait();
                    Thread.sleep(1000);
                    System.out.println("myThread:222");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        myThread.start();
        System.out.println(myThread.getState());// RUNNABLE

        Thread.sleep(2000);
        System.out.println(myThread.getState());// WAITING
        Thread.sleep(1000);

        synchronized (lock) {
            lock.notifyAll();// 唤醒lock的所有WAITING状态的线程
        }
        System.out.println(myThread.getState());// BLOCKED
    }
}
