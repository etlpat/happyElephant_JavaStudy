package com._03_factoryPattern.test01;

//  具体工厂(ConcreteFactory):主要是实现抽象工厂中的抽象方法,完成具体产品的创建。

public class AmericanCoffeeFactory extends AbstractCoffeeFactory {
    @Override
    public AbstractCoffee createCoffee() {
        AmericanCoffee americanCoffee = new AmericanCoffee();
        americanCoffee.addMilk();
        americanCoffee.addSugar();
        return americanCoffee;
    }
}
