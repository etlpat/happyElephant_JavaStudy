package com._01_threadBasic._02_threadMethod;


// sleep
//  1.调用sleep会让当前线程从Running进入Timed_Waiting阻塞状态
//  2.其它线程可以使用interrupt方法打断正在睡眠的线程,这时sleep方法会抛出InterruptedException
//  3.睡眠结束后的线程未必会立刻得到执行
//  4.建议用TimeUnit的sleep代替Thread的sleep来获得更好的可读性

public class _01_sleep {
    public static void main(String[] args) throws InterruptedException {

        Thread myThread = new Thread(() -> {
            try {
                // todo 注意：sleep在哪个线程中使用，哪个线程就休眠
                Thread.sleep(2000);// 使thread线程休眠
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("线程被唤醒!!!!! " + e.getMessage());
            }
        });

        myThread.start();
        System.out.println(myThread.getState());// RUNNABLE

        Thread.sleep(500);// 使主线程休眠
        System.out.println(myThread.getState());// TIMED_WAITING

        myThread.interrupt();// 打断myThread线程休眠

    }
}
