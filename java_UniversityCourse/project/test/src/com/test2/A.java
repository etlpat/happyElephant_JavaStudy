package com.test2;

public abstract class A {
    public static int a = 1;
    public static int b;
    public int a1 = 10;
    public int b1;
    public int c1;

    {
        System.out.println("代码块执行");
        b1 = 20;
    }

    static {
        System.out.println("static代码块执行");
        b = 2;
    }

    public A() {
        c1 = 30;
    }

    public abstract void func();
}
