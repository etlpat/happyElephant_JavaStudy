// static variable：静态变量


// 类变量(静态变量)
//
// (1)概念
//  类变量，又称静态变量/静态属性，即被static关键字修饰的变量
//  补充：无static的变量叫普通变量/实例变量/非静态变量
//
//
// (2)语法
// 定义语法：
//  1.访问修饰符 static 数据类型 变量名 = 值;（推荐）
//  2.static 访问修饰符 数据类型 变量名 = 值;
// 访问语法：
//  1.类名.类变量;（推荐）
//  2.对象.类变量;
//
// e.g.定义：public static int count = 0;
//     访问：Student.count = 1;
//
//
// (3)特点
//  1.static变量是类级别的变量，【它们属于类本身】，而不是属于某一个对象实例 （因此可以通过类名直接访问）
//  2.一个类的所有对象【共享】同一个static变量
//   （静态变量只在内存中存在唯一一个：全部本类对象共享这一个静态变量，并且子类以及全部子类对象继承到的也都是这一个变量）
//  3.static变量在类加载时生成，生命周期是从类的加载开始到类的消亡结束
//
//
// (4)内存布局
//  静态变量在【类加载】时生成，存放在方法区的静态域中。
//  类加载：首次创建对象，或首次调用类的静态属性、方法时，会加载类信息到方法区（简单来讲，首次使用类的同时会加载类信息）
//  在对象开辟堆区空间时，不同对象会存入同一个静态变量的地址。所有对象实例共享同一个静态变量。
//  注意：
//    在JDK8及更早的版本，静态变量存放在方法区的静态域中
//    但是在JDK9及更高的版本中，静态变量通过反射机制存放在堆区中（Class实例的尾部）
//
//
//
// (5)注意事项
//  1.静态变量在调用时，必须遵循访问权限
//
//  2.静态变量同样遵循继承的规则和查找关系
//    e.g. Object-A-B（A中有静态变量a）
//      A类的静态变量a只存在一个：B类继承到的a与A类的a是同一个变量（同一块空间）
//      若子类中新增同名变量a：B类访问a时优先访问到B类新增的a。但这并不影响B类会继承到A类的静态变量a
//
//  3.应用场景：想让每个成员共享一个变量时，可以使用静态变量
//      如：每个对象的总存款/总数量等




package com._01_staticVariable;

public class StaticVariable {
    public static void main(String[] args) {
        // (1)在首次调用静态成员时，也会加载类信息（只加载一次）
        //  静态成员在加载类时创建，因此可以直接调用
        System.out.println(Child.count);// 0

        // (2)Child类的静态变量会被所有对象实例共享
        Child child1 = new Child("小明");
        child1.count++;
        System.out.println(child1.count);// 1

        Child child2 = new Child("小红");
        child2.count++;
        System.out.println(child2.count);// 2

        Child child3 = new Child("小夫");
        child3.count++;
        System.out.println(child3.count);// 3
        System.out.println(child1.count);// 3

        // (3)静态变量，可以通过类名来访问
        System.out.println("创建了" + Child.count + "个Child对象");// 创建了3个Child对象
    }
}


class Child {
    private String name;
    public static int count = 0;
    // 用 static关键字 定义了一个类变量(静态变量)count
    // 类变量count的最大特点是：会被Child类的所有对象实例共享

    public Child() {
    }

    public Child(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
