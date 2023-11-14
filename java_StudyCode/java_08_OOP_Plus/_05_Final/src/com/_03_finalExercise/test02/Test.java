package com._03_finalExercise.test02;

// 例题：形参参数可以设为final常量

public class Test {

    public static int addOne(final int x) {
        //x++;// 报错，x为常量，值不能修改
        return x + 1;
    }


    public static void main(String[] args) {
        int a = 1;
        int b = addOne(a);
        System.out.println(b);// 2
    }
}
