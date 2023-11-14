package com._03_codeBlockExercise.test02;

public class Sample {
    static {
        System.out.println("Simple静态代码块调用");
    }

    {
        System.out.println("Simple普通代码块调用");
    }

    Sample(String s) {
        System.out.println(s);
    }

    Sample() {
        System.out.println("Sample默认构造器被调用");
    }
}
