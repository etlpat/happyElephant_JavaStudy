package com._05_concurrentUtils._03_collection;


// 线程安全的集合类
//
//
// 1.概述
//  Java集合框架（Java Collections Framework）中的大部分类，如 ArrayList, HashMap, HashSet 等，都是非线程安全的。
//  在多线程环境下并发地修改这些集合会导致不确定的行为，如数据损坏、丢失或抛出 ConcurrentModificationException 异常。
//  ——为了解决这个问题，Java提供了三种主要策略来实现集合的线程安全：
//      ①选留的安全集合
//      ②修饰的安全集合
//      ③J.U.C安全集合
//
//
//
// 2.“选留的安全集合” (Legacy Thread-Safe Collections)
//  (1)介绍
//      这是Java早期（JDK 1.0/1.1）提供的线程安全集合类，现在通常被称为“遗留类”。
//      它们通过在每个方法上添加 synchronized 关键字来实现线程安全。
//      核心原理：粗粒度锁。无论进行什么操作（读或写），都会直接锁住整个集合对象，性能开销很大。
//
//  (2)代表性类
//      ①Vector：对应 ArrayList
//      ②Hashtable：对应 HashMap
//      ③Stack：继承自 Vector
//
//  (3)评价
//      优点：使用简单，保证了强一致性。
//      缺点：性能差--同步锁的粒度太粗，在高并发场景下，即使多个线程只是进行读操作，也会相互竞争锁，导致严重的性能瓶颈。
//           功能弱--在设计上没有现代集合框架丰富的API（如迭代器、函数式编程等）。
//      现状： 不推荐在新代码中使用。除非维护非常古老的系统，否则应优先选择 J.U.C 中的并发集合。
//
//
//
// 3.“修饰的安全集合” (Wrapped Thread-Safe Collections)
//  (1)介绍
//      在Java 1.2引入现代集合框架（ArrayList, HashMap等）后，为了能方便地让
//          这些非线程安全的集合变得安全，提供了 “装饰器” 工具类 Collections.synchronizedXXX。
//      核心原理： 使用包装器模式（Decorator Pattern）。它接收一个普通的集合对象，并返回一个包装后的线程安全版本。
//          这个包装类内部使用一个互斥锁（mutex）（通常是 this）来同步每个方法，同样是粗粒度锁。
//
//  (2)代表性方法
//      ①Collections.synchronizedList(List<T> list)
//      ②Collections.synchronizedMap(Map<K,V> m)
//      ③Collections.synchronizedSet(Set<T> s)
//
//  (3)评价
//      优点：灵活性高--可以将任何现有的普通集合快速转换为线程安全的集合。
//           接口统一--返回的集合实现了标准的 List, Map 等接口，与原有代码兼容性好。
//      缺点：与遗留集合一样，使用的是粗粒度锁，读和读之间也会互斥，并发性能依然不高。
//           在使用迭代器（Iterator） 进行遍历时，必须手动在外部使用 synchronized 块锁住整个集合，
//              否则可能会抛出 ConcurrentModificationException。
//      适用场景： 读多写少、并发竞争不激烈的场景，或者需要快速改造现有代码使其线程安全。
//
//
//
// 4.“J.U.C安全集合” (java.util.concurrent Thread-Safe Collections)
//  (1)介绍
//      这是Java 5.0引入的 java.util.concurrent 包（简称J.U.C）中提供的并发集合类，它们是现代高并发编程的首选和核心。
//      核心原理： 采用了一系列先进的无锁（Lock-Free）或细粒度锁技术，
//          如 CAS（Compare-And-Swap）、分段锁（Segment Locking）、写时复制（Copy-On-Write） 等，极大提升了并发性能。
//
//  (2)分类与代表性类
//      <1>并发Map：
//          ①ConcurrentHashMap： 替代 Hashtable 和 synchronizedMap。在JDK 7之前采用分段锁，
//              JDK 8及之后改为 synchronized + CAS + 红黑树 的实现，锁的粒度是每个桶（bucket）的头节点，并发度极高。
//      <2>写时复制（Copy-On-Write）集合：
//          ①CopyOnWriteArrayList： 替代 Vector 和 synchronizedList。
//              读操作完全无锁，性能极高。
//              写操作时（add, set等），会先复制一份新的数组，在新数组上修改，然后用新数组替换掉旧的引用。
//              适用于读多写极少的场景（如事件监听器列表）。
//          ②CopyOnWriteArraySet： 基于 CopyOnWriteArrayList 实现。
//      <3>并发Queue/Deque (用于生产者-消费者模型)：
//          ①阻塞队列（BlockingQueue）： 当队列满或空时，操作会被阻塞。
//              ——ArrayBlockingQueue： 有界，基于数组。
//              ——LinkedBlockingQueue： 可选有界或无界，基于链表。
//              ——PriorityBlockingQueue： 支持优先级的无界阻塞队列。
//              ——SynchronousQueue： 不存储元素，每个put必须等待一个take。
//          ②非阻塞队列：
//              ——ConcurrentLinkedQueue： 高效的无界非阻塞线程安全队列，使用CAS实现。
//      <4>其他：
//          ①ConcurrentSkipListMap： 并发版的 TreeMap，基于跳表实现。
//          ②ConcurrentSkipListSet： 并发版的 TreeSet。
//
//  (3)评价
//      优点：高并发、高性能--通过精妙的设计极大减少了线程竞争。
//           API强大--提供了大量适用于并发场景的原子操作（如 ConcurrentHashMap.putIfAbsent()）。
//      缺点：弱一致性--它们的迭代器返回的是迭代器创建时刻的快照，不会抛出 ConcurrentModificationException，
//              但可能无法反映迭代过程中集合的最新修改。这是为了性能而做出的一致性妥协。
//           使用更复杂--需要开发者根据具体场景（是读多写少还是写多读少？是否需要阻塞？）选择合适的集合类。
//
//
//
// 5.总结与对比
//  ————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
//  特性   |  遗留集合 (Legacy)	    |   装饰集合 (Wrapped)	            |   J.U.C 并发集合 (Recommended)
//  ————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
//  代表类 |   Vector, Hashtable	    |   Collections.synchronizedXXX     |   ConcurrentHashMap, CopyOnWriteArrayList
//  锁机制 |   粗粒度锁 (方法级)	    |   粗粒度锁 (对象级)	                |   细粒度锁、CAS、写时复制
//  性能   |   差	                |   较差                             |   高
//  一致性 |   强一致性	            |   强一致性                          |   弱一致性
//  迭代器 |   Fail-Fast，需手动同步	|   Fail-Fast，必须手动同步            |   弱一致性迭代，不会失败
//  推荐度 |   绝不推荐	            |   谨慎使用 (低并发场景)               |   强烈推荐 (高并发场景)
//  ————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
//
//  选择建议：
//      ①对于全新的高并发项目，直接选择 J.U.C 并发集合。
//      ②如果需要改造现有的、使用了标准集合接口的代码，且并发压力不大，
//          可以考虑使用 Collections.synchronizedXXX 进行快速包装，但要注意迭代器的同步问题。
//      ③避免使用 Vector 和 Hashtable，除非是为了兼容古董级代码。
//
//


public class _01_JavaCollectionsFramework {
}
