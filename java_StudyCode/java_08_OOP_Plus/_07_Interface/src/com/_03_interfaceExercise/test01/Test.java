package com._03_interfaceExercise.test01;

// 案例1：分析以下语法是否正确
// 思路：接口中的属性，默认为public static final的

public class Test {
    public static void main(String[] args) {
        B b = new B();
        System.out.println(b.a);
        System.out.println(A.a);
        System.out.println(B.a);
    }
}
