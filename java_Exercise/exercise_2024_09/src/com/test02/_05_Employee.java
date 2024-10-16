package com.test02;

public class _05_Employee {

    private static int nextId = 1;

    private int id;
    private String name;
    private int age;


    // 代码块
    // 创建对象时：
    //  ①为成员变量赋初值/执行非静态代码块（级别相同，自上而下依次执行）
    //  ②执行构造方法
    {
        System.out.println("代码块开始执行");
        id = nextId;
        nextId++;
    }


    // 构造器
    public _05_Employee() {
        System.out.println("构造器开始执行");
    }

    public _05_Employee(String name, int age) {
        this();
        this.name = name;
        this.age = age;
    }


    @Override
    public String toString() {
        return "_05_Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
