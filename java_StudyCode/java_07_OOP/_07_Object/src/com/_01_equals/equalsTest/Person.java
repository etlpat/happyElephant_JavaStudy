package com._01_equals.equalsTest;

// 题目：重写Person对象的equals方法
//      要求equals能判断两Person对象属性的值是否都相等

public class Person {
    private String name;
    private int age;
    private char gender;

    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Person() {
    }

    @Override
    public boolean equals(Object obj) {// 重写equals方法
        if (this == obj) {// 若是地址相同，返回true
            return true;
        }
        if (obj instanceof Person) {// 若obj的运行类型是Person
            Person p = (Person) obj;
            if (name == p.name && age == p.age && gender == p.gender) {// 注意：private权限允许在本类中访问，因此p对象可以不用get方法直接调用属性
                return true;// 若两Person对象属性相同，返回true
            }
        }
        return false;
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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}
