package com._05_concurrentUtils._02_JUC;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;
import java.util.stream.Stream;


// 读写锁--ReentrantReadWriteLock
//
//
// 1.ReentrantReadWriteLock特点
//  ReentrantReadWriteLock 是 Java 并发包中提供的一种读写分离锁，
//  它允许多个线程同时读取共享资源，但只允许一个线程写入共享资源，实现了读-读共享、读-写互斥、写-写互斥的特性。
//  ——核心特性：
//      ①锁的分离
//          读锁（ReadLock）：共享锁，允许多个线程同时获取
//          写锁（WriteLock）：排他锁，同一时刻只允许一个线程获取
//      ②锁的互斥规则
//          读锁 vs 读锁：不互斥，可并发访问
//          读锁 vs 写锁：互斥，不能同时持有
//          写锁 vs 写锁：互斥，不能同时持有
//
//
// 2.读锁、写锁
//  ①读锁（ReadLock）特性：
//      共享性：多个线程可以同时持有读锁
//      可重入性：同一线程可以多次获取读锁
//      与写锁互斥：如果有线程持有写锁，其他线程无法获取读锁
//  ②写锁（WriteLock）特性：
//      排他性：同一时刻只有一个线程可以持有写锁
//      可重入性：同一线程可以多次获取写锁
//      与所有锁互斥：持有写锁时，其他线程无法获取读锁或写锁
//
//
// 3.注意事项
//  避免锁升级：不支持从读锁升级到写锁
//  及时释放锁：务必在 finally 块中释放锁
//  避免死锁：注意锁的获取顺序
//  性能考虑：在读少写多的场景中，性能可能不如普通互斥锁
//


class Data {
    private Object data = new Object();
    private ReentrantReadWriteLock rw = new ReentrantReadWriteLock();// 获取读写锁
    private ReentrantReadWriteLock.ReadLock r = rw.readLock();// 获取读锁
    private ReentrantReadWriteLock.WriteLock w = rw.writeLock();// 获取写锁

    // 读操作
    public void read() {
        r.lock();// 上读锁
        try {
            System.out.println("线程" + Thread.currentThread().getId()
                    + " 读取数据:" + data + "..." + LocalDateTime.now().getSecond());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            r.unlock();// 解锁
        }
    }

    // 写操作
    public void write() {
        w.lock();// 上写锁
        try {
            System.out.println("线程" + Thread.currentThread().getId()
                    + " 写入数据:" + data + "..." + LocalDateTime.now().getSecond());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            w.unlock();// 解锁
        }
    }
}


public class _01_ReentrantReadWriteLock {
    public static void main(String[] args) throws InterruptedException {
        Data data = new Data();
        ExecutorService threadPool = Executors.newFixedThreadPool(20);// 线程池
        ArrayList<Callable<Object>> readTasks = new ArrayList<>(10);// 读任务集合
        for (int i = 0; i < 10; i++) {
            readTasks.add(() -> {
                data.read();
                return null;
            });
        }
        ArrayList<Callable<Object>> writeTasks = new ArrayList<>(10);// 写任务集合
        for (int i = 0; i < 10; i++) {
            writeTasks.add(() -> {
                data.write();
                return null;
            });
        }


        // (1)并发读取数据
//        threadPool.invokeAll(readTasks);

        // (2)并发写入数据
//        threadPool.invokeAll(writeTasks);

        // (3)并发读写数据
        threadPool.invokeAll(Stream.concat(readTasks.stream(), writeTasks.stream())
                .collect(Collectors.toSet()));

    }
}
