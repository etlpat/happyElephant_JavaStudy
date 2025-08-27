package com._01_threadBasic._01_createThread;

// 原理之Thread与Runnable的关系
//  分析Thread的源码,理清它与Runnable的关系
//
//  小结:
//      方法1是把线程和任务合并在了一起,方法2是把线程和任务分开了
//      用Runnable更容易与线程池等高级API配合
//      用Runnable让任务类脱离了Thread继承体系,更灵活


// 创建线程的方式2：先创建线程任务Runnable，再将其作为参数传入线程
public class _02_createThread02 {
    public static void main(String[] args) {

        // 创建线程任务
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("111");
            }
        };

        // 创建线程，传入线程任务
        Thread thread = new Thread(runnable);

        // 启动线程
        thread.start();

        System.out.println("222");

    }
}
