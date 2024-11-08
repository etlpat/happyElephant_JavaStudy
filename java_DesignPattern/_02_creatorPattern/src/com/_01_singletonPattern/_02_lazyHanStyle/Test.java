package com._01_singletonPattern._02_lazyHanStyle;

public class Test {
    public static void main(String[] args) {
        LazyHanStyle instance1 = LazyHanStyle.getInstance();
        System.out.println(instance1);// LazyHanStyle@3b07d329

        LazyHanStyle instance2 = LazyHanStyle.getInstance();
        System.out.println(instance2);// LazyHanStyle@3b07d329

        // 懒汉式单例模式，始终返回同一个对象
    }
}
