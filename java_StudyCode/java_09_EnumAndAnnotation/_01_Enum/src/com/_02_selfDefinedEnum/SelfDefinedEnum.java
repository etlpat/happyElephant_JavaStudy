package com._02_selfDefinedEnum;

// 自定义枚举类型
//
// (1)实现思路
//  枚举对象固定不变，且不能随意增删
//  自定义枚举，思路类似(饿汉式)单例设计模式，对象只能在类内被创建，保证对象的个数和名称固定不变
//  并且，将对象设置为final常量，且不提供set方法，保证对象的值固定不变
//
//
// (2)实现步骤
//  1.将类的构造器私有化，防止在类外创建对象
//  2.在类的内部，创建固定的对象（建议将枚举对象设置为static+final的静态常量）
//  3.不能设置set方法，枚举对象只读，不可修改
//
//
// (3)注意事项
//  1.与单例设计模式不同的是，单例模式只有一个对象，一般将其设置为private，并通过getInstance获取对象
//    而枚举的对象一般有多个，因此一般将其直接设置为public，可以直接通过类名访问
//  2.枚举对象用static+final修饰，不仅可以将枚举对象声明为静态常量，而且还能实现底层优化
//  3.枚举对象是常量，命名规范是用大写字母+下划线


public class SelfDefinedEnum {
    public static void main(String[] args) {
        // 1.访问枚举对象
        System.out.println(Season.SPRING);
        System.out.println(Season.SUMMER);
        System.out.println(Season.AUTUMN);
        System.out.println(Season.WINTER);

        // 2.由于构造器被定义为private，只能在类内创建对象
        // Season s = new Season("", "");// 报错
    }
}
