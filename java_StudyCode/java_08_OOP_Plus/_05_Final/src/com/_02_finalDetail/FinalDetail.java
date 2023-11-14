// final细节
//
// (1)【重点】final常量在定义时必须赋初值，并且之后不能再修改。
//  非静态final常量允许赋值位置如下：（以下三种都是在定义时赋值）
//      1.定义时直接赋值
//      2.声明时不赋值，在代码块中赋值
//      3.声明时不赋值，在构造器中赋值
//  注意：从“执行代码块”/“直接给变量赋初值”到“执行构造器”这个过程，都可以给final常量赋初值
//  补充：
//      静态final常量，只能定义时直接赋值/在静态代码块中赋值
//
//
//
// (2)final修饰的变量又叫final常量
//  常量一般用大写字母+下划线命名，如：MAX_SIZE
//
// (3)final修饰的类/方法/变量，只是不能继承/重写/修改，但是并不影响其正常使用
//  e.g.①final类可以正常实例化对象；②final属性/方法可以正常被子类继承
//
// (4)一般来说，若一个类已经是final类了，就没有必要把方法修饰成final方法了
//
// (5)final/static不能修饰构造器
//
// (6)final和static往往搭配使用，效率更高
//  原因：底层编译器做了优化处理，这二者搭配【不会导致类加载】
//
// (7)包装类(Integer,Double,Float,Boolean等都是final)，String也是final类，不能被继承




package com._02_finalDetail;

public class FinalDetail {
    // 普通final变量
    private final int COUNT1 = 10;// 1.定义时直接赋值
    private final int COUNT2;// 2.声明时不赋值，在代码块中赋值
    final int COUNT3;// 3.声明时不赋值，在构造器中赋值

    // 静态final变量
    private final static int NUM1 = 111;// 1.定义时赋值
    private final static int NUM2;// 2.静态代码块中赋值

    {
        COUNT2 = 20;
        //COUNT2 = 200;// 报错，final常量只能赋值一次
    }

    static {
        NUM2 = 222;
        //NUM2 = 2222;// 报错，final常量只能赋值一次
    }

    public FinalDetail() {
        COUNT3 = 30;
        //COUNT3 = 300;// 报错，final常量只能赋值一次
    }


    public static void main(String[] args) {
        final int COUNT4 = 40;

        FinalDetail fd = new FinalDetail();
        System.out.println(fd.COUNT1);// 10
        System.out.println(fd.COUNT2);// 20
        System.out.println(fd.COUNT3);// 30
        System.out.println(COUNT4);// 40
        System.out.println(FinalDetail.NUM1);// 111
        System.out.println(FinalDetail.NUM2);// 222


        // 报错，final常量只能在定义时赋值，之后值就不能修改
        //fd.COUNT1 = 100;
        //fd.COUNT2 = 200;
        //fd.COUNT3 = 300;
        //COUNT4 = 400;
        //FinalDetail.NUM1 = 1111;
        //FinalDetail.NUM2 = 2222;
    }
}
