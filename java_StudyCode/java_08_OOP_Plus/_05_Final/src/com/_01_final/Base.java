package com._01_final;

public class Base {
    // (1)final修饰的方法不能被重写（但是可以被重载）
    public final void func() {
    }

    public void func(int a) {// 可以重载final方法
    }


    // (2)final将变量修饰为常量
    public final int COUNT = 1;// 不允许变的值，建议用大写字母和下划线命名

    public void test() {
//        COUNT = 2;// 报错，final修饰的变量不能被修改

        final double NUM = 0;
//        NUM = 1;// 报错
    }
}
