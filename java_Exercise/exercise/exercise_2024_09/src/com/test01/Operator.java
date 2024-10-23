package com.test01;

public class Operator {
    public static void main(String[] args) {

        // 1.算数运算符
        int a = 1;
        a += 1;
        a -= 3;
        a *= 5;
        a /= 3;
        a %= 2;
        a++;
        --a;
        // 注意：
        // ++a  先自增，后运算
        // a++  先运算，后自增


        // 2.关系运算符（返回boolean值）
        System.out.println(1 <= 1);
        System.out.println(1 > 2);
        System.out.println(3 != 3);


        // 3.逻辑运算符
        //  &&短路与、||短路或：若二者的结果已注定，就不会继续向后计算，而是直接返回值
        System.out.println(true && false);
        System.out.println(true || false);
        System.out.println(!true);
        int b = 1;
        System.out.println(1 != 1 && b++ == 1);// false
        System.out.println(1 == 1 || b-- == 1);// true
        System.out.println(b);// 1
        System.out.println(1 == 1 && b++ == 1);// true
        System.out.println(1 != 1 || b++ == 2);// true
        System.out.println(b);// 3


        // 4.三目运算符
        System.out.println(1 != 1 ? true : false);


        // 5.位运算符
        //  &按位与，|按位或，^按位异或，~按位非，转化为二进制进行位运算
        System.out.println(7 & 2);// 111 & 010 = 010
        System.out.println(5 | 2);// 101 | 010 = 111
        System.out.println(5 ^ 3);// 101 | 011 = 110
        System.out.println(~-1);// ~1111...1111 = 0000...0000


        // 6.位移运算符
        // 注意：>>有符号右移，>>>无符号右移
        System.out.println(3 << 2);// 11 -> 1100
        System.out.println(6 >> 2);// 110 -> 1
        System.out.println(-1 >> 1);// -1
        System.out.println(-1 >>> 1);// 正数

    }
}
