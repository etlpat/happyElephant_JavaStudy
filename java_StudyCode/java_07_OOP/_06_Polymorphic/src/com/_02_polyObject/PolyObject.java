// object polymorphic：对象的多态


// 对象的多态【重点】
//
// 前提：两个对象的类存在继承关系
// 对象多态：父类引用指向子类对象
//
//
// (1)编译类型和运行类型
// 【重要的几句话】
//  1.一个对象的编译类型和运行类型可以不一致
//  2.编译类型，在定义对象时就确定了，不能改变
//  3.运行类型是可以变化的
//  4.编译类型：看定义时“=”的左边； 运行类型：看“=”的右边
//
//  e.g.（已知Animal是Dog、Cat的父类）
//      注意：父类的引用可以指向其子类对象
//      Animal animal1 = new Dog();// 【引用变量animal1的编译类型是Animal，运行类型是Dog】
//      animal1 = new Cat();// 【animal1的运行类型变成了Cat，但其编译类型还是Animal】




package com._02_polyObject;

public class PolyObject {
    public static void main(String[] args) {
        // 对象的多态
        // animal 编译类型是Animal，运行类型是Dog (Animal类的引用变量animal，指向堆区Dog类对象)
        Animal animal = new Dog("旺财");
        animal.cry();// Dog类：小狗 旺财 汪汪叫...

        // animal 运行类型改为Cat，编译类型还是Animal (Animal类的引用变量animal，指向堆区Cat类对象)
        animal = new Cat("小黑");
        animal.cry();// Cat类：小猫 小黑 喵喵叫...
    }
}
