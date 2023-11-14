package com._03_codeBlockExercise.test01;

// 例题1：问下面代码输出什么
// 思路：静态成员在类加载时初始化/调用，且仅有一次

public class Test {
    public static void main(String[] args) {
        System.out.println(Person.total);
        //in static block!
        //100

        System.out.println(Person.total);
        //100
    }
}
