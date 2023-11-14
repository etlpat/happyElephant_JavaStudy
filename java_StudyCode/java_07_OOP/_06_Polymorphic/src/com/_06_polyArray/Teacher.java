package com._06_polyArray;

public class Teacher extends Person {
    private double salary;

    public Teacher() {
    }

    public Teacher(String name, int age, double salary) {
        super(name, age);
        setSalary(salary);
    }

    // 重写
    public String say() {
        return "Teacher " + super.say() + " 薪水：" + getSalary();
    }

    // 新增
    public void teach() {
        System.out.println("Teacher" + getName() + " 在讲课...");
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
