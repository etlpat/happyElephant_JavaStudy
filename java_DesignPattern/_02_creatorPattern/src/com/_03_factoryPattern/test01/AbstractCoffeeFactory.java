package com._03_factoryPattern.test01;

// 抽象工厂(Abstract Factory):提供了创建产品的接口,调用者通过它访问具体工厂的工厂方法来创建产品。

public abstract class AbstractCoffeeFactory {
    public abstract AbstractCoffee createCoffee();
}
