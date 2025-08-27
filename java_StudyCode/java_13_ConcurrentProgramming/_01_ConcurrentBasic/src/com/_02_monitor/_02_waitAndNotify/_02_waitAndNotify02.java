package com._02_monitor._02_waitAndNotify;

import java.util.HashSet;


// 情景模拟：
//  一群人在干活，其中“小南”必须有烟才能干活，否则等待别人送烟。
public class _02_waitAndNotify02 {
    // 干活的资源，争抢到才能干活
    static final Object resources = new Object();
    static boolean smoke = false;


    public static void main(String[] args) {
        // 员工线程集合
        HashSet<Thread> employees = new HashSet<>();

        // 小南线程
        Thread xiaoNan = new Thread(() -> {
            synchronized (resources) {
                try {
                    while (true) {
                        if (!smoke) {
                            System.out.println("小南：没有烟，不能干活！！！");
                            resources.wait();// 变为WAITING状态，释放锁
                        } else {
                            System.out.println("小南：有烟了，开始干活！！！");
                            break;
                        }
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("小南：干完活了，下班！！！");
        });
        employees.add(xiaoNan);

        // 其他人线程
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            employees.add(new Thread(() -> {
                synchronized (resources) {
                    System.out.println("路人" + (finalI + 1) + "：开始干活");
                }
            }));
        }

        // 送烟人线程
        Thread songYanRen = new Thread(() -> {
            synchronized (resources) {
                System.out.println("送烟人：小南，我给你送烟来喽！！！");
                smoke = true;
                resources.notifyAll();// 唤醒小南
            }
        });
        employees.add(songYanRen);


        // 开始工作
        for (Thread thread : employees) {
            thread.start();
        }

    }
}
