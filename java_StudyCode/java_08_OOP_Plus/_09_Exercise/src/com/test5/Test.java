package com.test5;

public class Test {
    public static void main(String[] args) {
        System.out.println(Frock.getNextNum());// 100100
        System.out.println(Frock.getNextNum());// 100200
        System.out.println(new Frock().getSerialNum());// 100300
        System.out.println(new Frock().getSerialNum());// 100400
        System.out.println(new Frock().getSerialNum());// 100500
    }
}
