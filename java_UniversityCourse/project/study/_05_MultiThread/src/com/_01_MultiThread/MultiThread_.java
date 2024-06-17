package com._01_MultiThread;

// 多线程
//
// (1)概念
//  多线程：即从软硬件上实现的多条执行流程的技术（多条线程由CPU负责调度执行）
//  线程：Java通过lang包下的Thread类的对象来代表线程
//
//  main方法的运行，本身就是一条线程，称之为“主线程”
//  main方法中创建并启动的线程，统一称之为“子线程”
//
//
//
// (2)线程的创建方法
//  方法1：继承Thread（线程）类，并重写其run方法
//
//  方法2：创建一个任务类R来实现Runnable接口，重写run方法。之后创建任务类R的对象r，将r对象作为参数创建Thread线程对象
//        注意：Runnable接口中只包含抽象的run方法
//        本质：还是让Thread对象获取到我们实现的run方法
//
//  两种方法的对比：
//      方法1：代码简单，但是必须继承Thread类，无法再继承其它类，拓展性低
//      方法2：任务类只是继承Runnable接口，还可继承其它类，拓展性更强
//
//
//
// (3)Thread类的常见构造器
//  Thread();
//  Thread(String name);// 指定线程名称
//  Thread(Runnable target);// 为线程对象传入实现了Runnable接口的对象参数
//  Thread(Runnable target, String name);
//
//
// (4)Thread类的常用方法
//  void run();// 线程执行的任务方法
//  void start();// 启动线程
//  String getName();// 获取该线程的名称
//  void setName(String name);// 设置该线程名称
//  static Thread currentThread();// 返回当前线程对象的引用
//  static void sleep(long millis);// 让当前线程休眠指定的毫秒
//  void join();// 等待该线程中止，再继续执行后面代码


public class MultiThread_ {
    // main方法由一条默认的主线程来执行
    public static void main(String[] args) {
        // 方法1：（子类继承Thread类，重写其run方法）
        Thread thread1 = new MyThread1();

        // 方法2：（直接创建Thread对象，并为其传入实现了Runnable接口的对象参数）
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 1;
                while (true) {
                    System.out.println("实现Runnable的子线程对象2，循环次数：" + i);
                    i++;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });


        // 启动线程
        thread1.start();
        thread2.start();
        int i = 1;
        while (true) {
            System.out.println("主线程main，循环次数：" + i);
            i++;
            try {
                // 注意；Thread线程类在lang包中，系统默认引入，因此可以自己通过类名调用static方法
                Thread.sleep(1000);// sleep是static方法
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
