package com._02_codeBlockDetail;

public class A1 {
    private static int num1 = initNum1();

    static {
        System.out.println("A1类static代码块被执行");
    }

    private static int num2 = initNum2();

    public A1() {
        System.out.println("A1类构造器调用");
    }


    public static int initNum1() {
        System.out.println("static属性num1被赋默认值");
        return 10;
    }

    public static int initNum2() {
        System.out.println("static属性num2被赋默认值");
        return 20;
    }
}
