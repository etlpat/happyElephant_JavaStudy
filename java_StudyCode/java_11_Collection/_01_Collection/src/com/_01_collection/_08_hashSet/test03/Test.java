package com._01_collection._08_hashSet.test03;

// 案例：
//      定义一个Employee类，该类包含name,sal,birthday属性
//      其中birthday是自定义的MyDate类(属性包括year,month,day)
//      要求：①创建3个Employee放入HashSet中
//          ②当name和birthday相同时，任务是相同员工，不能重复添加到HashSet中。
//

import java.util.HashSet;

public class Test {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();

        System.out.println(hashSet.add(new Employee("张三", 17, new MyDate(2020, 10, 1))));
        System.out.println(hashSet.add(new Employee("李四", 13, new MyDate(2010, 6, 12))));
        System.out.println(hashSet.add(new Employee("王五", 26, new MyDate(2000, 8, 23))));
        System.out.println(hashSet);

        System.out.println(hashSet.add(new Employee("张三", 17, new MyDate(2020, 10, 1))));
        System.out.println(hashSet.add(new Employee("李四", 13, new MyDate(2010, 6, 12))));
        System.out.println(hashSet);
    }
}
