package com._01_debug;

// 通过调试，查看对象的创建和调用
//  F7：跳入方法内
//  shift+alt+F7：强制进入方法 (可进入java库方法查看源码)
//  F8：逐行执行
//  shift+F8：跳出方法
//  F9：(resume)执行到下一个断点


public class Test04 {
    public static void main(String[] args) {
        Person p1 = new Student("张三", 114.514);
        ((Student) p1).study();
        System.out.println(p1);
    }
}


class Person {
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name='" + name + "'";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


class Student extends Person {
    private double score;

    public Student(String name, double score) {
        super(name);
        this.score = score;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return super.toString() + ", score=" + score;
    }

    public void study() {
        System.out.println("Student" + getName() + " 在学习...");
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}