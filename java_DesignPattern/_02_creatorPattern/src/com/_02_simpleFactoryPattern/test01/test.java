package com._02_simpleFactoryPattern.test01;

public class test {
    public static void main(String[] args) {
        // 创建咖啡工厂（简单工厂模式）
        SimpleCoffeeFactory simpleCoffeeFactory = new SimpleCoffeeFactory();


        // 通过简单工厂创建对象
        AbstractCoffee americanCoffee = simpleCoffeeFactory.createCoffee("AmericanCoffee");
        System.out.println(americanCoffee.getName() + ":" + americanCoffee.getClass());
        System.out.println("==========================");

        AbstractCoffee latteCoffee = simpleCoffeeFactory.createCoffee("LatteCoffee");
        System.out.println(latteCoffee.getName() + ":" + latteCoffee.getClass());
        System.out.println("==========================");

        simpleCoffeeFactory.createCoffee("某咖啡");// 抛出异常
    }
}
