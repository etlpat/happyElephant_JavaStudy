package com._01_staticVariable.staticVariableTest;

public class StaticVariableTest {
    public static void main(String[] args) {
        // (1)静态变量也遵循继承的规则和查找关系
        //  A类B类中都有aCount，由于就近原则，A.aCount访问的是A的静态变量，B.aCount访问的是B中新增的静态变量

        // (2)由于子类是父类的拓展，加载子类前需要先加载父类
        //  这里第一条语句加载子类B前，已经完成了父类A的加载
        System.out.println(B.aCount);// 100
        System.out.println(A.aCount);// 0
        System.out.println(B.getbCount());// 0

        // (3)静态变量是共享的，B子类中也会共享到A父类的aCount变量，但是由于B中有同名变量，会优先访问到父类的aCount
        B b1 = new B();
        System.out.println(B.aCount);// 100
        System.out.println(A.aCount);// 1
        System.out.println(B.getbCount());// 1

        A a1 = new A();
        System.out.println(A.aCount);// 2

        A a2 = new A();
        System.out.println(A.aCount);// 3

        B b2 = new B();
        System.out.println(B.aCount);// 100
        System.out.println(A.aCount);// 4
        System.out.println(B.getbCount());// 2
    }
}
