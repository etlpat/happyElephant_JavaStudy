package com._03_factoryPattern.test01;

public class test {
    public static void main(String[] args) {
        // (1)创建具体工厂类
        AmericanCoffeeFactory americanCoffeeFactory = new AmericanCoffeeFactory();
        LatteCoffeeFactory latteCoffeeFactory = new LatteCoffeeFactory();


        // (2)通过具体工厂类创建对应的对象
        AmericanCoffee americanCoffee = (AmericanCoffee) americanCoffeeFactory.createCoffee();
        System.out.println(americanCoffee.getName() + ":" + americanCoffee.getClass());
        System.out.println("==================");

        LatteCoffee latteCoffee = (LatteCoffee) latteCoffeeFactory.createCoffee();
        System.out.println(latteCoffee.getName() + ":" + latteCoffee.getClass());

    }
}
