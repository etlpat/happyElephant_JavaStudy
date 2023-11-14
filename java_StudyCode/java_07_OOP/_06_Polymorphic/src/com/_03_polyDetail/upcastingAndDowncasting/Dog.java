package com._03_polyDetail.upcastingAndDowncasting;

public class Dog extends Animal {
    public int id;

    public Dog(String name, int id) {
        super(name);
        this.id = id;
    }

    public Dog() {
    }

    // 重写父类方法
    public void cry() {
        System.out.println("Dog在叫唤...");
    }

    // 重写
    public void sleep() {
        System.out.println("Dog睡觉...");
    }

    // 重写
    public void enjoy() {
        // 调用子类新增的成员
        eatBone();
        sleep();
        System.out.println("Dog" + getName() + "“" + id + "” 很享受");
    }

    // 新增方法
    public void eatBone() {
        System.out.println("Dog吃骨头...");
    }
}
