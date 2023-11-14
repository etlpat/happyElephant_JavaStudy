// lazy singleton class：懒汉式单例类


// 懒汉式单例类
//
// (1)懒汉式
//  懒汉式：类加载时先创建值为null的静态引用，在首次调用getInstance方法时才为其开辟空间并初始化
//  为什么叫“懒汉式”？ 因为这种模式在需要时才创建实例，就像一个懒惰的人一样，不愿意立即行动，而是等待需要时才动手处理。
//  安全性：需要注意的是，懒汉式单例模式不是线程安全的，因为如果在多线程环境下，多个线程可能同时调用getInstance方法，导致创建多个实例，从而破坏单例模式。
//         因此，如果需要在多线程环境下使用懒汉式单例模式，需要添加同步机制来保证线程安全。
//
//
// (2)实现步骤
//  1.在类内创建类的静态引用，值为null
//  2.将构造器私有化（保证只能在类内调用）
//  3.设置一个public的getInstance方法，在方法中做条件判断(若静态引用为空，就为其new一个对象)
//
//  以上步骤，保证了类只存在一个静态对象，并在首次getInstance时才初始化对象




package com._03_lazySingletonClass;

public class LazySingletonClass {
    public static void main(String[] args) {
        // 1.懒汉式，类加载时不会直接创建对象
        System.out.println(Cat.count);// 0

        // 2.懒汉式，在首次调用getInstance方法时创建对象
        System.out.println("==========");
        Cat cat = Cat.getInstance();// Cat构造方法被调用


        // 3.不能在类外创建对象
        //Cat cat1 = new Cat("小白", 12);// 报错


        // 4.静态对象，全类共享一块内存
        System.out.println("==========");
        System.out.println(cat);// Cat{name='大橘', age=8}
        System.out.println(Cat.getInstance());// Cat{name='大橘', age=8}
    }
}
