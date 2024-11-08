package com._02_adapterPattern.test02;

// 实例:
//  现需要设计一个可以模拟各种动物行为的机器人,在机器人中定义了一系列方法,如机器人叫喊方法cry()、机器人移动方法move()等。
//  如果希望在不修改已有代码的基础上使得机器人能够像狗一样叫wang(),像狗一样跑run(),可以使用适配器模式进行系统设计。
//
// 案例分析：
//  目标接口-Robot；适配者-Dog；
//  适配器：继承机器人接口，在该接口的方法中，调用Dog的方法。

public class Test {
    public static void main(String[] args) {
        Adapter adapter = new Adapter();

        adapter.cry();
        adapter.move();
    }
}
