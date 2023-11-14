// downcasting：向下转型

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


package com._03_polyDetail.upcastingAndDowncasting;

public class DowncastingTest {
    public static void main(String[] args) {
        // (1)向上转型：用父类引用接收子类对象
        Animal a1 = new Dog("旺财", 12345);
        // 父类引用无法调用子类中新增的成员
        // System.out.println(a1.id);// 报错
        // a1.eatBone();// 报错


        // (2)向下转型：把曾经向上转换过的父类引用,向下转换成子类引用
        Dog d1 = (Dog) a1;
        System.out.println(d1.id);// 12345
        d1.eatBone();// Dog吃骨头...
        // 两个引用指向一块空间
        System.out.println(a1.hashCode());// 460141958
        System.out.println(d1.hashCode());// 460141958


        // (3)引用的强转类型转换(本质还是看编译类型和运行类型)
        ((Dog) a1).eatBone();// Dog吃骨头...
        //((Animal) d1).eatBone();// 报错，Animal类中不存在该方法
        ((Animal) d1).cry();// Dog在叫唤...

    }
}
