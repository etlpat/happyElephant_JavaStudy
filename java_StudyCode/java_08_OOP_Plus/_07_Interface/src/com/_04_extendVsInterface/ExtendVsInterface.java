// 类的继承和接口的实现
//
// (1)概念
//  Java中，接口的实现，可以看作是对java的类只能单继承的一种补充
//  子类继承父类：子类可以继承父类中的属性和方法，子类可以看作是父类的拓展
//  子类实现接口：子类可以实现接口中规定的操作，进而拓展出更多的功能
//
//
// (2)语法
// （子类可以继承父类的同时，实现多个接口）
//  语法：public class B extends A implements IA, IB, IC {...}
//
//
// (3)注意事项
//  1.继承和接口的优点
//    继承的价值在于：增加代码的复用性和可维护性
//    接口的价值在于：设计好规范，增加代码的拓展性
//
//  2.接口比继承更灵活
//    继承需要满足 is-a 关系
//    接口需要满足 like-a 关系
//
//  3.接口在一定程度上实现代码解耦
//    即：接口的规范性 + 动态绑定机制 = 解耦(?)




package com._04_extendVsInterface;

public class ExtendVsInterface {
    public static void main(String[] args) {
        LittleMonkey littleMonkey = new LittleMonkey("孙悟空");

        littleMonkey.climbTree();// 小猴子孙悟空 会爬树!
        littleMonkey.swim();// 小猴子孙悟空 会游泳!
        littleMonkey.fly();// 小猴子孙悟空 会飞行!
    }
}
