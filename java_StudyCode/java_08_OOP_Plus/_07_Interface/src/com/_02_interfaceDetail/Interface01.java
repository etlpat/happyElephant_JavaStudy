package com._02_interfaceDetail;

public interface Interface01 {
    // (1)接口中，属性必须为public、static、final的
    public static final int num1 = 10;
    int num2 = 20;// num2默认为public、static、final的


    // (2)接口中，方法权限必须为public，且默认为abstract
    public abstract void func1();

    void func2();// func2默认为public、abstract的

    // 静态方法
    public static void func3() {
        System.out.println("Interface01接口的静态方法func3");
    }

    // 默认实现的方法
    default public void func4() {
        System.out.println("Interface01接口的fun4方法的默认实现");
    }
}
