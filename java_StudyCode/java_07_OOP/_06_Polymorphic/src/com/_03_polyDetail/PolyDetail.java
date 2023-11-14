// polymorphic detail：多态细节


// 【向上转型】
//  多态的向上转型，即用父类引用接收子类对象
//
// (1)本质
//  父类的引用指向子对象(堆区空间)
//
// (2)语法
//  父类类型 引用名 = new 子类类型(参数列表);
//  如：Animal animal = new Dog();
//
//
// (3)规则【重点】
//  1.编译类型看“=”左边，运行类型看“=”右边
//  2.由于编译类型是父类Animal，引用变量animal【只能执行Animal类允许的操作】
//      说明：只允许调用父类中拥有的成员(按照父类查找关系)，不能调用子类中的新增成员
//  3.由于运行类型是子类Dog，程序执行时实际调用的是子类对象(重写后)的方法
//
//  p.s.①方法的调用看对象的运行类型（方法和运行类型动态绑定）
//      ②属性的调用看对象的编译类型（属性无多态性，不动态绑定）
//
//  e.g.(以此为例：Animal animal = new Dog();)
//      由于animal是Animal类的引用变量，因此只能执行Animal类允许的操作
//      animal指向的是Dog对象的堆区空间，因此实际调用的是Dog对象的成员方法
//
//
//
// (4)注意事项
//  1.上述规则中，规则②在编译阶段由编译器完成，规则③在运行阶段由JVM完成，二者不矛盾
//
//  2.【属性不具备多态性】
//      若子类与父类中包含同名属性：
//      规则：调用属性，得到的值看【编译类型】 (用父类引用调用属性，会得到父类属性的值)
//      原因：属性不具备多态性！没有重写的说法。它们是与所属的类是相关联的
//
//  3.instanceof 比较操作符
//      instance：n.例子，实例
//      语法：对象 instanceof 类
//      功能：判断对象的【运行类型】是否为XX类型或XX类型的子类型，返回boolean




// 【向下转型】
//  多态的向下转型，就是把曾经向上转换过的父类引用,向下转换成子类引用
//
// (1)语法 (强制类型转换)
//  子类类型 引用名 = (子类类型)父类引用;
//
//  如：Dog dog = (Dog)animal; 二者存放同一串地址
//
// (2)细节【重点】
//  1.只有曾经向上转换过的对象引用,才能再向下转换 (父类引用a指向子类对象，才可以把a的类型强转为子类)
//  2.向下转型后，新引用的编译类型是子类类型，可以调用子类中所有成员
//  3.注意：强转的是父类引用(栈区引用变量)，而不是父类对象(堆区空间)
//
//
// (3)注意事项
//  1.假设继承关系(Object-A-B-C-D)，堆区中有C类对象，引用变量c指向这块空间。
//    则c的编译类型：可以是Object/A/B/C类 (C类或其父类)
//    类型强转转换，必须转成其空间允许的类型




// 【总结】
// (一个引用a，其编译类型是A，运行类型是B)
//  A a = new B();
// 编译时：由于a的编译类型是A，引用a只能调用A类中存在的成员（只能执行A类允许的操作）
// 运行时：由于a的运行类型时B，引用a实际调用的是B类对象的方法（a指向堆区中的B类对象）
//       特别注意，对象调用属性看编译类型（属性无多态性）




package com._03_polyDetail;

import java.sql.SQLOutput;

public class PolyDetail {
    public static void main(String[] args) {
        Person p = new Student();
        System.out.println(p.name);// 人类（属性不具备多态型）
        p.test();// Student类调用test()（调用子类重写的属性）

        // 只能调用编译类型中存在的成员
        //System.out.println(p.score);// 报错
        //p.exam();// 报错


        Student s = new Student();
        System.out.println(s.name);// 学生
        System.out.println(s.score);// 100
        s.test();// Student类调用test()
        s.exam();// Student类调用exam()



        // instanceof关键字
        // a instanceof B：判断a的运行类型是否为B或B的子类型
        Student s1 = new Student();
        Person p1 = new Person();
        Person p2 = new Student();
        System.out.println(s1 instanceof Student);// true
        System.out.println(s1 instanceof Person);// true
        System.out.println(s1 instanceof Object);// true
        System.out.println(p1 instanceof Student);// false
        System.out.println(p2 instanceof Student);// true (instanceof判断的是运行类型)
    }
}


class Person {
    public String name = "人类";

    public void test() {
        System.out.println("Person类调用test()");
    }
}


class Student extends Person {
    public String name = "学生";
    public int score = 100;

    public void test() {
        System.out.println("Student类调用test()");
    }

    public void exam() {
        System.out.println("Student类调用exam()");
    }
}