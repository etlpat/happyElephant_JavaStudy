package com.test01;

import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println("Hello World");

        System.out.println(Test01.func("abcdef"));

        Animal animal = new Dog();
        System.out.println(animal.name);
        System.out.println(animal.getName());
    }

    public static String func(String str) {
        if (str.length() == 0) return "";
        return str.charAt(str.length() - 1) + func(str.substring(0, str.length() - 1));
    }
}


class Animal {
    String name = "animal";

    public String getName() {
        return name;
    }
}


class Dog extends Animal {
    String name = "dog";

    @Override
    public String getName() {
        return name;
    }
}