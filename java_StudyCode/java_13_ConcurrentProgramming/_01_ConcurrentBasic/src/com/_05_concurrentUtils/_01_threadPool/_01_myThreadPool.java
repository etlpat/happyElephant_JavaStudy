package com._05_concurrentUtils._01_threadPool;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


// 自定义线程池
public class _01_myThreadPool {
    public static void main(String[] args) throws InterruptedException {
        // 创建线程池
        // （参数：池中最多2个线程；线程超时等待1s无任务则销毁；任务阻塞队列最多容纳4个任务）
        myThreadPool pool = new myThreadPool(2, 1, TimeUnit.SECONDS, 4);

        // 使线程池创建线程执行任务
        for (int i = 1; i <= 12; i++) {
            int finalI = i;
            pool.execute(() -> {
                System.out.println("" + finalI + finalI + finalI);
            });
//            Thread.sleep(500);
        }
    }
}


// (1)自定义阻塞队列
class myBlockingQueue<T> {
    // 1.任务队列（头删尾插）
    private Deque<T> deque = new ArrayDeque<>();

    // 2.锁
    private ReentrantLock lock = new ReentrantLock();

    // 3.生产者条件变量
    private Condition fullWaitSet = lock.newCondition();

    // 4.消费者条件变量
    private Condition emptyWaitSet = lock.newCondition();

    // 5.容量
    private int capacity;

    public myBlockingQueue(int capacity) {
        this.capacity = capacity;
    }


    // 阻塞获取（消费者）
    public T take(long timeout, TimeUnit unit) {
        lock.lock();// 上锁
        try {
            // 获取最长等待时间(纳秒)
            long nanos = unit.toNanos(timeout);
            // 若队列为空，则wait阻塞等待
            while (deque.isEmpty()) {
                if (nanos <= 0) {// 若时间不足，则退出
                    return null;
                }
                try {
                    // 使线程wait阻塞等待，设置最长等待时间，返回剩余等待时间
                    nanos = emptyWaitSet.awaitNanos(nanos);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            // 队列不为空，获取任务
            T t = deque.removeFirst();
            fullWaitSet.signal();// 唤醒生产者的等待集合
            return t;
        } finally {
            lock.unlock();// 解锁
        }
    }


    // 阻塞添加（生产者）
    public void put(T element) {
        lock.lock();// 上锁
        try {
            while (deque.size() >= capacity) {
                // 若队列已满，则wait阻塞等待
                try {
                    fullWaitSet.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            // 队列未满，添加任务
            deque.addLast(element);
            emptyWaitSet.signal();// 唤醒消费者的等待集合
        } finally {
            lock.unlock();// 解锁
        }
    }


    // 获取大小
    public int size() {
        lock.lock();
        try {
            return deque.size();
        } finally {
            lock.unlock();
        }
    }
}


// (2)自定义线程池
class myThreadPool {
    // 1.任务队列
    private myBlockingQueue<Runnable> taskQueue;

    // 2.线程集合
    private HashSet<Worker> workers = new HashSet<>();

    // 3.核心线程数
    private int coreSize;

    // 4.获取任务超时时间
    private long timeout;

    // 5.获取任务时间单位
    private TimeUnit unit;

    // 6.Worker类用于对Thread类进行封装
    class Worker extends Thread {
        private Runnable task;// 线程任务

        public Worker(Runnable task) {
            this.task = task;
        }

        @Override
        public void run() {
            // 执行任务
            //  1) 当task不为空，则直接执行任务
            //  2) 当task为空，则从阻塞队列中不断获取任务，并执行
            //  3) 当task和阻塞队列中都不存在任务，则退出循环并销毁该线程
            while (task != null || (task = taskQueue.take(timeout, unit)) != null) {
                try {
                    System.out.println("任务执行>>>" + task);
                    task.run();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    // 当本轮循环的task执行结束，则将其置为null
                    task = null;
                }
            }
            // 当阻塞队列中不存在任何task，则销毁该线程
            synchronized (workers) {
                System.out.println("从线程池中移除线程：" + this);
                workers.remove(this);
            }
        }
    }

    public myThreadPool(int coreSize, long timeout, TimeUnit unit, int taskQueueCapacity) {
        this.coreSize = coreSize;
        this.timeout = timeout;
        this.unit = unit;
        this.taskQueue = new myBlockingQueue<>(taskQueueCapacity);
    }


    // 执行任务
    public void execute(Runnable task) {
        synchronized (workers) {
            // 1.若线程池未满，则直接在池中创建任务对应的线程，并执行任务
            if (workers.size() < coreSize) {
                Worker worker = new Worker(task);// 创建任务对应的线程
                workers.add(worker);// 加入线程集合
                System.out.println("向线程池中添加新线程：" + worker + ">>>" + task);
                worker.start();// 开启线程
            } else {
                // 2.若线程池已满，则将任务加入阻塞队列中
                System.out.println("向任务阻塞队列中添加新任务：" + task);
                taskQueue.put(task);
            }
        }
    }
}