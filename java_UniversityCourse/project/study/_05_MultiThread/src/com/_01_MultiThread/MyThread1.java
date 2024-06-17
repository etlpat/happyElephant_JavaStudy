package com._01_MultiThread;

// 如何自己创建一个线程类？
// 方法1：子类继承Thread类，并重写run方法

public class MyThread1 extends Thread {
    @Override
    public void run() {// 重写run方法
        int i = 1;
        while (true) {
            System.out.println("MyThread1类，子线程对象，循环次数：" + i);
            i++;

            try {
                sleep(1000);// 线程暂停1000ms=1s
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
