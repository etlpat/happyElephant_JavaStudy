package com._02_polyObject;

public class Dog extends Animal {
    public Dog() {
    }

    public Dog(String name) {
        super(name);
    }

    public void cry() {
        System.out.println("Dog类：小狗 " + getName() + " 汪汪叫...");
    }
}
