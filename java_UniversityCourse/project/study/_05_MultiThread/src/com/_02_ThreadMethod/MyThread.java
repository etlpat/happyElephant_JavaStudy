package com._02_ThreadMethod;

public class MyThread extends Thread {
    // 重写构造器
    public MyThread() {
    }

    public MyThread(Runnable target) {
        super(target);
    }

    @Override
    public void run() {
        int i = 1;
        while (true) {
            System.out.println(getName() + "，进程循环次数：" + i);
            i++;

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
