package com.test02;

public class Test02 {

    public static void main(String[] args) {
        try {
            throw new NullPointerException();
        } catch (Exception e) {
            System.out.println(2);
        }
        System.out.println(3);
    }

}

