package com._01_threadBasic._02_threadMethod;


// 守护线程
//  默认情况下,Java进程需要等待所有线程都运行结束,才会结束。
//  有一种特殊的线程叫做`守护线程`,只要其它非守护线程运行结束了,即使守护线程的代码没有执行完,也会强制结束。
//
// --setDaemon()方法：将线程设置为守护线程
//
// 注意：
//  ■ 垃圾回收器线程就是一种守护线程
//  ■ Tomcat中的Acceptor和Poller线程都是守护线程,所以Tomcat接收到shutdown命令后,不会等待它们处理完当前请求

public class _06_setDaemon {
    public static void main(String[] args) throws InterruptedException {

        Thread myThread = new Thread(() -> {
            try {
                Thread.sleep(500);
                System.out.println("111");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        myThread.setDaemon(true);// 设置为守护线程
        myThread.start();

        Thread.sleep(200);
        System.out.println("222");

    }
}
