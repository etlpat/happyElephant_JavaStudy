package com._03_codeBlockExercise.test02;

// 例题2：分析以下代码执行结果
//  1.调用Test的main方法时，首先会加载Test的类信息，执行其静态成员
//  2.之后执行main方法中的代码

public class Test {
    Sample sam1 = new Sample("sam1普通成员初始化");
    static Sample sam2 = new Sample("sam2静态成员初始化");

    static {
        System.out.println("Test静态代码块执行");
        if (sam2 == null) {
            System.out.println("sam2 is null");
        }
    }

    Test() {
        System.out.println("Test默认构造器被调用");
    }


    public static void main(String[] args) {
        System.out.println("==========");
        new Test();
        System.out.println("==========");


        // （1）main是Test类的方法，程序一旦开始执行(调用main)，就会先加载Test的类信息
//        Simple静态代码块调用 （静态属性初始化和静态代码块调用的优先级相同，按定义顺序调用）
//        Simple普通代码块调用
//        sam2静态成员初始化
//        Test静态代码块执行
//        ==========
        //  （2）静态成员只在类加载时初始化一次。之后创建对象，开辟内存空间->初始化属性(super->代码块/赋初值->构造器)
//        Simple普通代码块调用
//        sam1普通成员初始化
//        Test默认构造器被调用
//        ==========
    }
}
