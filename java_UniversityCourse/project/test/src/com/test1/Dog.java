package com.test1;

public class Dog extends Animal {
    public String name = "Dog";

    public void dogEat() {
        System.out.println("Dog方法");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
