package com._01_threadBasic._02_threadMethod;


// 线程优先级
//  线程优先级会提示(hint)调度器优先调度该线程,但它仅仅是一个提示,调度器可以忽略它。
//  如果cpu比较忙,那么优先级高的线程会获得更多的时间片,但cpu闲时,优先级几乎没作用。
//
// setPriority：设置线程优先级
//  优先级范围[1, 10]，数字越大优先级越高，默认优先级为5。

public class _03_setPriority {
    public static void main(String[] args) {

        Thread myThread = new Thread(() -> {
            System.out.println(111);
        });

        myThread.setPriority(10);// 设置线程优先级
        myThread.start();

    }
}
