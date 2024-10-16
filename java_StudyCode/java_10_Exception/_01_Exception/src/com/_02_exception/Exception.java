package com._02_exception;

// Exception 异常
//
//
// 1.异常介绍
//
//  (1)基本概念
//      java语言中，将程序运行中发生的不正常情况称为“异常”。
//      注意：开发过程中的语法错误和逻辑错误不是异常。
//
//  (2)执行过程中所发生的异常事件可分为两大类
//      ①Error(错误)：java虚拟机无法解决的严重问题（非常严重）。
//        如：JVM系统内部错误、资源耗尽等严重情况。像StackOverflow和OOM
//        Error是严重错误，程序会崩溃。
//
//      ②Exception(异常)：其它因编程错误或偶然的外在因素导致的一般性问题（不那么严重），可以使用针对性代码处理。
//        如：空指针访问、试图读取不存在的文件、网络连接中断等。
//        Exception分为两大类：【运行时异常】和【编译时异常】。
//
//  (3)异常的分类
//      Exception继承自Throwable类，它分为编译时异常和运行时异常。
//      ①运行时异常
//          RuntimeException及其子类是运行时异常。
//          运行时异常，是编译器不要求强制处置的异常。一般是指编程时的逻辑错误，是程序员应该避免出现的异常。
//          运行时异常非常普遍，有时可以不做处理，增加可读性和运行效率。
//
//      ②编译时异常
//          编译时异常是编译器要求必须处置的异常。
//
//
//
// 2.异常体系图（异常类的继承关系）
//
//  Object <—— Throwable类 <—— Error类(错误) <—— StackOverflowError/OutOffMemoryError/...
//                      ↑
//                      |————— Exception类(异常) <—— (编译时异常)FileNotFoundException/...
//                                           ↑
//                                           |————— RuntimeException(运行时异常) <—— NullPointerException/ArrayIndexOutOfBoundsException/...
//
//
//
// 3.常见的运行时异常
//  ①NullPointerException空指针异常  （调用对象时，访问到的对象为null）
//  ②ArithmeticException数学运算异常  （数学运算的条件异常，如除零异常）
//  ③ArrayIndexOutOfBoundsException数组下标越界异常
//  ④ClassCastException类型转换异常   （当试图将对象强转为不是该实例的子类时，抛出该异常）
//  ⑤NumberFormatException数字格式不正确异常 （当试图将字符串转换成某种数值类型，但是该字符串内容不适合转换时，抛出该异常）


public class Exception {
    public static void main(String[] args) {

        // 1.空指针异常
        try {
            String name = null;
            System.out.println(name.length());
        } catch (java.lang.Exception e) {
            e.printStackTrace();// java.lang.NullPointerException
        }


        // 2.数学运算异常
        try {
            int a = 0;
            System.out.println(1 / a);
        } catch (java.lang.Exception e) {
            e.printStackTrace();// java.lang.ArithmeticException
        }


        // 3.数组下标越界异常
        try {
            int[] ints = new int[3];
            ints[3] = 4;
        } catch (java.lang.Exception e) {
            e.printStackTrace();// java.lang.ArrayIndexOutOfBoundsException
        }


        // 4.类型转换异常
        try {
            class A {
            }
            class B extends A {
            }
            class C extends A {
            }
            A b = new B();
            C c = (C) b;
        } catch (java.lang.Exception e) {
            e.printStackTrace();// java.lang.ClassCastException
        }


        // 5.数字格式不正确异常
        try {
            int num = Integer.parseInt("hello");
        } catch (java.lang.Exception e) {
            e.printStackTrace();// java.lang.NumberFormatException
        }

    }
}
