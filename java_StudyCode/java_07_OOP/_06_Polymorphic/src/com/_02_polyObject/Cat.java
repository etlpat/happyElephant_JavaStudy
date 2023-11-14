package com._02_polyObject;

public class Cat extends Animal {
    public Cat() {
    }

    public Cat(String name) {
        super(name);
    }

    public void cry() {
        System.out.println("Cat类：小猫 " + getName() + " 喵喵叫...");
    }
}
