package com.test02;

public class Professor extends Teacher {
    private double grade = 1.3;// 工资级别

    public Professor() {
    }

    public Professor(String name, int age, String post, double salary, double grade) {
        super(name, age, post, salary);
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", post='" + getPost() + '\'' +
                ", salary=" + getSalary() +
                ", grade=" + grade +
                '}';
    }

    public double getGrade() {
        return grade;
    }
}
