package com._03_finalExercise.test01;

// 案例：设计一个圆类，将圆周率PI设计为final常量，半径r为私有属性
//  并且包含一个返回面积s的方法

public class Test {
    public static void main(String[] args) {
        System.out.println(Circle.PI);// 3.14

        System.out.println(new Circle(2.5).getS());// 19.625
    }
}
