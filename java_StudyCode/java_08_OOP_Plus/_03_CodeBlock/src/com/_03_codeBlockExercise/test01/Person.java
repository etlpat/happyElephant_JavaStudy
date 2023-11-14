package com._03_codeBlockExercise.test01;

public class Person {
    public static int total;

    static {
        total = 100;
        System.out.println("in static block!");
    }
}
