package com._01_extend;

/**
 * Student：学生类
 * 作为 Pupil(小学生)类 和 Undergraduate(大学生)类 的父类
 */

public class Student {
    public String name;
    public int age;
    private double score;

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void exam() {// 考试方法
    }
}
