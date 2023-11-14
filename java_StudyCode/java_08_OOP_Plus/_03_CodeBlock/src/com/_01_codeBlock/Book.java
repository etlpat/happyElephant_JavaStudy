package com._01_codeBlock;

public class Book {
    private String name;
    private double price;
    public static int count;
    private int id;

    // 静态代码块：在类加载被执行
    // （静态代码块中只能访问静态成员）
    static {
        System.out.println("静态代码块被调用");
        count = 0;
    }

    // 非静态代码块：在每次创建对象时被执行（先执行代码块，后执行构造器）
    {
        System.out.println("非静态代码块被调用");
        count++;
        id = count;
    }


    // 构造器
    public Book() {
        System.out.println("构造方法被调用");
    }

    public Book(String name) {
        this();
        this.name = name;
    }

    public Book(String name, double price) {
        this(name);
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }
}
