package com._03_decoratorPattern.test01.component;

// 具体构件：炒面

public class FriedNoodles implements FastFood {
    @Override
    public void cook() {
        System.out.println("制作炒面~~");
    }
}
