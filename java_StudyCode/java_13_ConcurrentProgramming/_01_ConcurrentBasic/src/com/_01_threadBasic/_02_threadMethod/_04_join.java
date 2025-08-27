package com._01_threadBasic._02_threadMethod;


// join语法
//
// 1.语法
//  join()：等待线程运行结束
//  join(long n)：等待线程运行结束，最多等待n毫秒
//
// 2.原理
//  join()底层基于wait()和notify()实现。当A线程使用join等待B线程运行结束：
//      --当A开始等待，调用wait()进入WAITING状态；当B执行结束时，调用notify()唤醒A线程。
//

public class _04_join {
    public static void main(String[] args) throws InterruptedException {

        Thread myThread = new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("111");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        myThread.start();

        myThread.join();// 等待myThread线程运行结束
//        myThread.join(200);// 等待myThread线程运行结束，最多等待200毫秒

        System.out.println("222");
    }
}
