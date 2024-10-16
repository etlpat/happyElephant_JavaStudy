package com.test03;

public class _01_Employee {
    private static int nextId = 1;

    private int id;
    private String name;
    private double salary;


    public _01_Employee() {
        id = nextId++;
    }

    public _01_Employee(String name, double salary) {
        this();
        this.name = name;
        this.salary = salary;
    }


    public double getYearSalary() {// 获取年工资
        return salary * 12;
    }

    public void func1(int n) {
        System.out.println("_01_Employee类:func1(int n)");
    }

    public void func1(String s) {
        System.out.println("_01_Employee类:func1(String s)");
    }

    @Override
    public String toString() {
        return "_01_Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
