// hungry singleton class：饿汉式单例类


// 饿汉式单例类
//
// (1)饿汉式
//  饿汉式：在加载类时直接为static对象开辟空间并初始化
//  为什么叫“饿汉式”？ 因为这种模式在类加载时就完成了静态实例的创建，就像饿汉一样，先准备好食物，随时可以享用。
//  安全性：这种方式能保证线程安全，因为类加载过程会自动加锁，保证了单例特性。
//
//
// (2)思路
//  问：如何实现单例（全程只有一个实例）？
//  答：在类内创建本类的静态对象，并将构造器设计为私有权限。
//     (仅在加载时创建一个实例) (并防止在类外创建其他实例)
//
//
// (3)实现步骤
//  1.在类的内部new静态对象（static对象在类加载时自动生成）
//  2.将构造器私有化（防止在外部new对象）
//  3.向外设置一个静态的公共方法getInstance，获取类内创建的对象（instance：实例）




package com._02_ungrySingletonClass;

public class HungrySingletonClass {
    public static void main(String[] args) {
        // 1.懒汉式，在加载类时，就创建对象
        System.out.println(GirlFriend.count);
        //调用私有构造方法
        //0


        // 2.private构造器，不能在类外创建对象
        GirlFriend gf = GirlFriend.getInstance();
        //GirlFriend gf1 = new GirlFriend("小红", 20);// 报错


        // 3，该对象是静态的，全类共享一个
        System.out.println("==========");
        System.out.println(gf);// GirlFriend{name='小红', age=20}
        System.out.println(GirlFriend.getInstance());// GirlFriend{name='小红', age=20}
    }
}
