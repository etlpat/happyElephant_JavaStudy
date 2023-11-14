package com._01_innerClass;

// java类的五大成员：属性、方法、构造器、代码块、内部类

public class Outer {
    private int num;// 属性

    {// 代码块
        System.out.println("代码块调用");
    }

    public Outer(int num) {// 构造器
        this.num = num;
    }

    public void func() {// 方法
        System.out.println("func方法调用");
    }

    class inner {// 内部类

    }
}
