package com._07_polyParameter;

public class Worker extends Employee {
    public Worker() {
    }

    public Worker(String name, double salary) {
        super(name, salary);
    }

    // 新增
    public void work() {
        System.out.println("Worker" + getName() + " 在工作...");
    }
}
