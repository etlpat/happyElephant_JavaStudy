package com._02_abstractExercise.test01;

//  抽象类
public abstract class BasicEmployee {
    private String name;
    private String id;
    private double salary;

    public BasicEmployee() {
    }

    public BasicEmployee(String name, String id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", salary=" + salary;
    }


    // 抽象方法
    public abstract void work();

    public abstract double getAnnualSalary();
}
