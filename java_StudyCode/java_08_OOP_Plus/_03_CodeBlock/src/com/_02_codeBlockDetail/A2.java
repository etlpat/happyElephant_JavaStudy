package com._02_codeBlockDetail;

public class A2 {
    private int num1 = initNum1();

    {
        System.out.println("A2类代码块被执行");
    }

    private int num2 = initNum2();

    public A2() {
        System.out.println("A2类构造器调用");
    }


    public int initNum1() {
        System.out.println("属性num1被赋默认值");
        return 10;
    }

    public int initNum2() {
        System.out.println("属性num2被赋默认值");
        return 20;
    }
}
