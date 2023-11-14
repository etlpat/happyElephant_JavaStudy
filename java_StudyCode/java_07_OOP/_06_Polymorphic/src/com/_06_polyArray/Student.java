package com._06_polyArray;

public class Student extends Person {
    private double score;

    public Student() {
    }

    public Student(String name, int age, double score) {
        super(name, age);
        setScore(score);
    }

    // 重写
    public String say() {
        return "Student " + super.say() + " 分数：" + getScore();
    }

    // 新增
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
