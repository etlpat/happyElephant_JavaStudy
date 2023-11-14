package com.StaticExercise.test2;

// 例题2：问下面代码输出什么？

public class Test {
    public static void main(String[] args) {
        System.out.println(Person.getTotal());// 0
        new Person();
        System.out.println(Person.getTotal());// 1
        Person.setTotal(15);
        new Person();
        System.out.println(Person.getTotal());// 16
    }
}
