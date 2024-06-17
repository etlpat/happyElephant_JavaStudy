package com._05_ThreadDetail;

// 线程细节
//
// (1)并发和并行
//  进程：正在运行的程序(软件)就是一个独立的进程
//  线程：一个进程(运行的程序)中，可以同时运行很多个线程
//  【进程中的多个线程，时并发和并行执行的】
//  并发：进程中的线程，由CPU调度执行。但CPU能同时处理的线程数有限，
//      为了保证所有线程都能执行，CPU会轮询切换运行线程，让我们感觉这些线程在同时执行
//  并行：同一时刻，CPU可调度多个线程执行
//  e.g.
//      并行：本电脑的CPU能同时调度16个线程执行
//      并发：本电脑此时需要处理3500个线程，则会16个16个的交替轮番执行这3500个线程
//
//
// (2)线程的生命周期
//  线程的6中状态：（通过Thread.State查看）
//      NEW // 新建状态（线程对象new后，调用start()前）
//      RUNNABLE // 可运行状态（线程对象调用start()后）
//      BLOCKED // 锁阻塞（遇到synchronized同步代码块/同步方法，没得到锁时，就会进入锁阻塞状态，得到锁后解除该状态）
//      WAITING // 无限等待（调用了wait()方法，会无限等待，直到被notify()唤醒，退出该状态）
//      TIMED_WAITING // 计时等待（调用了sleep(毫秒)/wait(毫秒)等，会进入计时等待，直到等待时间结束/被唤醒，退出该状态）
//      TERMINATED // 被终止状态（线程执行完毕，或者出现异常后）
//
//
// (3)线程的优先级
//  Java中，线程的优先级分为10档[1,10]，默认是5
//  在线程的【并发】中，优先级越高，该线程被调度的概率越大
//  方法：
//      int getPriority();// 获取线程优先级
//      void setPriority(int newPriority);// 设置线程优先级
//
//
// (4)守护线程
//  守护线程：若【所有非守护线程】执行结束，守护线程也会被强迫停止
//  方法：void setDaemon(boolean on);// 设置为守护线程
//
//
// (5)yield出让线程的执行权
//  static void yield();// 出让当前线程的执行权（static方法，类级别的方法）
//  出让线程执行权：当一个线程占据了CPU，CUP会一次性完成这个线程中的很多条语句，然后切换到另一个线程（并发）
//              若执行到某条语句后，调用yield()方法，CPU会立刻切换线程（让线程进行争抢，可能还是本线程抢到执行权）
//
//
// (6)线程的死锁
//  如下，若两条线程同时进行如下run代码：
//      线程1满足if条件，拿到了"锁1"，与此同时线程2不满足if条件，进入else语句拿到了"锁2"。
//      之后，线程1等待线程2释放"锁2"，但是线程2也在等待线程1释放"锁1"，二者都不能继续执行，程序卡死
//      以上错误就是同步嵌套中的死锁
//  e.g.
//      public void run() {
//          if (...) {
//              synchronized ("锁1") {
//                  synchronized ("锁2") {
//                      // 共享资源修改
//                  }
//              }
//          } else {
//              synchronized ("锁2") {
//                  synchronized ("锁1") {
//                      // 共享资源修改
//                  }
//              }
//          }
//      }


public class ThreadDetail {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable(10), "线程1");
        Thread thread2 = new Thread(new MyRunnable(10000), "线程2");


        // get、set优先级
        System.out.println(Thread.currentThread().getPriority());// 5（main主线程，默认优先级也是5）
        System.out.println(thread1.getPriority());// 5（线程默认优先级是5）
        thread1.setPriority(1);
        thread2.setPriority(10);
        thread1.setPriority(5);
        thread2.setPriority(5);


        // 将thread2设置为守护线程
        thread2.setDaemon(true);

        // 原本thread1循环10次，thread2循环10000次
        // 但是thread2被设置为守护线程。thread1线程执行结束后，thread2也随着结束
        thread1.start();
        thread2.start();
    }
}


class MyRunnable implements Runnable {
    private int runTime = 100;

    public MyRunnable() {
    }

    public MyRunnable(int runTime) {
        this.runTime = runTime;
    }


    @Override
    public void run() {
        for (int i = 1; i <= runTime; i++) {// 不传参默认循环100次
            System.out.println(Thread.currentThread().getName() + ",循环次数：" + i);
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                System.out.println(e);
//            }
        }
    }
}