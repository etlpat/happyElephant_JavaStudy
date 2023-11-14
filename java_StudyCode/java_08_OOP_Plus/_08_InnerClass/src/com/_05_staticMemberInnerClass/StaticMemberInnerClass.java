// static member inner class：静态成员内部类


// 静态成员内部类
//
// (1)概念
//  静态成员内部类，就是用static修饰的成员内部类
//
// (2)特点
//  1.静态成员内部类，是类级别的成员。它属于外部类本身，而不是属于某一个实例对象
//    因此：①可以直接通过外部类名来访问  ②随着外部类的加载而加载
//
//  2.静态成员内部类中，只能直接访问外部类的所有静态成员(包括私有的)，而不能直接访问非静态成员
//
//  3.静态成员内部类也是成员内部类，它也拥有成员内部类的性质
//
//  4.若想在外部其他类中，获取外部类的静态成员内部类的对象，有以下两种方法：
//    法1：直接通过new（外部类名.内部类名）创建静态成员内部类对象
//        语法：Outer.Inner inner = new Outer.Inner(参数列表);
//    法2：在外部类中定义一个静态方法，可以创建并返回内部类对象
//        如：Outer.Inner inner = Outer.getInnerInstance(参数列表);
//        （getInnerInstance方法建议定义为静态的，非静态也可以）
//
//
// (3)注意事项
//  1.区分用new在外部其他类中创建(静态/非静态)成员内部类的语法：
//      ① 静态：new 外部类名.内部类名(参数列表);
//      ②非静态：外部类对象.new 内部类名(参数列表);
//    二者语法不同的原因：
//      ①静态成员内部类属于外部类本身，可以通过类名直接访问
//      ②非静态成员内部类属于每个外部类实例，必须通过对象才能访问




package com._05_staticMemberInnerClass;

public class  StaticMemberInnerClass {
    public static void main(String[] args) {
        // (1)静态内部类，可以直接通过外部类名来访问
        System.out.println(Outer.Inner.staticId);// 114514
        Outer.Inner.innerFunc3();// 静态方法innerFunc3被调用


        // (2)测试静态成员内部类
        System.out.println("================");
        Outer outer = new Outer(666);
        outer.testStaticMemberInnerClass();
        //李四
        //静态成员内部类name：李四 的innerFunc1方法被调用
        //静态成员内部类的innerFunc2方法被调用
        //250
        //外部类静态方法func2被调用
        //李四
        //张三


        // (3)在外部其他类中获取静态成员内部类的对象
        System.out.println("================");
        // 法1：new 外部类名.内部类名(参数列表)
        Outer.Inner inner1 = new Outer.Inner("王五", 777);
        inner1.innerFunc1();// 静态成员内部类name：王五 的innerFunc1方法被调用

        // 法2：在外部类中定义一个静态方法，可以创建并返回内部类对象
        Outer.Inner inner2 = Outer.getInnerInstance("赵六", 888);
        inner2.innerFunc1();// 静态成员内部类name：赵六 的innerFunc1方法被调用
    }
}
