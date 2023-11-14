package com._02_finalDetail;

// final类只是不能被继承，但是仍然可以正常被实例化
// final方法只是不能被重写，但是仍然可以正常被继承


class A {
    public static final int COUNT = 114514;
    public final int NUM;

    public A(int NUM) {
        this.NUM = NUM;
    }

    public final int getNUM() {
        return NUM;
    }

    public final int getCount() {
        return COUNT;
    }
}


final class B extends A {
    public B(int NUM) {
        super(NUM);
    }
}


public class Test01 {
    public static void main(String[] args) {
        // final类可以正常实例化对象
        B b = new B(1919810);

        // final常量属性可以被子类继承
        System.out.println(B.COUNT);// 114514
        System.out.println(b.NUM);// 1919810

        // final方法可以被子类继承
        System.out.println(b.getCount());// 114514
        System.out.println(b.getNUM());// 1919810
    }
}
