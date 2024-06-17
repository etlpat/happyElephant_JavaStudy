package com.test1;

public class Test {
    public static void main(String[] args) {
        Animal a = new SmallDog();
        Dog b = (Dog) a;
        SmallDog c = (SmallDog) a;

        // 属性不动态绑定
        System.out.println(a.name);// Animal
        System.out.println(b.name);// Dog
        System.out.println(c.name);// SmallDog

        // 方法动态绑定
        System.out.println(a.getName());// SmallDog

        // 只能执行编译类型允许的方法
        System.out.println("============");
        a.animalEat();
        b.dogEat();
        b.animalEat();
        c.smallDogEat();
        c.dogEat();
        c.animalEat();
        // 实际执行类似是运行类型
        System.out.println("============");
        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(c.toString());

        // 向下转型
        ((SmallDog) a).smallDogEat();


    }
}