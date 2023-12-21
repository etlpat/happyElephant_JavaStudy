package com._04_EnumMethod;

// enum类型的常用方法
//
// (1)概念
//  由于所有通过enum关键字创建的类，都默认继承Enum，
//  因此枚举类型都包含Enum中定义的方法
//
//
// (2)常见方法
//  1.public final String name();
//    功能：返回枚举对象的对象名
//
//  2.public final int ordinal();
//    功能：返回枚举对象的序数（即下标，按照定义顺序，从0开始数）
//
//  3.public static 枚举类型[] values();
//    功能：返回存放枚举对象的数组
//
//  4.public String toString();
//    功能：已被Enum重写，返回枚举对象的name（对象名）
//
//  5.public final int compareTo(E o);
//    功能：比较当前枚举对象与参数枚举对象的编号大小
//         在当前对象大于、等于、小于参数的对象时，分别返回正数、0、负数
//         本质上返回：当前枚举对象编号 - 实参枚举编号


public class EnumMethod {
    public static void main(String[] args) {
        // Enum类的方法，需要通过枚举对象来调用

        // 1.name()方法：返回枚举对象名称
        System.out.println(Season.SPRING.name());// SPRING

        // 2.ordinal()方法：返回枚举对象下标
        System.out.println(Season.SPRING.ordinal());// 0
        System.out.println(Season.SUMMER.ordinal());// 1
        System.out.println(Season.AUTUMN.ordinal());// 2
        System.out.println(Season.WINTER.ordinal());// 3

        // 3.values()方法：返回存放枚举对象的数组
        Season[] seasonArr = Season.values();
        for (Season season : seasonArr) {// 增强for遍历数组（迭代器）
            System.out.print(season + " ");// SPRING SUMMER AUTUMN WINTER
        }
        System.out.println();

        // 4.toString()方法：返回枚举对象的对象名name
        System.out.println(Season.WINTER);// WINTER

        // 5.compareTo()方法：比较当前枚举对象与参数枚举对象的编号大小
        System.out.println(Season.SUMMER.compareTo(Season.SPRING));// 1
        System.out.println(Season.SUMMER.compareTo(Season.SUMMER));// 0
        System.out.println(Season.SUMMER.compareTo(Season.AUTUMN));// -1
        System.out.println(Season.SPRING.compareTo(Season.WINTER));// -3
        System.out.println(Season.WINTER.compareTo(Season.SPRING));// 3
    }
}
