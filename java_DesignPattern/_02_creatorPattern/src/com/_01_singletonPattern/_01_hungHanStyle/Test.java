package com._01_singletonPattern._01_hungHanStyle;

public class Test {
    public static void main(String[] args) {
        HungHanStyle instance1 = HungHanStyle.getInstance();
        System.out.println(instance1);// HungHanStyle@3b07d329

        HungHanStyle instance2 = HungHanStyle.getInstance();
        System.out.println(instance2);// HungHanStyle@3b07d329

        // 饿汉式单例模式，始终返回一个对象
    }
}
