package com._01_interface.test02;

public interface TestInterface {
    // 1.属性
    public int n1 = 10;
    public static final int n2 = 20;

    // 2.方法
    public void func1();// 接口中抽象方法可省略abstract关键字

    public abstract void func2();// 抽象方法

    default public void func3() {// 默认实现的方法
    }

    public static void func4() {// 静态方法
    }

}
