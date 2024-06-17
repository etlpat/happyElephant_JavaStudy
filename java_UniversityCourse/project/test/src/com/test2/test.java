package com.test2;

public class test {
    public static void main(String[] args) {

        System.out.println(B.a);
        System.out.println(B.b);

        A b = new B();
        System.out.println(b.a1);
        System.out.println(b.b1);
        System.out.println(b.c1);

        b.func();
    }
}
