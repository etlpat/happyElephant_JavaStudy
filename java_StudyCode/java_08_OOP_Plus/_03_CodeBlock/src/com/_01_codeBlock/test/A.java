package com._01_codeBlock.test;

public class A {
    {
        System.out.println("A类普通代码块");
    }

    public A() {
        // super();
        // 调用本类代码块...
        System.out.println("A类构造器");
    }
}
