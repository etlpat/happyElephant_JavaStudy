package com._03_lazySingletonClass;

// 懒汉式单例类

public class Cat {
    private String name;
    private int age;
    public static int count;

    // 1.静态引用，在类加载时创建，但要设为null
    private static Cat cat = null;

    // 2.私有构造器，保证只能在类内创建对象
    private Cat(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Cat构造方法被调用");
    }

    // 3.在getInstance中添加条件判断，若静态引用为null，就为其new一个对象
    public static Cat getInstance() {
        if (cat == null) {// 该条件判断，保证懒汉式在首次调用getInstance时才会为对象分配空间
            cat = new Cat("大橘", 8);
        }
        return cat;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
