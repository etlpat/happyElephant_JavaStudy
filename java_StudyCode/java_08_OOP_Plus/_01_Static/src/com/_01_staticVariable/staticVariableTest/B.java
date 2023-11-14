package com._01_staticVariable.staticVariableTest;

public class B extends A {
    public static int aCount = 100;
    private static int bCount = 0;

    public B() {
        bCount++;
    }

    public static int getbCount() {
        return bCount;
    }

    public static void setbCount(int bCount) {
        B.bCount = bCount;
    }
}
