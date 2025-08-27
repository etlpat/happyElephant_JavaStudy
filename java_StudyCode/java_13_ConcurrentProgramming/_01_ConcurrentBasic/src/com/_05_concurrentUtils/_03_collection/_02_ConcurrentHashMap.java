package com._05_concurrentUtils._03_collection;

import java.util.HashSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;


// ConcurrentHashMap
//
//
// 1.为什么需要 ConcurrentHashMap？
//  线程安全需求：多线程环境下，直接使用非线程安全的 HashMap 进行 put、get 等操作会导致数据不一致、死循环等问题。
//  性能瓶颈：Hashtable 和 Collections.synchronizedMap(hashMap) 采用粗粒度锁机制，
//      即直接使用 synchronized 锁住整个 Map 对象。这意味着任何操作，哪怕是只读的 get 操作，都会互斥，性能极差。
//  ConcurrentHashMap 的解决方案：它通过使用更细粒度的锁机制（JDK 7）
//      和后来的 CAS + synchronized（JDK 8）来实现高并发，在保证线程安全的同时，提供了极高的读写性能。
//
//
//
// 2.核心设计与演进：JDK 7 vs JDK 8
//  ConcurrentHashMap 的实现经历了重大革新，其核心设计理念是降低锁的粒度，从而减少线程间的竞争。
//  (1)JDK 7 的实现：分段锁（Segment Locking）
//      JDK 7 中的 ConcurrentHashMap 采用了一种称为“分段锁”的巧妙设计。
//      ①数据结构：它内部由一个 Segment 数组组成。每个 Segment 本质上是一个
//              继承了 ReentrantLock 的哈希表（类似于一个小的 HashMap）。可以理解为它将一个大Map拆成了多个小Map。
//      ②锁的粒度：锁的不是整个Map，而是一个 Segment。默认有 16 个分段（并发级别 concurrencyLevel 可设置）。
//      ③工作原理：
//          ——写操作（put, remove）：首先根据 key 的哈希值定位到对应的 Segment，
//                  然后只锁定这个特定的 Segment。此时，其他线程可以并发地访问和修改其他 Segment。
//          ——读操作（get）：完全无锁。因为 HashEntry 的 value 和 next 指针被声明为 volatile，
//                  可以安全地被多个线程同时读取，保证了可见性。
//      ④优点：将锁的竞争分散到了多个 Segment 上，并发性能相比锁住整个Map提升巨大。
//      ⑤缺点：Segments 的数量一旦初始化就不能改变，在某些极端情况下可能成为瓶颈。
//
//  (2)JDK 8 及之后的实现：CAS + synchronized
//      JDK 8 彻底重写了 ConcurrentHashMap，其设计思路借鉴了 HashMap 的优化（如数组+链表+红黑树），并采用了更现代的并发技术。
//      ①数据结构：与 HashMap 类似，是 Node 数组 + 链表 + 红黑树。
//      ②锁的粒度：锁的粒度进一步细化到每个数组桶（bucket）的头节点。
//      ③核心技术：
//          ——CAS (Compare-And-Swap)：用于无锁化的初始化数组、设置头节点等操作。
//                  这是一种乐观锁，不需要加锁，通过硬件指令保证原子性，效率极高。
//          ——synchronized：只锁住当前发生哈希冲突的链表的头节点或红黑树的根节点。
//                  在 put 或 remove 操作时，如果发现头节点不为空，则使用 synchronized 锁定该头节点。
//                  这样，只要操作的 key 散列到不同的桶上，线程就可以真正地并行执行。
//          ——volatile：Node 的 val 和 next 属性用 volatile 修饰，保证了读操作的可见性，
//                  使得读操作在大多数情况下都不需要加锁，性能极高。
//      ④工作流程（以 put 为例）：
//          Ⅰ--计算 key 的哈希值，定位到数组下标。
//          Ⅱ--如果桶为空，使用 CAS 无锁地插入新节点。
//          Ⅲ--如果桶不为空（发生哈希冲突），则 synchronized 锁住这个桶的头节点，然后进行链表遍历或树遍历并插入。
//          Ⅳ--根据链表长度决定是否要转换为红黑树（阈值 > 8）。
//      ⑤优点：
//          ——锁粒度更小：锁竞争的概率比分段锁更低，并发性能更高。
//          ——内存占用更小：取消了 Segment 的概念，数据结构更简单。
//          ——功能更强：提供了大量新的流式 API 和聚合方法（如 forEach, reduce, search）。
//
//
//
// 3.核心特性与常见方法
//  (1)弱一致性（Weakly Consistent）的迭代器：
//      当使用迭代器遍历时，它反映的是创建迭代器那一刻或者之后某个时间点的状态。
//      它不会抛出 ConcurrentModificationException，允许在迭代过程中并发修改。
//      这是一种设计上的权衡，牺牲强一致性来换取极高的读性能。
//  (2)线程安全的复合操作：
//      ①V putIfAbsent(K key, V value)：如果 key 不存在，则放入 value。这是原子操作。
//      ②boolean remove(Object key, Object value)：只有 key 对应的 value 等于传入的 value 时，才移除。这是原子操作。
//      ③V computeIfAbsent(K key, Function<? super K,? extends V> mappingFunction)：
//          如果 key 不存在，则通过给定的函数计算 value 并放入 Map。常用于延迟初始化场景（例如，构建本地缓存），并且保证函数只执行一次。
//  (3)统计方法：
//      ①int size()：返回的是一个估计值。
//          因为在并发环境下，精确统计 size 需要全局加锁，代价太高。JDK 8 使用了一个称为 CounterCell 的复杂计数器来尽量减小误差。
//      ②mappingCount()：推荐使用此方法代替 size()，因为它返回 long 类型，避免了 int 溢出问题。
//
//
//
// 4.总结与最佳实践
//  ——————————————————————————————————————————————————————————————————————————————————————
//  特性	      | Hashtable / synchronizedMap	    | ConcurrentHashMap (JDK 8+)
//  ——————————————————————————————————————————————————————————————————————————————————————
//  锁机制     | 粗粒度锁，锁整个表	                | 细粒度锁，只锁单个桶（头节点）
//  读性能     | 差，所有读操作互斥	                | 极高，读操作几乎完全无锁
//  写性能     | 差，所有写操作互斥	                | 高，只有在哈希冲突时才加锁
//  迭代器     | 快速失败（Fail-Fast），需手动同步	| 弱一致性，安全且高效
//  适用场景   | 几乎不推荐使用                      | 高并发环境的首选
//  —————————————————————————————————————————————————————————————————————————————————————
//  最佳实践：
//      首选：在任何需要高性能线程安全 Map 的场景下，都应优先选择 ConcurrentHashMap。
//      理解一致性：明确其迭代器是弱一致性的，不要在需要强一致性的迭代场景中使用它。
//      善用新API：多使用 computeIfAbsent, forEach, reduce 等原子方法和流式操作，它们是为并发环境量身打造的。
//      替代方案：对于读极多，写极少的场景，可以考虑 CopyOnWrite 风格的容器，但 ConcurrentHashMap 在大部分情况下都是最优解。
//
//


public class _02_ConcurrentHashMap {
    public static void main(String[] args) throws InterruptedException {


        // (1)创建ConcurrentHashMap
        //  p.s.该map的value为原子累加器LongAdder，用于原子计数
        ConcurrentHashMap<Integer, LongAdder> concurrentHashMap = new ConcurrentHashMap<>();


//        // (2)调用ConcurrentHashMap的常见方法
//        //  注意：①由于ConcurrentHashMap同样实现Map接口，因此具有Map的全部方法！
//        //       ②ConcurrentHashMap由JUC实现，因此其中一切方法均线程安全！
//        for (int i = 0; i < 10; i++) {
//            concurrentHashMap.put(i, new LongAdder());
//        }
//        for (int key : concurrentHashMap.keySet()) {
//            System.out.println(key + " : " + concurrentHashMap.get(key));
//        }


        // (3)创建多个线程，并发访问ConcurrentHashMap
        ExecutorService threadPool = Executors.newFixedThreadPool(300);
        HashSet<Callable<Object>> tasks = new HashSet<>(10000);
        for (int i = 0; i < 10000; i++) {
            tasks.add(() -> {
                for (int j = 0; j < 1000; j++) {
                    int key = getRandom0To9();
                    // computeIfAbsent：若key不存在，则将k-v创建并添加到map中，并返回value。（整个过程线程安全）
                    LongAdder longAdder = concurrentHashMap.computeIfAbsent(key, k -> new LongAdder());
                    longAdder.increment();
                }
                return null;
            });
        }
        threadPool.invokeAll(tasks);


        // (4)统计map中结果是否正确（是否发生线程安全问题）
        long count = 0;
        for (Integer key : concurrentHashMap.keySet()) {
            long value = concurrentHashMap.get(key).longValue();
            count += value;
            System.out.println(key + " : " + value);
        }
        System.out.println("总共次数：" + count);


    }


    public static int getRandom0To9() {
        return (int) (Math.random() * 10);
    }
}
