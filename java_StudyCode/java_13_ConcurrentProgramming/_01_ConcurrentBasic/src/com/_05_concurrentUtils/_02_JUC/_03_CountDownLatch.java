package com._05_concurrentUtils._02_JUC;

import java.util.HashSet;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


// 倒计时门闩--CountDownLatch
//
// 1.概述
//  CountDownLatch 是 Java 并发包中提供的一种同步工具，允许一个或多个线程等待其他线程完成操作。
//  它通过一个计数器来实现，计数器初始化为一个正数，当计数器减到零时，所有等待的线程会被释放。
//
// 2.计数器（Count）
//  初始化时指定一个正整数值
//  每完成一个任务，计数器减1
//  当计数器为0时，所有等待线程被唤醒
//
// 3.两种主要角色
//  主线程：调用 await() 等待其他线程完成
//  工作线程：完成任务后调用 countDown() 减少计数
//

public class _03_CountDownLatch {
    public static void main(String[] args) throws InterruptedException {


        // (1)创建倒计时门闩CountDownLatch
        CountDownLatch countDownLatch = new CountDownLatch(3);


        ExecutorService pool = Executors.newSingleThreadExecutor();
        HashSet<Callable<Object>> tasks = new HashSet<>();
        for (int i = 1; i <= 3; i++) {
            tasks.add(() -> {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " 使倒计时-1");
                // (2)使倒计时-1
                countDownLatch.countDown();
                return null;
            });
        }

        System.out.println("等待倒计时结束...");
        pool.invokeAll(tasks);


        // (3)等待倒计时结束
        countDownLatch.await();
        System.out.println("倒计时结束！");


    }
}
