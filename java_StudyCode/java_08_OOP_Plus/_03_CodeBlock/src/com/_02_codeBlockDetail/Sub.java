package com._02_codeBlockDetail;

public class Sub extends Base {
    private static int s1 = initS1();

    static {
        System.out.println("Sub类静态代码块");
    }

    private static int s2 = initS2();

    private int s3 = initS3();

    {
        System.out.println("Sub类非静态代码块");
    }

    private int s4 = initS4();


    // 构造器
    public Sub() {
        System.out.println("Sub类构造器");
    }


    public static int initS1() {
        System.out.println("静态属性s1被赋初值");
        return 100;
    }

    public static int initS2() {
        System.out.println("静态属性s2被赋初值");
        return 200;
    }

    public int initS3() {
        System.out.println("普通属性s3被赋初值");
        return 300;
    }

    public int initS4() {
        System.out.println("普通属性s4被赋初值");
        return 400;
    }
}
