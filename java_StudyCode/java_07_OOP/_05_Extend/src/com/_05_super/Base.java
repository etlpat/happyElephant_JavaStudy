package com._05_super;

/**
 *  Base是Sub的父类
 */

public class Base {
    // 四种权限的属性
    public int n1 = 100;
    protected int n2 = 200;
    int n3 = 300;
    private int n4 = 400;

    // 构造器
    public Base() {
    }
    public Base(int n1, int n2, int n3, int n4) {
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
        this.n4 = n4;
    }

    // 四种权限的方法
    public void func1() {
        System.out.println("func1调用");
    }
    protected void func2() {
        System.out.println("func2调用");
    }
    void func3() {
        System.out.println("func3调用");
    }
    private void func4() {
        System.out.println("func4调用");
    }

    public String info() {
        return "n1=" + n1 + ", n2=" + n2 + ", n3=" + n3 + ", n4=" + n4;
    }
}
