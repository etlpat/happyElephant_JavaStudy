package com._05_concurrentUtils._03_collection;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.LongAdder;


// LinkedBlockingQueue
//
//
// 1.介绍
//  LinkedBlockingQueue 是 Java 并发包 (java.util.concurrent) 中一个重要的线程安全队列实现，
//  它基于链表结构，支持可选的容量限制，是生产者-消费者模式的经典实现。
//
//
// 2.核心特性
//  (1)数据结构
//      基于链表：使用单向链表存储元素，具有链表的天然特性（动态扩容）
//      可选容量：可以是有界队列（指定容量）或无界队列（默认 Integer.MAX_VALUE）
//      线程安全：使用分离的读写锁（ReentrantLock），生产者和消费者可以并行操作
//  (2)阻塞特性
//      队列满时：生产者线程会被阻塞，直到队列有空间
//      队列空时：消费者线程会被阻塞，直到队列有元素可用
//      支持超时：提供带超时参数的 offer() 和 poll() 方法
//
//
// 3.常用API
//  (1)构造方法
//      LinkedBlockingQueue(): 创建一个容量为Integer.MAX_VALUE的无界队列
//      LinkedBlockingQueue(int capacity): 创建一个指定容量的有界队列
//      LinkedBlockingQueue(Collection<? extends E> c): 创建一个包含指定集合元素的队列
//  (2)主要方法：
//      put(E e): 将元素插入队列，如果队列已满，则阻塞直到有空间。
//      take(): 获取并移除队列的头节点，如果队列为空，则阻塞直到有元素可用。
//      offer(E e): 将元素插入队列，如果队列已满，则返回false，否则返回true。
//      poll(): 获取并移除队列的头节点，如果队列为空，则返回null。
//      peek(): 获取但不移除队列的头节点，如果队列为空，则返回null。
//
//
// 4.性能特点
//  (1)优点
//      高吞吐量：分离锁设计使生产者和消费者可以并行操作
//      灵活容量：支持有界和无界两种模式
//      公平性：可配置公平锁策略，避免线程饥饿
//      内存效率：链表结构按需分配内存，不会预先分配大数组
//  (2)缺点
//      内存开销：每个元素需要额外的节点对象开销
//      缓存不友好：链表节点在内存中不连续，缓存命中率较低
//  (3)使用场景
//      线程池任务队列：Executors.newFixedThreadPool() 默认使用无界 LinkedBlockingQueue
//      生产者-消费者模式：处理速度不一致的生产者和消费者
//      数据缓冲：作为临时数据缓冲区，平衡处理速度差异
//      工作窃取模式：可以作为工作队列使用
//  (4)注意事项
//      无界队列风险：使用默认无界队列时，可能造成内存溢出
//      公平性选择：默认使用非公平锁，可通过构造函数选择公平锁
//      批量操作：drainTo() 方法可以高效地批量移除元素
//      迭代器：迭代器是弱一致性的，反映创建迭代器时的队列状态
//
//


public class _03_LinkedBlockingQueue {
    public static void main(String[] args) {


        // (1)创建LinkedBlockingQueue
        LinkedBlockingQueue<Long> blockingQueue = new LinkedBlockingQueue<>(3);
        LongAdder longAdder = new LongAdder();


        // (2)生产者线程
        new Thread(() -> {
            try {
                while (true) {
                    // !!!阻塞添加!!!
                    blockingQueue.put(longAdder.longValue());
                    System.out.println(blockingQueue + " <<< [生产者]存入：" + longAdder.longValue());
                    longAdder.increment();
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();


        // (3)消费者线程
        new Thread(() -> {
            try {
                while (true) {
                    // !!!阻塞获取!!!
                    Long take = blockingQueue.take();
                    System.out.println(blockingQueue + " >>> [消费者]取出：" + take);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();


    }
}
