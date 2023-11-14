package com._01_abstract.test02;

// 抽象方法不能用private、final和static来修饰，因为这些关键字都和重写相违背。
//
// (1)抽象方法不能用private修饰：抽象方法需要被子类重写，但是private只允许类内使用
// (2)抽象方法不能用final修饰：抽象方法需要被子类重写，但是final方法不能被重写
// (3)抽象方法不能被static修饰：抽象方法不能实例化，但是static只要类加载就直接实例化


abstract public class A {
    //private abstract void func1();// 报错
    //public abstract final void func2();// 报错
    //public abstract static void func3();// 报错
}
