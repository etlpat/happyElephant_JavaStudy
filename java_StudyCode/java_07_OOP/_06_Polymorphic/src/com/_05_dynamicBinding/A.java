package com._05_dynamicBinding;

public class A {
    public int i = 10;

    public int sum1() {
        return getI() + 10;
    }

    public int sum2() {
        return i + 10;
    }

    public int getI() {
        return i;
    }
}
