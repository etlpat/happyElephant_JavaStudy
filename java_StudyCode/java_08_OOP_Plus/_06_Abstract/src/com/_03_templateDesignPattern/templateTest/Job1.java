package com._03_templateDesignPattern.templateTest;

// 子类继承模板类，重写抽象方法

public class Job1 extends calculateJobTimeTemplate {

    // 将job重写为计算等差数列求和
    @Override
    public void job() {
        int num = 0;
        for (int i = 0; i < 100000000; i++) {
            num += i;
        }
    }
}
