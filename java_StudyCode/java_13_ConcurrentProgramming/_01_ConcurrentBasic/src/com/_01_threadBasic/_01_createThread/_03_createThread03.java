package com._01_threadBasic._01_createThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


// 创建线程的方式3：FutureTask配合Thread
public class _03_createThread03 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 创建线程任务FutureTask
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() {
                System.out.println("111");
                return "hello world!!!";
            }
        });

        // 创建并启动线程
        Thread thread = new Thread(futureTask);
        thread.start();


        System.out.println("222");


        // 调用get：主线程阻塞，等待接收futureTask返回的结果
        String result = futureTask.get();
        System.out.println(result);

    }
}
