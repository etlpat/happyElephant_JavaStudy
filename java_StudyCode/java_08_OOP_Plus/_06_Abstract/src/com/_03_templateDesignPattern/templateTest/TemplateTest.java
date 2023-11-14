package com._03_templateDesignPattern.templateTest;

public class TemplateTest {
    public static void main(String[] args) {
        new Job1().calculateTime();// job方法执行时间：64ms

        new Job2().calculateTime();// job方法执行时间：170ms
    }
}
