package com._02_ThreadMethod;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        int i = 1;
        while (true) {
            // 用静态方法currentThread()获取当前的线程对象，调用getName()
            System.out.println(Thread.currentThread().getName() + "，进程循环次数：" + i);
            i++;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
