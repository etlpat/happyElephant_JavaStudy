package com._05_concurrentUtils._01_threadPool;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


// 任务调度线程池——ScheduledThreadPoolExecutor
public class _03_scheduledThreadPoolExecutor {
    public static void main(String[] args) {


        // (1)创建任务调度线程池
        ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(3);// 设置核心线程数


        // (2)执行延时任务（使该线程延迟1秒执行）
        scheduledPool.schedule(() -> {
            System.out.println("hello world!!! " + LocalDateTime.now().getSecond());
        }, 1, TimeUnit.SECONDS);// 延迟1秒


        // (3)执行定时任务（使该线程延迟1秒执行，之后每隔2秒执行一次）
        scheduledPool.scheduleAtFixedRate(() -> {
            System.out.println("Go!!!!! " + LocalDateTime.now().getSecond());
        }, 1, 2, TimeUnit.SECONDS);// 延迟1秒，周期2秒


    }
}
