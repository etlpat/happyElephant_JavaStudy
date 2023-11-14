package com._01_abstract;

public class Dog extends Animal {
    public Dog() {
    }

    public Dog(String name) {
        super(name);
    }

    // 子类必须重写父类中所有抽象方法才能实例化
    @Override
    public void eat() {
        if (getName() == null) {
            System.out.println("小狗吃骨头");
            return;
        }
        System.out.println("小狗" + getName() + " 吃骨头");
    }

    @Override
    public void sleep() {
        if (getName() == null) {
            System.out.println("小狗睡觉");
            return;
        }
        System.out.println("小狗" + getName() + " 睡觉");
    }


}
