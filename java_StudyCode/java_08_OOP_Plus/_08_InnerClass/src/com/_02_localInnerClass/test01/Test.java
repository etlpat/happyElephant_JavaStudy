package com._02_localInnerClass.test01;

// 外部类中的内部类对象可以直接访问内部类的private属性

public class Test {
    public static void main(String[] args) {
        Outer outer = new Outer("小王");

        outer.func();
        //内部inner
        //100
    }
}
