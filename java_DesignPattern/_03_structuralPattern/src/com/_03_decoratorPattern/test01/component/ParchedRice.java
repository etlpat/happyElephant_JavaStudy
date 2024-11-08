package com._03_decoratorPattern.test01.component;

// 具体构件：炒米

public class ParchedRice implements FastFood {
    @Override
    public void cook() {
        System.out.println("制作炒米~~");
    }
}
