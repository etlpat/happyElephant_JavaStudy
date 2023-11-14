package com._02_polyObject;

public class Animal {
    private String name;

    public Animal() {
    }

    public Animal(String name) {
        this.name = name;
    }

    public void cry() {
        System.out.println("Animal类：动物 " + getName() + " 在叫唤...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

