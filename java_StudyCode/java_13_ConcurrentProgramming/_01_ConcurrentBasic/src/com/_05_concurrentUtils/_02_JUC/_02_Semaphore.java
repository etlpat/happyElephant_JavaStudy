package com._05_concurrentUtils._02_JUC;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;


// 信号量--Semaphore
//
// 1.Semaphore概念
//  Semaphore 是 Java 并发包中提供的一种计数信号量，用于【控制同时访问特定资源的线程数量】。
//  它维护了一个许可证集合，线程可以通过获取许可证来访问资源，使用完毕后释放许可证。
//
// 2.许可证（Permits）
//  Semaphore 内部维护一定数量的许可证
//  ——线程通过 acquire() 获取许可证
//  ——线程通过 release() 释放许可证
//  如果没有可用许可证，线程会被阻塞
//
// 3.主要用途
//  ①限制资源并发访问数量
//  ②实现资源池
//  ③控制流量
//

public class _02_Semaphore {
    public static void main(String[] args) throws InterruptedException {


        // (1)创建信号量（许可证为3：同时只允许最多存在3个信号量）
        Semaphore semaphore = new Semaphore(3);


        // (2)使用信号量控制同时访问资源的线程数量
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        HashSet<Callable<Object>> tasks = new HashSet<>();
        for (int i = 0; i < 15; i++) {
            tasks.add(() -> {
                try {
                    // (3)获取信号量
                    semaphore.acquire();
                    System.out.println("线程" + Thread.currentThread().getId()
                            + " 获取信号量... " + LocalDateTime.now().getSecond());
                    Thread.sleep(2000);
                } finally {
                    // (4)释放信号量
                    semaphore.release();
                }
                return null;
            });
        }
        threadPool.invokeAll(tasks);


    }
}
