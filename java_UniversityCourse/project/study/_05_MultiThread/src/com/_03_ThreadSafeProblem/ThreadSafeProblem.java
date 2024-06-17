package com._03_ThreadSafeProblem;

// 线程安全问题
//
// (1)线程不安全？
//  当存在多个线程同时执行，并且它们访问、修改同一个共享资源时，可能造成线程安全问题
//
//  案例：银行取钱


public class ThreadSafeProblem {
    public static void main(String[] args) throws Exception {
        Account account = new Account(10000);
        int money = 10000;// 取的钱数

        Runnable myRunnable = new Runnable() {// 线程的run任务：取钱
            @Override
            public void run() {
                try {
                    if (account.drawMoney(money)) {
                        System.out.println(Thread.currentThread().getName() + "取钱成功！取了" + money);
                    } else {
                        System.out.println(Thread.currentThread().getName() + "取钱失败！");
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };


        Thread t1 = new Thread(myRunnable, "小明");
        Thread t2 = new Thread(myRunnable, "小红");

        t1.start();// 小红取钱成功！取了10000
        t2.start();// 小明取钱成功！取了10000

        t1.join();// 等待两个线程执行完，查看账户余额
        t2.join();
        System.out.println(account);// 账户中剩余：-10000元、

        // 注意：正常情况下，账户余额只能为正（正常情况：小明取走10000，余额为0，小红取钱失败）
        //      但是，实际情况是，“判断”和“取钱”中间有一个sleep(500)，二人判断时，余额为10000，都允许取钱，休眠结束后，各取10000，账户余额为负
        // 以上就是线程的不安全性
    }
}
