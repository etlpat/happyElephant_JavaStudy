package com._01_equals.equalsTest;

public class Test {
    public static void main(String[] args) {
        Person p1 = new Person("jimmy", 18, '男');
        Person p2 = p1;
        Person p3 = new Person("jimmy", 18, '男');
        Person p4 = new Person("张三", 18, '男');
        String s = new String("hello");

        // Person中的equals方法已被重写为：判断两Person对象的属性是否相同
        System.out.println(p1.equals(p2));// true
        System.out.println(p1.equals(p3));// true
        System.out.println(p1.equals(p4));// false
        System.out.println(p1.equals(s));// false
    }
}
