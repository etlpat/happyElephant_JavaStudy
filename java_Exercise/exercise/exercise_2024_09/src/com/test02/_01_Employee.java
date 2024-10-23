package com.test02;

// 类
public class _01_Employee {
    // (1)属性
    //  类的属性设置为私有，保证封装的特性
    private String name;
    private int age;
    private double salary;


    // (2)构造器
    //  构造器：方法名和类名相同，无返回值，参数不做要求。
    //      在使用new创建对象时，自动调用构造方法，用于初始化对象参数。
    public _01_Employee() {
    }

    public _01_Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }


    // (3)方法
    //  方法对外公开，用于外界访问该对象
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "_01_Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
