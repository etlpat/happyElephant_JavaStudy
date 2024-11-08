package com._02_adapterPattern.test02;

public class Adapter implements Robot {
    private Dog dog = new Dog();

    @Override
    public void cry() {
        System.out.print("机器人模仿吼叫：");
        dog.wang();
    }

    @Override
    public void move() {
        System.out.print("机器人模仿移动：");
        dog.run();
    }
}
