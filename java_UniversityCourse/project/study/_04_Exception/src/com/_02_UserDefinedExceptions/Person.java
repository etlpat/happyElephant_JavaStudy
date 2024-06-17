package com._02_UserDefinedExceptions;

public class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        if (age >= 0 && age <= 130) {
            this.age = age;
        } else {
            // 中断程序执行，抛出异常
            // 这里为异常类传入字符串参数，在报异常时会打印该字符串（若不传，则不打印提示信息）
            throw new AgeIllegalRuntimeException("异常：年龄超出[0,130]的范围，你输入的年龄：" + age);
        }
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
