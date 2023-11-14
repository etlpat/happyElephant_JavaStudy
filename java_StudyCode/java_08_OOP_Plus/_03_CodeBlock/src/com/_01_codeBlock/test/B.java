package com._01_codeBlock.test;

public class B extends A {
    {
        System.out.println("B类普通代码块");
    }

    public B() {
        // super();
        // 调用本类代码块...
        System.out.println("B类构造器");
    }
}
