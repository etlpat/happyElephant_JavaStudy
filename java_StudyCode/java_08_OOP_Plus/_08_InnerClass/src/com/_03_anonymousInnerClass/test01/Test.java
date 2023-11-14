package com._03_anonymousInnerClass.test01;

public class Test {
    public static void main(String[] args) {
        Person jimmy = new Person("Jimmy", 4200);

        jimmy.work();
        //电工Jimmy 进行工程作业
        //Jimmy获得10000.0元奖金
        //Jimmy月薪变更为4600.0
        //Jimmy今年总工资为：65200.0

        System.out.println("===============");
        jimmy.rest();
        //Jimmy 正在进行周末休息
        //Jimmy睡大觉
        //Jimmy吃美食
        //Jimmy破费吃大餐，吃了烤全羊
    }
}
