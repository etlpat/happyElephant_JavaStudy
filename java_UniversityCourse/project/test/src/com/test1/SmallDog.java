package com.test1;

public class SmallDog extends Dog {
    public String name = "SmallDog";

    public void smallDogEat() {
        System.out.println("smallDog方法");
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
        return "SmallDog{" +
                "name='" + name + '\'' +
                '}';
    }
}
