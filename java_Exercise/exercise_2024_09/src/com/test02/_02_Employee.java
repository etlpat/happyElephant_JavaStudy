package com.test02;

public class _02_Employee {
    // static修饰静态成员
    //  ①static成员是属于类的成员，在类加载时就被创建
    //  ②static成员可以通过类名直接调用
    //  ③static成员在内存中只有一份，被所有对象所共享
    private static int nextId = 1;

    private int id;
    private String name;

    public _02_Employee() {
        id = nextId;
        nextId++;
    }

    public _02_Employee(String name) {
        this();// 调用无参构造器
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "_02_Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
