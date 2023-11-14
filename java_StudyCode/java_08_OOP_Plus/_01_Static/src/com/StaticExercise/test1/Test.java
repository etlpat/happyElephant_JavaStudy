package com.StaticExercise.test1;

// 例题1：问下面代码输出什么？
// 思路：一个类的不同对象共享同一个静态属性

public class Test {
    static int count = 9;

    public void count(){
        System.out.println(count++);
    }

    public static void main(String[] args) {
        new Test().count();// 9
        new Test().count();// 10
        System.out.println(Test.count);// 11
    }
}
