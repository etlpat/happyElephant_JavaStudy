package com._06_override;

public class Animal {

    public void eat() {
        System.out.println("Animal吃饭");
    }

    public void eat(String name) {
        System.out.println("Animal" + name + "吃饭");
    }

    public void sleep() {
        System.out.println("Animal睡觉");
    }

    public Object m1() {
        return null;
    }

    private void m2() {

    }
}
