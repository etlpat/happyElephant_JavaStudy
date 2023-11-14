package com._04_memberInnerClass.test01;

public abstract class Animal {
    private String name;
    private int age;

    // 构造器
    public Animal() {
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // grt、set方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    // 抽象方法
    public abstract void eat();

    public abstract void sleep();
}
