package com._05_EnumExercise.test02;

// 案例：问下列会输出什么？

public class Test {
    public static void main(String[] args) {
        Gender boy1 = Gender.BOY;
        Gender boy2 = Gender.BOY;

        // 由于Enum重写了toString方法，这里直接输出枚举对象名
        System.out.println(boy1);// BOY
        System.out.println(boy1 == boy2);// true
    }
}
