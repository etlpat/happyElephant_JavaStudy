package com._01_abstract.test01;

public class Test {
    public static void main(String[] args) {
        // 即使抽象类中没有抽象方法，也不能实例化
        //new A();// 报错

        new B().func();// func方法被调用
    }
}
