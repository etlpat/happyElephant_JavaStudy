package com._03_templateDesignPattern.templateTest;

// 子类继承模板类，重写抽象方法

public class Job2 extends calculateJobTimeTemplate {

    // 将job重写为计算阶乘
    @Override
    public void job() {
        int num = 1;
        for (int i = 0; i < 100000000; i++) {
            num *= i;
        }
    }
}
