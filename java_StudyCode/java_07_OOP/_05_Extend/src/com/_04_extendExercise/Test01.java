package com._04_extendExercise;

// 案例1：
//  分析以下代码输出结果：
//  思路：new对象时，会自动调用构造器(若不传参，默认调用无参构造器)
//       调用子类构造器时，需要先调用父类构造器(若不显式调用，默认调用无参super())

public class Test01 {
    public static void main(String[] args) {
        C c = new C();
        // A无参构造器调用
        // B有参构造器调用
        // B无参构造器调用
        // C无参构造器调用
    }
}

class A {
    public A() {
        System.out.println("A无参构造器调用");
    }

    public A(String str) {
        System.out.println("A有参构造器调用");
    }
}

class B extends A {
    public B() {
        this("abc");
        System.out.println("B无参构造器调用");
    }

    public B(String str) {
        // 默认有 super();
        System.out.println("B有参构造器调用");
    }
}

class C extends B {
    public C() {
        // 默认有 super();
        System.out.println("C无参构造器调用");
    }
}
