package com._02_interfaceDetail.test02;

// 一个接口可以继承多个接口
// 由于interface接口继承了IA,IB,IC，因此若某个类想实现interface，必须实现interface中新增的抽象方法，和IA,IB,IC继承的抽象方法

public interface InterfaceTest extends IA, IB, IC {
    void funcIF();
}
