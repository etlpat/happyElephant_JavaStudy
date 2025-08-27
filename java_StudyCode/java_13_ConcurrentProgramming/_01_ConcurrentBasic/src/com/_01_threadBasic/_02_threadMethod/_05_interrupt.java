package com._01_threadBasic._02_threadMethod;


// interrupt
//  ①isInterrupted()：判断是否被打断（不会清除“打断标记”）
//  ②interrupt()：打断线程
//      --如果被打断线程正在阻塞（sleep/wait/join）,会导致被打断的线程抛出InterruptedException,并清除打断标记。（会真正打断）
//      --如果打断的正在运行的线程,则会设置打断标记。（不会真正打断，只会设置标记）
//      --如果park的线程被打断,也会设置打断标记。

public class _05_interrupt {
    public static void main(String[] args) throws InterruptedException {

        // (1)打断阻塞线程
        Thread myThread1 = new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        myThread1.start();

        Thread.sleep(200);
        myThread1.interrupt();// 打断正在阻塞的线程
        System.out.println(myThread1.isInterrupted());// false

        Thread.sleep(2000);
        System.out.println("========================");


        // (2)打断正在运行的线程（不会真正打断，只会将打断标记设为true）
        Thread myThread2 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {// 若当前线程被打断，则跳出循环
                    break;
                }
            }
            System.out.println("myThread2终止！");
        });
        myThread2.start();

        Thread.sleep(200);
        myThread2.interrupt();// 打断正在运行的线程
        System.out.println(myThread2.isInterrupted());// true


    }
}
