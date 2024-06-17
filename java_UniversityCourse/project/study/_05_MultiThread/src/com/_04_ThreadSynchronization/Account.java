package com._04_ThreadSynchronization;

public class Account {
    private int count;

    public Account() {
    }

    public Account(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "账户中剩余：" + count + '元';
    }

    public int showCount() {
        return count;
    }

    public boolean drawMoney(int money) {
        if (count >= money) {
            try {
                Thread.sleep(500);
            } catch (Exception e) {// 捕获编译时异常，改为抛出运行时异常
                throw new RuntimeException();
            }
            count -= money;
            return true;
        }
        return false;
    }
}
