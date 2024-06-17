package com._03_ThreadSafeProblem;

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

    public boolean drawMoney(int money) throws Exception {
        if (count >= money) {
            Thread.sleep(500);
            count -= money;
            return true;
        }
        return false;
    }
}
