// member inner class：成员内部类


// 成员内部类
//
// (1)概念
//  成员内部类定义在【外部类的成员位置】，它和外部类的成员是一个级别
//  类的五大成员：属性、方法、构造器、代码块、内部类
//
//
// (2)语法
//  public class Outer {
//      ...
//      [访问修饰符] class Inner {
//          内部类体...
//      }
//  }
//
//
// (3)特点【重点】
//  1.由于成员内部类定义在类内，因此它可以直接访问外部类的所有成员
//    若想在外部类中访问成员内部类的成员，需要创建对象
//
//  2.成员内部类是类的五大成员之一，它和外部类的其他成员是一个级别
//    因此，成员内部类可以用：四种访问修饰符、static、final、abstract等关键字修饰
//
//  3.作用域：和其他外部类成员一样，作用域为整个外部类体
//    生命周期：非静态成员内部类：从外部类对象的创建到对象的销毁
//            静态成员内部类：从外部类的加载到程序的结束
//
//  4.成员内部类也是类，它具有类的一切性质
//
//  5.若外部类和成员内部类的成员重名时，访问遵循【就近原则】
//      若想在成员内部类中访问重名的外部类成员，可以使用(外部类名.this.成员)
//
//  6.若想在外部其他类中，获取外部类的非静态成员内部类的对象，有以下三种方法：
//   （注意：非静态成员内部类属于外部类的对象实例，需要通过外部类对象来创建其内部类对象）
//    法1：通过外部类对象，创建其成员内部类对象
//        语法：Outer.Inner inner = outer.new Inner(参数列表);
//    法2：在外部类中定义一个创建并返回内部类对象的方法，调用该方法获得对象
//        如：Outer.Inner inner = outer.getInnerInstance(参数列表);
//    法3：通过外部类的匿名对象，创建其成员内部类对象（本质和法1相同）
//        语法：Outer.Inner inner = new Outer(参数列表1).new Inner(参数列表2);
//
//
//
// (4)注意事项
//  1.Java的外部类中(内部类外)创建的成员内部类对象，可以直接访问该成员内部类中(新增)的private成员（注意：只能访问内部类新增的private成员，不能访问从外部父类中继承的private成员）
//    这可以理解为：内部类是外部类的成员，因此外部类中可以通过对象直接访问内部类的private属性
//    注意：这是一种特例，实际上该内部类对象在底层中是直接创建在内部类中的，因此可以直接访问其private属性
//    然而，这种做法并不推荐，因为它破坏了类的封装性，使得代码难以理解和维护




package com._04_memberInnerClass;

public class MemberInnerClass {
    public static void main(String[] args) {
        Outer outer = new Outer("张三", 100);

        // (1)测试Outer的成员内部类Inner的方法
        outer.testMemberInnerClass02("李四");
        //李四
        //1145
        //内部类name：李四，innerFunc方法被调用
        //100
        //外部类name：张三，outerFunc方法被调用
        //李四
        //张三


        System.out.println("================");
        // (2)在外部其他类中，获取Outer的(非静态)成员内部类Inner的对象
        // 法1：通过外部类对象，创建其成员内部类对象
        Outer.Inner inner1 = outer.new Inner("王五");
        inner1.innerFunc();// 内部类name：王五，innerFunc方法被调用

        // 法2：通过外部类中定义的方法，直接获取其成员内部类对象
        Outer.Inner inner2 = outer.getInnerInstance("赵六");
        inner2.innerFunc();// 内部类name：赵六，innerFunc方法被调用

        // 法3：通过外部类的匿名对象，创建其成员内部类对象（本质和法1相同）
        Outer.Inner inner3 = new Outer().new Inner("孙七");
        inner3.innerFunc();// 内部类name：孙七，innerFunc方法被调用
    }
}
