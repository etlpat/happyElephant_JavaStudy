package com._04_abstractFactoryPattern;


// 抽象工厂模式
//
//
// 1.前言
//  前面介绍的工厂方法模式中考虑的是一类产品的生产,如畜牧场只养动物、电视机厂只生产电视机等。
//  这些工厂只生产同种类产品,同种类产品称为同等级产品,也就是说:工厂方法模式只考虑生产同等级的产品,但是在现实生活中许多工厂
//      是综合型的工厂,能生产多等级(种类)的产品,如电器厂既生产电视机又生产洗衣机或空调,大学既有软件专业又有生物专业等。
//  本节要介绍的抽象工厂模式将考虑多等级产品的生产,将同一个具体工厂所生产的位于不同等级的一组产品称为一个产品族,
//      横轴是产品等级,也就是同一类产品;纵轴是产品族,也就是同一品牌的产品,同一品牌的产品产自同一个工厂。
//
//
// 2.抽象工程模式介绍
//  抽象工厂模式提供一个创建一组相关或相互依赖对象的接口，且访问类无需指定所需要的产品的具体类，就能得到同组的不同等级的产品。
//  抽象工厂模式是工厂方法模式的升级版本，工厂方法模式只能生产一个等级的产品，而抽象工厂模式可以生产多个等级的产品。
//
//
// 3.结构
//  抽象工厂模式的主要角色如下:
//      抽象工厂(Abstract Factory):提供了创建产品的接口,它包含多个创建产品的方法,可以创建多个不同等级的产品。
//      具体工厂(Concrete Factory):主要是实现抽象工厂中的多个抽象方法,完成具体产品的创建。
//      抽象产品(Product):定义了产品的规范,描述了产品的主要特性和功能,抽象工厂模式有多个抽象产品。
//      具体产品(ConcreteProduct):实现了抽象产品角色所定义的接口,由具体工厂来创建,它 同具体工厂之间是多对一的关系。
//  【抽象工厂接口中提供了生成一个产品族中所有种类产品的方法；而每一个具体工厂对应一个产品族】
//
//
// 4.优缺点
//  优点：当要添加一个产品族时，只需添加一个对应的工厂即可，不需要修改原有的代码，符合开闭原则。
//      当需要生产同一个产品族的多种对象时，只需一个工厂即可。
//  缺点：若是整个产品族新增了某种产品等级结构，需要修改整个工厂类。
//
//
// 5.使用场景
//  当需要创建的对象是一系列相互关联或相互依赖的产品族时,如电器工厂中的电视机、洗衣机、空调等。
//  系统中有多个产品族,但每次只使用其中的某一族产品。如有人只喜欢穿某一个品牌的衣服和鞋。
//  系统中提供了产品的类库,且所有产品的接口相同,客户端不依赖产品实例的创建细节和内部结构。
//  如:输入法换皮肤,一整套一起换。生成不同操作系统的程序。


public class AbstractFactoryPattern {
}
