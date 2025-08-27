package com._02_monitor._02_waitAndNotify;

import java.util.concurrent.locks.LockSupport;


// park & unpark
//
// 1.基本概念
//  park和unpark：基于“许可(permit)”的阻塞和唤醒。（注意：wait和notify是基于“管程锁”）
//  这两个方法是Java并发包（java.util.concurrent.locks）中LockSupport类的核心静态方法，
//  该包提供了比传统wait()/notify()更灵活、更可靠的线程阻塞与唤醒机制。它们是构建高级同步工具（如锁、屏障等）的基石。
//
// 2.功能
//  ①park()：意为“停车”。
//      ——它的作用是阻塞当前线程，使其进入等待状态（WAITING或TIMED_WAITING），直到获取一个“许可”（permit）。
//  ②unpark(Thread thread)：意为“让停着的车开走”。
//      ———它的作用是为指定的线程提供一个“许可”，如果该线程正因park()而阻塞，则立即唤醒它。
//
// 3.特点
//  park&unpark 对比 wait&notify:
//      ①wait,notify和notifyAll必须配合Object Monitor一起使用；而park,unpark不必。
//      ②park&unpark是以线程为单位来阻塞和唤醒线程；而notify只能随机唤醒一个等待线程,notifyAll是唤醒所有等待线程,就不那么精确。
//      ③park&unpark可以先unpark；而wait&notify不能先notify。
//

public class _04_parkAndUnpark {
    public static void main(String[] args) throws InterruptedException {

        Thread myThread = new Thread(() -> {
            System.out.println("111");
            LockSupport.park();// ##阻塞##
            System.out.println("222");
        });
        myThread.start();

        Thread.sleep(500);
        System.out.println(myThread.getState());// WAITING

        LockSupport.unpark(myThread);// ##唤醒##

    }
}
