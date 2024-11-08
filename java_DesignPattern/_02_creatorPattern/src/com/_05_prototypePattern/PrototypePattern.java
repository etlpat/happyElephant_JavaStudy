package com._05_prototypePattern;


// 原型模式
//
//
// 1.介绍
//  原型模式是一种对象创建型模式，
//  用一个已经创建的实例作为原型，通过复制该原型对象，来创建一个和原型对象相同的新对象。
//
//
// 2.结构
//  原型模式包含如下角色:
//      抽象原型类:规定了具体原型对象必须实现的的 clone()方法。（jdk自带的Cloneable接口）
//      具体原型类:实现抽象原型类的 clone()方法,它是可被复制的对象。
//      访问类:使用具体原型类中的 clone()方法来复制新的对象。
//
//
// 3.Cloneable接口与clone()方法
//  在原型模式中，clone()方法直接使用Object类提供的clone()即可。
//  若想使用Object类的clone()方法，【需要将jdk提供的Cloneable接口作为抽象原型类】。
//      Cloneable接口：
//          “一个类实现Cloneable接口以指示Object.clone()方法，该类的实例可以进行字段到字段的复制。”
//          “在未实现Cloneable接口的实例上调用Object的clone方法会导致CloneNotSupportedException异常被抛出。”
//  注意：Object的clone()，默认是浅克隆。
//
//
// 4.深克隆与浅克隆
//  浅克隆:创建一个新对象,新对象的属性和原来对象完全相同,对于非基本类型属性,仍指向原有属性所指向的对象的内存地址。
//  深克隆:创建一个新对象,属性中引用的其他对象也会被克隆,不再指向原有对象地址。
//  【Object自带的clone()方法默认为浅克隆，若想深克隆需要自己实现。】
//
// 5.使用场景
//  对象的创建非常复杂,可以使用原型模式快捷的创建对象。
//  每个对象差别不大/性能和安全要求比较高。
//


public class PrototypePattern {
    public static void main(String[] args) {

    }
}
