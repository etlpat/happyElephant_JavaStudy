package com._02_monitor._02_waitAndNotify;

import java.util.HashSet;
import java.util.LinkedList;


// 使用wait和notify，实现“生产者-消费者”模式
public class _03_producerConsumerModel {
    public static void main(String[] args) {
        HashSet<Thread> producer = new HashSet<>();// 生产者线程集合
        HashSet<Thread> consumer = new HashSet<>();// 消费者线程集合
        MessageQueue messageQueue = new MessageQueue(2);

        // 添加生产者线程
        for (int i = 0; i < 4; i++) {
            int finalI = i + 1;
            producer.add(new Thread(() -> {
                try {
                    while (true) {
                        Thread.sleep(getRandom1000To3000());
                        System.out.println("生产者" + finalI + "：准备发送消息");
                        Message message = new Message();
                        messageQueue.put(message);
                        System.out.println("生产者" + finalI + "：成功发送消息 " + message);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }));
        }

        // 添加消费者线程
        for (int i = 0; i < 4; i++) {
            int finalI = i + 1;
            consumer.add(new Thread(() -> {
                try {
                    while (true) {
                        Thread.sleep(getRandom1000To3000());
                        System.out.println("消费者" + finalI + "：准备接收消息");
                        Message message = messageQueue.take();
                        System.out.println("消费者" + finalI + "：成功接收消息 " + message);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }));
        }

        // 开启全部线程，模拟生产者、消费者的流程
        producer.forEach(Thread::start);
        consumer.forEach(Thread::start);

    }


    // 获取1000-3000的随机数
    public static int getRandom1000To3000() {
        return (int) (Math.random() * 2001) + 1000;
    }
}


// 用于保存信息的消息队列
class MessageQueue {
    // 规定：头删、尾插
    private LinkedList<Message> queue = new LinkedList<>();
    private int maxSize = 10;

    public MessageQueue() {
    }

    public MessageQueue(int maxSize) {
        if (maxSize <= 0) {
            maxSize = 1;
        }
        this.maxSize = maxSize;
    }

    // 存放信息（若队列已满，则阻塞等待，直到队列不满再插入信息）
    public void put(Message msg) throws InterruptedException {
        synchronized (queue) {
            while (queue.size() >= maxSize) {
                System.out.println("put阻塞等待...");
                queue.wait();
            }
            queue.addLast(msg);
            queue.notifyAll();// 插入后唤醒全部线程，使其获取信息
            System.out.println("队列size：" + (size() - 1) + "->" + size());
        }
    }

    // 获取信息（若无信息，则阻塞等待，直到队列中有信息再返回）
    public Message take() throws InterruptedException {
        synchronized (queue) {
            while (queue.isEmpty()) {
                System.out.println("take阻塞等待...");
                queue.wait();
            }
            Message msg = queue.removeFirst();
            queue.notifyAll();// 删除后唤醒全部线程，使其存放信息
            System.out.println("队列size：" + (size() + 1) + "->" + size());
            return msg;
        }
    }

    public int size() {
        return queue.size();
    }
}


// 信息对象
final class Message {
    private static int count = 1;
    private int id;
    private String msg;

    public Message() {
        id = count++;
        msg = "这是一段消息" + id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                '}';
    }
}



