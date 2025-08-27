package com._03_JMM._01_volatile;


// volatile(易变关键字)
//
// 1.功能
//  volatile可以用来修饰成员变量和静态成员变量,他可以避免线程从自己的工作缓存中查找变量的值,
//  必须到主存中获取它的值,线程操作volatile变量都是直接操作主存。
//
//
// 2.原理
//  volatile可以保证共享变量的【可见性】和【有序性】。
//  volatile的底层实现原理是【内存屏障】,Memory Barrier(Memory Fence)
//      ■ 对volatile变量的写指令后会加入写屏障
//      ■ 对volatile变量的读指令前会加入读屏障
//
//  ①volatile读写屏障 如何保证可见性？
//      ■ 写屏障(sfence)保证在该屏障之前的,对共享变量的改动,都同步到主存当中
//      ■ 而读屏障(lfence)保证在该屏障之后,对共享变量的读取,加载的是主存中最新数据
//
//  ②volatile读写屏障 如何保证有序性？
//      ■ 写屏障会确保指令重排序时,不会将写屏障之前的代码排在写屏障之后
//      ■ 读屏障会确保指令重排序时,不会将读屏障之后的代码排在读屏障之前
//

public class _01_volatile {
    // volatile关键字，将flag声明为易变的，使其它线程访问该变量时直接从主存中访问（不在线程中缓存）
    volatile static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        Thread myThread = new Thread(() -> {
            try {
                while (flag) {
                    System.out.println("hello world!!!");
                    Thread.sleep(300);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        myThread.start();

        Thread.sleep(3000);
        System.out.println("停止!!!");
        flag = false;

    }
}
