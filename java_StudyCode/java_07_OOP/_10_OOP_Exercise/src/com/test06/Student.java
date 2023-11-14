package com.test06;

public class Student extends Person {
    private int stu_id;

    public Student() {
    }

    public Student(String name, String sex, int age, int stu_id) {
        super(name, sex, age);
        this.stu_id = stu_id;
    }

    @Override
    public void play() {
        System.out.println("Student" + getName() + " 爱玩足球");
    }

    public void study() {
        System.out.println("Student" + getName() + " 在学习");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + getName() + '\'' +
                ", sex='" + getSex() + '\'' +
                ", age=" + getAge() +
                ", stu_id=" + stu_id +
                '}';
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }
}
