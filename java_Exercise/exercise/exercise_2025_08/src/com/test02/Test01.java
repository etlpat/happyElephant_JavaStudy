package com.test02;

public class Test01 {

    public static void func() {
        throw new NullPointerException();
    }

    public static void main(String[] args) {
        try {
            Test01.func();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
