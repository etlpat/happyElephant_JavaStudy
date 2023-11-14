// abstract：抽象


// 抽象类
//
// (1)概念
//  当父类的某些方法，需要声明，但又不确定如何如何实现时，
//  可以将其声明为抽象方法，那么这个类就是抽象类。
//
//
// (2)语法
//  1.抽象方法：[访问修饰符] abstract 返回类型 方法名(形参列表);
//      即：abstract关键字 + 方法声明; （注意：抽象方法无方法体）
//  2.抽象类： [访问修饰符] abstract class 类名 {...}
//      即：abstract关键字 + 类定义
//  e.g.
//    抽象方法：public abstract void eat(String name);
//    抽象类：public abstract class Animal {...}
//
//
// (3)要点
//  1.abstract关键字：用于将类/方法 声明为 抽象类/抽象方法
//    注意：abstract只能用来修饰类和方法，不能修饰其他东西
//
//  2.抽象方法：只有方法声明，没有具体实现。（目的是规范子类的行为，增加代码的可拓展性）
//    注意：[①]由于抽象方法没有具体代码实现，因此抽象类不能被实例化。
//         [②]继承了抽象类的子类，必须重写父类所有的抽象方法，才能实例化；否则子类也必须为抽象类。
//          ③抽象方法也是方法，可以被子类继承，遵循查找关系。
//         [④]抽象方法不能用private、final和static来修饰，因为这些关键字都和重写相违背。
//
//  3.抽象类：包含抽象方法的类必须被声明为抽象类；但是抽象类中也可以没有抽象方法。
//    注意：[①]抽象类不能被实例化（无论抽象类中是否包含抽象方法，抽象类都不能被实例化）
//          ②抽象类也是类，普通类中拥有的成员，抽象类中都可以拥有



package com._01_abstract;

public class Abstract_ {
    public static void main(String[] args) {
        // (1)抽象类无法实例化
        //new Animal();// 报错

        // (2)子类必须重写完父类的所有抽象方法，才能实例化
        new Dog("旺财").eat();// 小狗旺财 吃骨头
    }
}
