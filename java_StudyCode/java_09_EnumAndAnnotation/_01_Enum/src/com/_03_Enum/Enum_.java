package com._03_Enum;

// 枚举
//
// (1)概念
//  Java中的enum是一种特殊的类，它包含了一组固定的常量对象。
//
//
// (2)enum语法
//  1.用enum关键字代替class
//  2.构造器：
//      enum的构造器只能是private类型，且默认是private的
//  3.枚举对象的创建：
//      枚举对象必须在enum中的第一行创建（默认是public+static+final的）
//      语法：常量名1(实参列表), 常量名2(实参列表),......,常量名n(实参列表);
//  4.其它方面和class的定义完全一致（枚举类也是类，只是默认继承Enum类）
//
//
//
// (3)注意事项
//  1.enum的构造器只能是private类型，且默认是private类型的
//    原因：保证不能在类外创建枚举对象
//  2.枚举对象必须在enum类的首行创建，并且枚举对象默认是public+static+final的
//    SPRING("春天", "温暖"); 等价于 public static final Season SPRING = new Season("春天", "温暖");
//
//  3.当我们使用enum关键字创建枚举类时，默认会继承Enum类（Object-Enum-枚举类型XXX）(可以用javap对.class文件反编译来验证)
//    因此，当用enum关键字创建枚举类，不能再继承其它类，但是可以实现接口
//  4.如果使用无参构造器创建枚举对象，小括号可以省略


public class Enum_ {
    public static void main(String[] args) {
        System.out.println(SeasonEnum.SPRING);
        System.out.println(SeasonEnum.SUMMER);
        System.out.println(SeasonEnum.AUTUMN);
        System.out.println(SeasonEnum.WINTER);
        System.out.println(SeasonEnum.OTHER);

        // enum关键字创建的枚举类，默认继承自Enum类
        System.out.println(SeasonEnum.SPRING instanceof Enum);// true
    }
}
