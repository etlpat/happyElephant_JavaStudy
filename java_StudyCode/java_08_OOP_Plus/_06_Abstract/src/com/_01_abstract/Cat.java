package com._01_abstract;

// 若子类没有重写完父类所有的抽象方法，子类也必须为抽象类
// 原因：若父类有抽象方法没被重写，子类就会继承到该抽象方法。


public abstract class Cat extends Animal {
    public Cat() {
    }

    public Cat(String name) {
        super(name);
    }

    @Override
    public void eat() {
        if (getName() == null) {
            System.out.println("小猫吃鱼");
            return;
        }
        System.out.println("小猫" + getName() + " 吃鱼");
    }
}
