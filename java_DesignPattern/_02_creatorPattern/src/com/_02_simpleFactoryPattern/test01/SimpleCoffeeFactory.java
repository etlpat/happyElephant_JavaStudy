package com._02_simpleFactoryPattern.test01;

public class SimpleCoffeeFactory {
    public AbstractCoffee createCoffee(String coffeeType) {
        AbstractCoffee coffee = null;

        if (coffeeType.equals("AmericanCoffee")) {
            coffee = new AmericanCoffee();
        } else if (coffeeType.equals("LatteCoffee")) {
            coffee = new LatteCoffee();
        } else {
            throw new RuntimeException("没有这种咖啡");
        }

        coffee.addMilk();
        coffee.addSugar();
        return coffee;
    }
}
