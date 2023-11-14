package com.test05;

/**
 * 要求：定义Doctor类{name, age, job, salary}
 * 重写equals方法，改为判断属性是否相同
 */

public class Test {
    public static void main(String[] args) {
        Doctor d1 = new Doctor("张三", 44, "主任", 8888);
        Doctor d2 = d1;
        Doctor d3 = new Doctor("张三", 44, "主任", 8888);
        Doctor d4 = new Doctor("张三", 55, "主任", 8888);
        Doctor d5 = new Doctor("李四", 66, "护士", 5555);

        System.out.println(d1.equals(d2));// true
        System.out.println(d1.equals(d3));// true
        System.out.println(d1.equals(d4));// false
        System.out.println(d1.equals(d5));// false

    }
}
