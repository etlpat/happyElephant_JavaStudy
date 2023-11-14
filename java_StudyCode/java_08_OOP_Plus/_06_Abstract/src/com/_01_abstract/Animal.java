package com._01_abstract;

// 抽象类：抽象类不能实例化
// 有抽象方法的类必须被声明为抽象类，但是抽象类也可以不包含抽象方法


// 抽象类
public abstract class Animal {
    private String name;

    public Animal() {
    }

    public Animal(String name) {
        this.name = name;
    }

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

    // 抽象方法：只有声明，没有实现
    public abstract void eat();

    // 抽象方法
    public abstract void sleep();

}
