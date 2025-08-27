package com._01_threadBasic._01_createThread;


// 创建线程的方式1：在线程内定义线程任务
public class _01_createThread01 {
    public static void main(String[] args) {

        // 创建线程对象
        Thread thread = new Thread() {
            // 重写要执行的任务
            @Override
            public void run() {
                System.out.println("111");
            }
        };
        thread.setName("我的线程");// 设置线程名称

        // 启动线程
        // 注意：一个线程对象只能start一次，否则报错！
        thread.start();

        System.out.println("222");

    }
}
