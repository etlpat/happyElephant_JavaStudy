package com._05_concurrentUtils._03_collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;


// CopyOnWriteArrayList
//
//
// 1.核心思想：写时复制 (Copy-On-Write)
//  CopyOnWriteArrayList 的核心思想如其名：“写时复制”。
//  ——读取操作：所有读取操作（get, iterator 等）都在原始数组上进行，不需要任何锁，因此速度极快。
//  ——修改操作：任何会修改集合内容的操作（add, set, remove 等）都会先创建底层数组的一个新副本，
//          然后在这个新副本上进行修改。修改完成后，再将集合的数组引用指向这个新副本。
//  这种“读写分离”的思想是它线程安全和高读取性能的关键。
//
//
// 2.如何保证线程安全？
//  ——读与读之间：不互斥，可以并发进行，因为不会修改数据。
//  ——读与写之间：不互斥。读操作读取的是修改前的旧数组，写操作在新副本上进行。因此，读操作不会被写操作阻塞。
//  ——写与写之间：互斥。通过一把全局的 ReentrantLock 锁来保证同一时刻只有一个线程能执行修改操作，避免创建多个副本导致数据混乱。
//  重要特性：由于读操作总是访问修改发生前的数组快照，因此它永远不会抛出 ConcurrentModificationException。
//
//
// 3.优点与缺点
//  优点：极高的读性能--读操作无锁，与单线程性能几乎无异。
//       线程安全--无需外部同步。
//       不会抛出 ConcurrentModificationException--迭代器使用集合开始遍历时的快照。
//  缺点：内存占用大--每次写操作都会复制整个底层数组，如果集合很大，频繁的写操作会导致频繁的垃圾回收和内存占用。
//       数据一致性弱--读取操作不能保证获取到最新的数据，它只能看到创建迭代器（或开始读取）那一刻的数据快照。
//       写性能差--add, set, remove 等操作的开销非常大，因为涉及数组复制。不适合写操作频繁的场景。
//
//
// 4.适用场景
//  CopyOnWriteArrayList 非常适合读操作远远多于写操作的场景。
//  经典用例：
//      ①事件监听器列表：在 GUI 框架（如 Swing）或事件驱动模型中，注册和注销监听器（写操作）的频率很低，
//              但事件触发时遍历通知所有监听器（读操作）的频率很高。
//      ②缓存：缓存的数据不常改变，但会被大量并发读取。
//      ③配置信息：应用配置通常在启动时加载，之后很少修改，但会被许多线程频繁读取。
//
//


public class _04_CopyOnWriteArrayList {
    public static void main(String[] args) throws InterruptedException {


        // (1)创建CopyOnWriteArrayList
        //  注意：由于CopyOnWriteArrayList继承自List，因此它具有List接口定义的一切方法！
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.addAll(Arrays.stream(new String[]{"A", "B", "C"}).toList());


        // (2)创建线程修改列表
        new Thread(() -> {
            try {
                // 等待一下，确保迭代器先被创建
                Thread.sleep(500);
                // 这是一个写操作，会复制新数组
                list.add("D");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();


        // (3)获取插入数据前的迭代器
        //  注意：CopyOnWriteArrayList在获取迭代器的那一刻，就固定了一个数组快照
        Iterator<String> before = list.iterator();// （旧快照）


        // (4)获取插入数据后的迭代器
        Thread.sleep(1000);
        Iterator<String> after = list.iterator();// （新快照）


        // (5)分别输出插入前后的迭代器数据
        System.out.print("（旧快照）before迭代器数据：");
        before.forEachRemaining((str) -> System.out.print(str + " "));// A B C  （旧快照）
        System.out.print("\n（新快照）after迭代器数据：");
        after.forEachRemaining((str) -> System.out.print(str + " "));// A B C D （新快照）


    }
}
