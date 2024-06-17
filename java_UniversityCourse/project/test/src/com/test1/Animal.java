package com.test1;

public class Animal {
    public String name = "Animal";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }

    public void animalEat() {
        System.out.println("Animal方法");
    }
}
