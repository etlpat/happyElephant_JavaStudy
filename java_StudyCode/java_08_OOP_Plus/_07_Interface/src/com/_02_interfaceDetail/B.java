package com._02_interfaceDetail;

// 抽象类实现接口，不必将接口中的抽象方法全部重写

public abstract class B implements Interface01 {
    @Override
    public void func1() {
        System.out.println("A类实现Interface01接口func1");
    }

    // 这里没有重写抽象方法func2()
}
