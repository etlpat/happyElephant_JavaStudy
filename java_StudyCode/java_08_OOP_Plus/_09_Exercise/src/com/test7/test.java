package com.test7;

public class test {
    public static void main(String[] args) {
        new Cellphone().testWork(new Calculator() {
            @Override
            public void work() {
                System.out.println("work方法被调用");
            }
        });
    }
}
