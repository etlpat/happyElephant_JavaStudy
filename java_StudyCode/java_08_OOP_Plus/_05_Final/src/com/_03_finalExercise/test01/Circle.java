package com._03_finalExercise.test01;

public class Circle {
    private double r;
    public final static double PI;// 静态final常量，只能在定义时赋值

    static {
        PI = 3.14;
    }

    public Circle() {
    }

    public Circle(double r) {
        this.r = r;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getS() {
        return r * r * PI;
    }
}
