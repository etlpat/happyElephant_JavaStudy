package com._04_extendVsInterface;

// LittleMonkey类继承父类Monkey，并实现多个接口

public class LittleMonkey extends Monkey implements FlyAble, SwimAble {
    public LittleMonkey() {
    }

    public LittleMonkey(String name) {
        super(name);
    }

    // 重写父类方法
    @Override
    public void climbTree() {
        System.out.print("小");
        super.climbTree();
    }

    // 实现接口方法
    @Override
    public void fly() {
        System.out.println("小猴子" + getName() + " 会飞行!");
    }

    // 实现接口方法
    @Override
    public void swim() {
        System.out.println("小猴子" + getName() + " 会游泳!");
    }
}
