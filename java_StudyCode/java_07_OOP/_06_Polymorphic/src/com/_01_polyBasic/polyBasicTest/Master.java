package com._01_polyBasic.polyBasicTest;

public class Master {
    private String name;

    public Master() {
    }

    public Master(String name) {
        this.name = name;
    }

    // 方法的多态(重载)
    public void feed1(Cat cat, Fish fish) {
        System.out.println(getName() + "喂小猫 " + cat.getName() + " 吃" + fish.getName());
    }
    public void feed1(Dog dog, Bone bone) {
        System.out.println(getName() + "喂小狗 " + dog.getName() + " 吃" + bone.getName());
    }

    // 对象的多态
    // 参数animal：编译类型是Animal，可以接收Animal或其子类对象
    // 参数food：编译类型是Food，可以接收Food及其子类对象
    public void feed2(Animal animal, Food food) {
        System.out.println(getName() + "喂 " + animal.getName() + " 吃" + food.getName());
    }

    // get、set方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
