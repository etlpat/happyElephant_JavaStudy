package com._01_threadBasic._02_threadMethod;


// yield
//  1.调用yield会让当前线程从Running进入Runnable就绪状态,然后调度执行其它同优先级的线程。
//      如果这时没有同优先级的线程,那么不能保证让当前线程暂停的效果。
//  2.yield的具体实现依赖于操作系统的任务调度器。

public class _02_yield {
    public static void main(String[] args) {

        Thread myThread = new Thread(() -> {
            System.out.println(111);
        });

        myThread.start();
        System.out.println(myThread.getState());

        myThread.yield();// 使线程进入Runnable就绪态
        System.out.println(myThread.getState());

    }
}
