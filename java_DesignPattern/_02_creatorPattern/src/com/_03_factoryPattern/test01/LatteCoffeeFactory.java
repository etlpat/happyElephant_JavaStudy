package com._03_factoryPattern.test01;

//  具体工厂(ConcreteFactory):主要是实现抽象工厂中的抽象方法,完成具体产品的创建。

public class LatteCoffeeFactory extends AbstractCoffeeFactory{
    @Override
    public AbstractCoffee createCoffee() {
        LatteCoffee latteCoffee = new LatteCoffee();
        latteCoffee.addMilk();
        latteCoffee.addSugar();
        return latteCoffee;
    }
}
