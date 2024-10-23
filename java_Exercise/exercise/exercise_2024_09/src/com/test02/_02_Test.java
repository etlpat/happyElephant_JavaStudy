package com.test02;

public class _02_Test {
    public static void main(String[] args) {
        _02_Employee[] empArr = new _02_Employee[3];
        empArr[0] = new _02_Employee("张三");
        empArr[1] = new _02_Employee("李四");
        empArr[2] = new _02_Employee("王五");

        for (_02_Employee emp : empArr) {
            System.out.println(emp);
        }

        new _02_Employee();
        new _02_Employee();
        new _02_Employee();

        System.out.println(new _02_Employee("赵六"));
        System.out.println(new _02_Employee("孙七"));
    }
}
