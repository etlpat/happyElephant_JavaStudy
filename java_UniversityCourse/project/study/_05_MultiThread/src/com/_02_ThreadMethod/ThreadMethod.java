package com._02_ThreadMethod;

// (1)Thread类的常见构造器
//  Thread();
//  Thread(String name);// 指定线程名称
//  Thread(Runnable target);// 为线程对象传入实现了Runnable接口的对象参数
//  Thread(Runnable target, String name);
//
//
// (2)Thread类的常用方法
//  void run();// 线程执行的任务方法
//  void start();// 启动线程
//  String getName();// 获取该线程的名称（默认名称：Thread-下标）
//  void setName(String name);// 设置该线程名称
//  static Thread currentThread();// 返回【当前】正在执行的线程对象的引用【静态方法，类级别的方法，返回当前正在执行的线程】
//  static void sleep(long millis);// 让【当前】线程休眠指定的毫秒【静态方法，类级别的方法，使当前线程休眠】
//  void join();// 等待该线程中止，再继续执行后面代码


public class ThreadMethod {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new MyThread();// 法1：继承Thread类，重写run方法
        Thread t2 = new Thread(new MyRunnable());// 法2：为Thread类传入实现了的Runnable接口的对象参数

        // getName()获取线程名称
        System.out.println(t1.getName());// Thread-1
        System.out.println(t2.getName());// Thread-2
        // Thread类的静态方法currentThread()，获取当前正在执行的进程对象（主线程）
        System.out.println(Thread.currentThread().getName());// main

        // setName()设置线程名称
        t1.setName("one!!!");
        t2.setName("two!!!");

        t1.start();
        t1.join();// 等待t1线程运行完，再继续向下执行
        t2.start();
    }
}
