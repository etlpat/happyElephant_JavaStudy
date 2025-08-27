package com._05_concurrentUtils._01_threadPool;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;


// 线程池——ThreadPoolExecutor
//
//
// 1.线程池的继承体系图
//              ——————————> ①ExecutorService(接口) <——————————
//              |                                           |
//              |                                           |
//  ②ScheduledExecutorService(接口)                ③ThreadPoolExecutor(类)
//              ↑                                           ↑
//              |                                           |
//              ——————— ④ScheduledThreadPoolExecutor(类) ————
//
//
//
// 2.线程池相关API介绍
//  ①ExecutorService接口:
//      ExecutorService 是 Java 并发编程中线程池的核心接口。
//      它扩展了基础的 Executor 接口，提供了更强大、更灵活的生命周期管理方法和任务跟踪能力。
//      它代表了一个异步任务执行引擎，你只需提交任务 (Runnable 或 Callable)，它负责管理线程的执行、调度和回收。
//
//  ②ScheduledExecutorService接口:
//      ScheduledExecutorService 扩展了 ExecutorService 接口，专门用于处理定时和周期性任务。
//      它允许你安排任务在给定的延迟后运行，或者定期执行。
//
//  ③ThreadPoolExecutor类:
//      ThreadPoolExecutor 是 ExecutorService 接口的核心实现类。它提供了所有关于线程池的底层控制和高度可定制性。
//      如果你需要精细地控制线程池的行为（如线程创建策略、任务队列类型、拒绝策略等），就应该直接使用 ThreadPoolExecutor 的构造函数。
//      注意：Executors 工具类返回的各种线程池，本质上都是配置参数不同的 ThreadPoolExecutor 实例。
//      ——核心构造参数（七大参数）：
//          corePoolSize：核心线程数。即使线程空闲，也会保留在池中的线程数（除非设置了 allowCoreThreadTimeOut）。
//          maximumPoolSize：池中允许的最大线程数。
//          keepAliveTime：当线程数大于核心线程数时，多余的空闲线程在终止前等待新任务的最长时间。
//          unit：keepAliveTime 的时间单位。
//          workQueue：用于在任务执行前保存任务的队列（如 LinkedBlockingQueue, ArrayBlockingQueue, SynchronousQueue）。
//          threadFactory：执行程序创建新线程时使用的工厂（可以自定义线程名称、优先级等）。
//          handler：当线程和队列都已满时，用于处理新提交任务的拒绝策略（如抛出异常、丢弃任务、由调用者线程直接运行等）。
//      ——工作流程：
//          提交新任务。
//          如果 运行线程数 < corePoolSize，创建新线程执行任务。
//          否则，将任务放入 workQueue。
//          如果队列已满且 运行线程数 < maximumPoolSize，创建新线程执行任务。
//          如果队列已满且线程数已达最大值，则执行拒绝策略。
//
//  ④ScheduledThreadPoolExecutor类:
//      ScheduledThreadPoolExecutor 是 ThreadPoolExecutor 的子类，同时实现了 ScheduledExecutorService 接口。
//      它是支持定时和周期性任务的线程池实现。
//      它内部使用了一个特殊的数据结构（通常是DelayedWorkQueue，一种优先级队列）来管理需要延迟或定期执行的任务，确保任务能够按照预定的时间被执行。
//      ——与 ThreadPoolExecutor 的区别：
//          目的不同：ThreadPoolExecutor 用于处理大量并发任务，而 ScheduledThreadPoolExecutor 专用于调度任务。
//          队列不同：ThreadPoolExecutor 使用普通阻塞队列（如 LinkedBlockingQueue），而 ScheduledThreadPoolExecutor 使用 DelayedWorkQueue，任务按延迟时间排序。
//          执行策略：ScheduledThreadPoolExecutor 重写了 ThreadPoolExecutor 的任务提交和执行逻辑，以支持延迟和周期性触发。
//
//
//
// 3.线程池的状态
//  ThreadPoolExecutor使用int的高3位来表示线程池状态,低29位表示线程数量。
//  （这些信息存储在一个原子变量ctl中,目的是将线程池状态与线程个数合二为一,这样就可以用一次cas原子操作进行赋值）
//  ————————————————————————————————————————————————————————————————————————————————————————
//  | 状态名         | 高3位  | 接收新任务  | 处理阻塞队列任务  | 说明
//  ————————————————————————————————————————————————————————————————————————————————————————
//  | RUNNING       | 111   | Y         | Y             | 正常运行状态
//  | SHUTDOWN      | 000   | N         | Y             | 不会接收新任务,但会处理阻塞队列剩余任务
//  | STOP          | 001   | N         | N             | 会中断正在执行的任务,并抛弃阻塞队列任务
//  | TIDYING       | 010   | -         | -             | 任务全执行完毕,活动线程为0即将进入终结
//  | TERMINATED    | 011   | -         | -             | 终结状态
//  ————————————————————————————————————————————————————————————————————————————————————————
//  从数字上比较,TERMINATED > TIDYING > STOP > SHUTDOWN > RUNNING
//
//
//
// 4.ThreadPoolExecutor的构造方法
//  ThreadPoolExecutor(int corePoolSize,
//                     int maximumPoolSize,
//                     long keepAliveTime,
//                     TimeUnit unit,
//                     BlockingQueue<Runnable> workQueue,
//                     ThreadFactory threadFactory,
//                     RejectedExecutionHandler handler) {...}
//  参数功能：
//      ■ corePoolSize：核心线程数目(最多保留的线程数)
//      ■ maximumPoolSize：最大线程数目
//      ■ keepAliveTime：生存时间-针对救急线程
//      ■ unit：时间单位-针对救急线程
//      ■ workQueue：任务阻塞队列
//      ■ threadFactory：线程工厂-可以为线程创建时起个好名字
//      ■ handler：拒绝策略
//
//
//
// 5.Executors工具类
//  注意：Executors 工具类返回的各种线程池，本质上都是配置参数不同的 ThreadPoolExecutor 实例。
//  ①newFixedThreadPool（固定大小线程池）
//      ■ 核心线程数 == 最大线程数(没有救急线程被创建),因此也无需超时时间
//      ■ 阻塞队列是无界的,可以放任意数量的任务
//      评价：适用于任务量已知,相对耗时的任务
//
//  ②newCachedThreadPool（带缓冲线程池）
//      ■ 核心线程数是0,最大线程数是Integer.MAX_VALUE,救急线程的空闲生存时间是60s,意味着：
//          ——全部都是救急线程(60s后可以回收)
//          ——救急线程可以无限创建
//      ■ 队列采用了SynchronousQueue实现特点是,它没有容量,没有线程来取是放不进去的(一手交钱、一手交货)
//      评价：整个线程池表现为线程数会根据任务量不断增长,没有上限,当任务执行完毕,空闲1分钟后释放线程。
//           适合任务数比较密集,但每个任务执行时间较短的情况
//
//  ③newSingleThreadExecutor（单线程线程池）
//      使用场景：希望多个任务排队执行。线程数固定为1,任务数多于1时,会放入无界队列排队。任务执行完毕,这唯一的线程也不会被释放。
//      和普通线程的区别：自己创建一个单线程串行执行任务,如果任务执行失败而终止那么没有任何补救措施,而线程池还会新建一个线程,保证池的正常工作。
//
//
//
// 6.ThreadPoolExecutor提交任务的方法
//  ①执行任务
//      void execute(Runnable command);
//
//  ②提交任务 task,用返回值 Future 获得任务执行结果
//      <T> Future<T> submit(Callable<T> task);
//
//  ③提交 tasks 中所有任务（可设超时时间）
//      <T> List<Future<T>> invokeAll(Collection <? extends Callable<T>> tasks);
//      <T> List<Future<T>> invokeAll(Collection <? extends Callable<T>> tasks, long timeout, TimeUnit unit);
//
//  ④提交 tasks 中所有任务,哪个任务先成功执行完毕,返回此任务执行结果,其它任务取消（可设超时时间）
//      <T> T invokeAny(Collection <? extends Callable<T>> tasks);
//      <T> T invokeAny(Collection <? extends Callable<T>> tasks, long timeout, TimeUnit unit);
//
//
//
// 7.关闭线程池
//  ①void shutdown();
//      ——线程池状态变为 SHUTDOWN，不会接收新任务，但已提交任务会执行完。
//      ——此方法不会阻塞调用线程的执行。
//
//  ②List<Runnable> shutdownNow();
//      ——线程池状态变为 STOP，不会接收新任务，会将队列中的任务返回。
//      ——会用 interrupt 的方式中断正在执行的任务。
//
//


public class _02_threadPoolExecutor {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // (1)Executors工具类创建线程池
        //  ①newFixedThreadPool（固定大小线程池）
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
//        testPoolExecute(fixedThreadPool, 10);

        //  ②newCachedThreadPool（带缓冲线程池）
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
//        testPoolExecute(cachedThreadPool, 10);

        //  ③newSingleThreadExecutor（单线程线程池）
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
//        testPoolExecute(singleThreadExecutor, 10);


        // (2)提交任务的方法
        //  ①execute执行任务
        fixedThreadPool.execute(() -> System.out.println("hello world 111"));

        //  ②submit提交，并用future接收返回结果
        Future<String> future = fixedThreadPool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "hello world 222";
            }
        });
        System.out.println(future.get());

        //  ③执行全部任务
        List<Future<String>> futures = fixedThreadPool.invokeAll(Arrays.asList(
                () -> "hello world 333",
                () -> "hello world 444",
                () -> "hello world 555"
        ));
        for (Future<String> future1 : futures) {
            System.out.println(future1.get());
        }

        //  ④执行任务集合中最先成功的任务，并将其它取消
        String res = fixedThreadPool.invokeAny(Arrays.asList(
                () -> "hello world 666",
                () -> "hello world 777",
                () -> "hello world 888"
        ));
        System.out.println(res);


        // (3)关闭线程池
        //  ①SHUTDOWN关闭
        fixedThreadPool.shutdown();

        //  ②STOP关闭
        cachedThreadPool.shutdownNow();
        singleThreadExecutor.shutdownNow();

    }


    // 测试线程池的任务执行
    public static void testPoolExecute(ExecutorService pool, int taskNum) {
        for (int i = 1; i <= taskNum; i++) {
            int finalI = i;
            pool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "：hello" + finalI);
            });
        }
    }
}
