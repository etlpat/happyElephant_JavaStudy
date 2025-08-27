package com._02_monitor._03_reentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;


// 可重入锁——ReentrantLock
//
// 1.对比synchronized和ReentrantLock：
//  相对于synchronized锁，可重入锁ReentrantLock具备如下特点：
//      ■ 可重入（synchronized也可重入）
//      ■ 可中断
//      ■ 可以设置超时时间
//      ■ 可以设置为公平锁
//      ■ 支持多个条件变量
//  选择建议：
//      对于绝大多数简单的同步需求，使用 `synchronized`，代码更简洁，不易出错。
//      当需要可中断、超时、公平性、多个等待条件等高级功能时，毫不犹豫地选择 `ReentrantLock`。
//
//
// 2.ReentrantLock的特性
//  ①重入性 (Reentrancy)
//      是什么？——可重入性是指 同一个线程可以多次获取同一把锁 而不会导致死锁。
//      为什么需要？——考虑一个递归调用或一个同步方法内部调用另一个同步方法的情况，如果锁不可重入，线程在第二次尝试获取自己已持有的锁时就会被阻塞，从而造成死锁。
//      可重入的实现？——`ReentrantLock`内部维护了一个计数器（`hold count`）来跟踪锁被重入的次数。
//
//  ②可中断的锁获取 (Interruptible Lock Acquisition)
//      是什么？——指一个线程在等待获取锁的过程中 可以响应中断。如果线程在等待时被其他线程调用了 `interrupt()`，它会停止等待并抛出 `InterruptedException`。
//      为什么需要？——`synchronized` 在获取锁时是无法被中断的，这可能导致线程长时间无响应地等待，难以实现优雅的线程取消或系统关闭。`ReentrantLock` 的 `lockInterruptibly()` 方法解决了这个问题。
//
//  ③锁超时 (Timed Lock Acquisition)
//      是什么？——指线程尝试获取锁时，可以 设置一个超时时间。如果在规定时间内没有获得锁，线程不会无限期等待，而是放弃并返回 `false`。
//      为什么需要？——这可以有效避免死锁，或者用于实现“尝试锁”逻辑（“如果锁可用我就用，不可用我就先做别的事”）。
//
//  ④公平锁 (Fair Lock)
//      是什么？——公平性是指锁的获取遵循 先来后到（FIFO）的原则。等待时间最长的线程将优先获得锁。
//      如何设置？——通过在构造函数中传入 `true` 来创建一个公平锁。`ReentrantLock fairLock = new ReentrantLock(true);`
//      公平 vs 非公平：
//          公平锁：保证了顺序，避免了线程饥饿（某个线程永远拿不到锁）。但 性能开销较大，因为需要维护队列和唤醒特定线程。
//          非公平锁（默认）：允许“插队”。当一个线程释放锁时，恰好另一个新线程来请求，新线程可能会抢先获得锁，而不理会等待队列中的老线程。吞吐量更高，但可能导致某些线程等待时间过长。
//      如何选择？——在绝大多数情况下，使用 非公平锁（默认）即可。
//
//  ⑤条件变量 (Condition)
//      是什么？——条件变量 `Condition` 实现了 `wait/notify` 的线程等待/唤醒机制，但与之相比，一个 `ReentrantLock` 可以关联多个 `Condition`，从而实现更精细的线程控制。
//      为什么需要？——`Object` 的 `wait()` 和 `notify()`/`notifyAll()` 必须和 `synchronized` 一起使用，并且只有一个等待队列。
//                  `Condition` 的 `await()`/`signal()`/`signalAll()` 必须和 `Lock` 一起使用，但可以创建多个等待队列，只唤醒特定类型的线程，减少不必要的唤醒。
//

public class _01_reentrantLock {
    public static void main(String[] args) {

        // (1)获取可重入锁对象
        ReentrantLock reentrantLock = new ReentrantLock();

        try {
            // (2)尝试获取锁
            //  参数：设置最长等待时间，可以不带此参数。（若首次未抢到锁，则在等待时间内不断尝试争抢锁；若超时也未抢到锁，则返回false）
            boolean isLock = reentrantLock.tryLock(1, TimeUnit.SECONDS);
            if (!isLock) {
                System.out.println("未抢到锁");
                return;
            }
        } catch (InterruptedException e) {
            // 注意：ReentrantLock锁，在争抢锁/阻塞等待锁的过程中，可以被打断。（synchronized不可被打断）
            System.out.println("获取锁时被打断");
            e.printStackTrace();
            return;
        }

        try {
            // 成功抢到锁，执行对应业务逻辑...
            System.out.println("hello world!!!");
        } finally {
            // (3)释放锁
            reentrantLock.unlock();
        }

    }
}
