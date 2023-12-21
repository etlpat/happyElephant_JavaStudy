package com._02_selfDefinedEnum;

// 该Season类是自定义的枚举类
//  步骤：
//  1.将类的构造器私有化，防止在类外创建对象
//  2.在类的内部，创建固定的对象（建议将枚举对象设置为static+final的静态常量）
//  3.不能设置set方法，枚举对象只读，不可修改

public class Season {
    private String name;
    private String describe;

    // 2.创建static+final的静态枚举常量（在类加载时生成）
    public static final Season SPRING = new Season("春天", "温暖");
    public static final Season SUMMER = new Season("夏天", "炎热");
    public static final Season AUTUMN = new Season("秋天", "凉爽");
    public static final Season WINTER = new Season("冬天", "寒冷");

    // 1.将构造器私有化，防止在类外创建枚举对象
    private Season(String name, String describe) {
        this.name = name;
        this.describe = describe;
    }

    // 3.不设置任何set方法
    public String getName() {
        return name;
    }

    public String getDescribe() {
        return describe;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", describe='" + describe + '\'' +
                '}';
    }
}
