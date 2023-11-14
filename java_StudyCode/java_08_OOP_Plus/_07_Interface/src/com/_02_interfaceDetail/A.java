package com._02_interfaceDetail;

// A类实现Interface01接口
// A不是抽象类，因此必须实现接口中所有的抽象方法

public class A implements Interface01 {
    @Override
    public void func1() {
        System.out.println("A类实现Interface01接口func1");
    }

    @Override
    public void func2() {
        System.out.println("A类实现Interface01接口func2");
    }
}
