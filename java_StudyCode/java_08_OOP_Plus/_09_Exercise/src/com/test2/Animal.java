package com.test2;

public abstract class Animal {
    public String name;

    public Animal() {
    }

    public Animal(String name) {
        this.name = name;
    }

    public abstract void shout();
}
