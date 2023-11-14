package com.test06;

public class Teacher extends Person {
    private int work_age;

    public Teacher(String name, String sex, int age, int work_age) {
        super(name, sex, age);
        this.work_age = work_age;
    }

    public Teacher() {
    }

    @Override
    public void play() {
        System.out.println("Teacher" + getName() + " 爱玩象棋");
    }

    public void teach() {
        System.out.println("Teacher" + getName() + " 在教书");
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + getName() + '\'' +
                ", sex='" + getSex() + '\'' +
                ", age=" + getAge() +
                ", work_age=" + work_age +
                '}';
    }

    public int getWork_age() {
        return work_age;
    }

    public void setWork_age(int work_age) {
        this.work_age = work_age;
    }
}
