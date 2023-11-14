package com._02_extendDetail;

/**
 * Base作为Sub的父类
 */

public class Base {
    // 四种权限的属性
    public int n1 = 100;
    protected int n2 = 200;
    int n3 = 300;
    private int n4 = 400;

    public Base() {
        //super();// 即使是父类构造器也会默认生成，直到追溯到Object(顶级父类)
        System.out.println("Base无参构造器调用...");
    }

    public Base(int n1, int n2, int n3, int n4) {
        System.out.println("Base有参构造器调用...");
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
        setN4(n4);
    }

    public int getN4() {return n4;}
    public void setN4(int n4) {this.n4 = n4;}

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

    public void callFunc4() {
        func4();
    }

    public String info() {
        return "n1=" + n1 + ", n2=" + n2 + ", n3=" + n3 + ", n4=" + n4;
    }
}
