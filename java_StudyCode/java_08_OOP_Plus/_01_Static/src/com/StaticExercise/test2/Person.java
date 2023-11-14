package com.StaticExercise.test2;

public class Person {
    private int id;
    private static int total = 0;

    public Person() {
        total++;// 每创建一个对象，total++
        id = total;
    }

    public static int getTotal(){
        return total;
    }

    public static void setTotal(int total){
        Person.total = total;
    }
}
