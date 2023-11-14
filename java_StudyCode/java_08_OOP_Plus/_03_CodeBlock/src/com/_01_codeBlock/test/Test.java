package com._01_codeBlock.test;

// 【非静态代码块可以看作构造器的拓展】
//  构造器，在最前面隐含了 ①super() 和 ②调用普通代码块
//  实际执行中：先调用父类构造器，再调用子类普通代码块，最后调用子类构造器
//  e.g.
//  class A {
//      public A() {
//          super();
//          //调用普通代码块
//          System.out,println("A类构造器调用");
//      }
//  }


public class Test {
    public static void main(String[] args) {
        new B();
//        A类普通代码块
//        A类构造器
//        B类普通代码块
//        B类构造器
    }
}
