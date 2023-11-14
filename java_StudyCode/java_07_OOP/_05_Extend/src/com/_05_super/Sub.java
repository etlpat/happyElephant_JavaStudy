package com._05_super;

/**
 *  Sub是Base的子类
 *  用于演示super关键字的使用
 */

public class Sub extends Base{
    // 1.super访问父类构造器
    public Sub() {
        super();// 默认
    }
    public Sub(int n1, int n2, int n3, int n4) {
        super(n1, n2, n3, n4);
    }

    // 2.super访问父类属性
    public void callVar() {
        super.n1 = 1;
        super.n2 = 2;
        super.n3 = 3;
        //super.n4 = 4;// 报错，private
    }

    // 3.super访问父类方法
    public void callFunc() {
        super.func1();
        super.func2();
        super.func3();
        //super.func4();// 报错，private
    }
}
