package com._04_ThreadSynchronization;

// 线程同步（用来解决线程安全问题）
// synchronization：同步
//
// (1)线程同步思想
//  线程安全问题：多个线程同时访问、修改共享资源，导致资源出现问题
//  线程同步：让多个线程按照先后顺序，依次访问共享资源
//
//
// (2)线程同步的常见方法
//  加锁：每次只允许一个线程加锁，加锁后才能进入访问，访问完毕后自动解锁，然后其它线程才能再加锁进来
//  如何加锁？三种方法：1.同步代码块 2.同步方法 3.Lock锁
//
//
//
// (3)同步代码块
//  同步代码块：把访问共享资源的【核心代码】给上锁，以此保证线程安全
//  语法：
//      synchronized(同步锁) {
//          // 访问共享资源的核心代码
//      }
//
//  注意：1.同步锁，只要是个对象就行，没有任何限制，如字符串对象"同步锁"就可以
//       2.对于同时执行的线程来说，同步锁必须是同一把（同一个对象），否则线程依然不安全
//       3.实际开发建议用共享资源(的引用)作为锁（一般直接用this/共享对象名）
//  原理：每次只允许一个线程加锁后进入，执行完毕后自动解锁，其它线程才可以进来执行
//
//
//
// (4)同步方法
//  同步方法：把访问共享资源的【核心方法】给上锁，以此保证线程安全
//  语法：
//      修饰符 synchronized 返回类型 方法名(形参列表) {
//          // 操作共享资源的代码
//      }
//  原理：每次只允许一个线程加锁进入该方法，执行结束后自动解锁，其它线程才可进入
//  注意：同步方法内部也会隐含一个锁，也就是this（一般是共享资源对象）
//

public class ThreadSynchronization {
    public static void main(String[] args) throws Exception {
        Account account = new Account(10000);
        int money = 10000;// 取的钱数

        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                // 同步代码块，作用：保证同一时间内只能有一个线程在访问代码块中的内容
                synchronized ("锁1") {// 用字符串当锁，由于"锁1"是常量池中的对象，对于每个线程肯定都是这一把锁(对象)// 但是平时不建议用字符串常量作为锁，因为可能阻碍某些无关线程的执行
                    if (account.drawMoney(money)) {
                        System.out.println(Thread.currentThread().getName() + "取钱成功！取了" + money);
                    } else {
                        System.out.println(Thread.currentThread().getName() + "取钱失败！");
                    }
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
