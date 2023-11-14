// extend：继承


// 继承
//
// 1.继承的引入
//  当存在多个重复度较高的类时，可以从其中抽象出父类，
//  父类中定义基本的属性和方法，子类继承父类，减少代码的复用
//
//
// 2.继承语法
//  [访问修饰符] class 子类名 extends 父类名 {
//      代码块;
//  }
//
//
// 3.注意事项：
//  1.父类：又叫基类、超类
//  2.子类：又叫派生类
//  3.继承的好处：提高代码的复用性；提高代码的扩展性和维护性


package com._01_extend;

public class Extend {
    public static void main(String[] args) {
        Pupil p = new Pupil();
        p.name = "小明";
        p.age = 10;
        p.exam();// 小学生小明在考小学数学
        p.setScore(90);
        System.out.println(p.getScore());// 90.0


        Undergraduate u = new Undergraduate();
        u.name = "大明";
        u.age = 20;
        u.exam();// 大学生大明在考高等数学
        u.setScore(130);
        System.out.println(u.getScore());// 130.0
    }
}
