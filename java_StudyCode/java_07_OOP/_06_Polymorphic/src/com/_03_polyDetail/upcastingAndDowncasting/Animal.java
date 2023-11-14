package com._03_polyDetail.upcastingAndDowncasting;

public class Animal {
    private String name;

    // 构造方法
    public Animal() {
    }

    public Animal(String name) {
        this.name = name;
    }

    public void cry() {
        System.out.println("Animal在叫唤...");
    }

    private void sleep() {
        System.out.println("Animal睡觉...");
    }

    public void enjoy() {
    }

    // get、set方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
