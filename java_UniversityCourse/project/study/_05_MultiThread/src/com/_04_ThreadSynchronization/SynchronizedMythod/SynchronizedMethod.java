package com._04_ThreadSynchronization.SynchronizedMythod;

import com._04_ThreadSynchronization.Account;

// 同步方法解决线程安全问题

public class SynchronizedMethod {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(10000);
        int money = 10000;// 取的钱数

        Runnable myRunnable = new Runnable() {
            @Override
            public synchronized void run() {// 把run变成同步方法，每次只能允许一个线程进入
                // （这里synchronized把this，也就是匿名内部类的this作为锁对象，将该对象作为参数的Thread线程，执行run方法时都会被锁）
                if (account.drawMoney(money)) {
                    System.out.println(Thread.currentThread().getName() + "取钱成功！取了" + money);
                } else {
                    System.out.println(Thread.currentThread().getName() + "取钱失败！");
                }
            }
        };


        Thread t1 = new Thread(myRunnable, "小明");
        Thread t2 = new Thread(myRunnable, "小红");

        t1.start();// 小明取钱成功！取了10000
        t2.start();// 小红取钱失败！

        t1.join();
        t2.join();
        System.out.println(account);// 账户中剩余：0元
    }
}
