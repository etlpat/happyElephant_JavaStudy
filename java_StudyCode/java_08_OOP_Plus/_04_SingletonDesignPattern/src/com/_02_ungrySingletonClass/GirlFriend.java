package com._02_ungrySingletonClass;

// 饿汉式单例类

public class GirlFriend {
    private String name;
    private int age;
    public static int count;

    // 1.静态对象，在类加载时自动创建一个该对象，全类共享一块空间
    private static GirlFriend girlFriend = new GirlFriend("小红", 20);

    // 2.私有构造器，保证只能在类内创建对象
    private GirlFriend(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("调用私有构造方法");
    }

    // 3.公开静态get方法，用于获取静态对象
    public static GirlFriend getInstance() {
        return girlFriend;
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
        return "GirlFriend{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
