package com._03_DealWithException;

// 当层层调用的方法，其异常类型杂乱未知，直接统一throws Exception类异常即可


import java.io.FileNotFoundException;
import java.rmi.RemoteException;

public class test2 {
    public static void main(String[] args) {
        try {
            func1();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    public static void func1() throws Exception {
        func2();
        throw new FileNotFoundException();
    }

    public static void func2() throws Exception {
        func3();
        throw new RemoteException();
    }

    public static void func3() throws Exception {
        throw new ArithmeticException();
    }
}
