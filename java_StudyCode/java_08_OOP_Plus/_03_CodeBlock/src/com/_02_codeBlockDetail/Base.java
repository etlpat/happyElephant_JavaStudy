package com._02_codeBlockDetail;

public class Base {
    private static int b1 = initB1();

    static {
        System.out.println("Base类静态代码块");
    }

    private static int b2 = initB2();

    private int b3 = initB3();

    {
        System.out.println("Base类非静态代码块");
    }

    private int b4 = initB4();


    // 构造器
    public Base() {
        System.out.println("Base类构造器");
    }


    public static int initB1() {
        System.out.println("静态属性b1被赋初值");
        return 10;
    }

    public static int initB2() {
        System.out.println("静态属性b2被赋初值");
        return 20;
    }

    public int initB3() {
        System.out.println("普通属性b3被赋初值");
        return 30;
    }

    public int initB4() {
        System.out.println("普通属性b4被赋初值");
        return 40;
    }
}
