package com._06_override;

// 方法重写题目
// 要求：
//  1.编写一个Person类，包括私有属性name、age，构造器，方法say返回自我介绍的字符串
//  2.编写一个Student类，继承Person类，增加私有属性id、score，重写say方法
//  3.创建类对象测试两个类，调用say方法


public class OverrideExercise {
    public static void main(String[] args) {
        Person p = new Person("张三", 37);
        Student s = new Student("jimmy", 20, "114514", 98.5);

        System.out.println(p.say());// 姓名：张三，年龄：37
        System.out.println(s.say());// 姓名：jimmy，年龄：20，id：114514，分数：98.5
    }
}


class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        setName(name);
        setAge(age);
    }

    public Person() {
    }

    public String say() {
        return "姓名：" + getName() + "，年龄：" + getAge();
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
}


class Student extends Person {
    private String id;
    private double score;

    public Student() {
    }

    public Student(String name, int age, String id, double score) {
        super(name, age);
        setId(id);
        setScore(score);
    }

    public String say() {// 子类重写say()方法
        return super.say() + "，id：" + getId() + "，分数：" + getScore();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
