package com.test01;

public class DataType {

    // (1)基本数据类型
    // (java中，数据类型所占的空间固定不变)
    // 1.整型
    public static int a = 0;// int整型，4字节
    public static short b = 0;// short短整型，2字节
    public static long c = 0L;// long长整型，8字节
    public static byte d = 127;// byte字节型，1字节
    // 2.浮点型
    // 类似1.11的常数小数，默认为double类型；带后缀的1.11f才是float类型
    public static double e = 0.1;// double，8字节
    public static float f = 0.2f;// float，4字节
    // 3.字符型
    // char字符型，实际存储字符对应的Unicode码
    // 'a'是字符，"a"是字符串
    public static char g = 'A';
    // 4.boolean类型
    public static boolean h = true;// 值只能是true/false


    // (2)数字的进制表示
    public static int x1 = 0b111;// 2进制
    public static int x2 = 010;// 8进制
    public static int x3 = 0x10;// 16进制

    // (3)final修饰的常量
    // final将变量修饰为常量，只能在声明的同时赋值一次，之后就不能更改
    public static final int YSD = 666;// final常量，习惯命名全大写


    public static void main(String[] args) {
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
        System.out.println(h);

        System.out.println(x1);
        System.out.println(x2);
        System.out.println(x3);

        System.out.println(YSD);
    }
}
