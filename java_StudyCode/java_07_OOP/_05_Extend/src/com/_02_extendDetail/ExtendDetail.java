// 继承细节
//
// 1.子类会继承父类【所有】的属性和方法
//  注意：子类会继承父类的所有成员，但子类无法直接访问某些权限的父类成员，这时需要通过方法间接访问
//  不同权限父类成员的访问规则：
//      (1)public、protected：同包、不同包的子类都可直接访问
//      (2)默认：同包的子类可直接访问，不同包的子类不可直接访问
//      (3)private：同包、不同包的子类都不可直接访问
//  补充：子类不继承父类的构造器(但是必须调用父类的构造器)
//
//
// 2.子类对象中包含父类对象
//  子类对象的堆区空间中包含：父类对象的成员变量 + 子类新增的成员变量
//  创建子类对象时，系统会先创建一个父类对象，之后再创建子类对象新增的成员变量
//
//
// 3.子类构造器的执行过程：
//  首先执行父类构造器，之后再执行子类构造器的内容
//  注意：若子类构造器中没有显式的调用父类构造器，编译器会默认在第一条语句调用无参super();
//       若子类构造器中手动调用父类构造器，则不会自动生成默认super();
//
//
// 4.super和this调用构造器的语法是：super(参数列表)、this(参数列表)
//   二者都必须放在构造器的第一行，因此二者不能共存与同一个构造器
//   (this()中已经包含super()。this()放在第一行，本质上还是让super()做第一条语句：先创建好父类对象，再创建子类对象)
//
//
// 5.java中，所有类都是Object的子类
//   想调用子类构造器，需先调用父类构造器，需先调用父类的父类的构造器...一直向上追溯到Object类
//
//
// 6.java中使用的是单继承逻辑，子类只能直接继承一个父类
//
//
// 7.子类和父类间必须满足 is-a逻辑
//   is-a逻辑：子类 is a 父类
//   如：Cat is a Animal
//      Cat extends Animal 合理






package com._02_extendDetail;

public class ExtendDetail {
    public static void main(String[] args) {
        Sub s = new Sub();
        // Base无参构造器调用...
        // Sub无参构造器调用...

        System.out.println(s.info());// n1=100, n2=200, n3=300, n4=400
        s.f1();
        System.out.println(s.info());// n1=1, n2=2, n3=3, n4=4

        s.f2();
        // func1调用
        // func2调用
        // func3调用
        // func4调用


        Sub s1 = new Sub(4, 3, 2, 1);
        // Base有参构造器调用...
        // Sub有参构造器调用...
    }
}
