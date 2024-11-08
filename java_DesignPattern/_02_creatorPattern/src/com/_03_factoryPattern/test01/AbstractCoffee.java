package com._03_factoryPattern.test01;

public abstract class AbstractCoffee {
    public abstract String getName();

    public void addMilk() {
        System.out.println(getName() + "-添加牛奶");
    }

    public void addSugar() {
        System.out.println(getName() + "-添加糖");
    }
}
