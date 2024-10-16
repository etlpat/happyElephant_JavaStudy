package com._01_collection._08_hashSet.test02;

// 案例：定义Employee类，有姓名和年龄
//      创建3个Employee对象放入HashSet中，
//      要求当姓名年龄均相同，视为同一个人，不可添加.
//
// 分析：向HashSet添加元素，先按照Hash值，寻找对应的链表，
//          找到链表后，再靠equals()逐一比对。
//      因此，若想使得属性值相同的元素被HashSet视为重复元素，
//          不仅需要重写equals()方法，
//          还需要重写hashCode()方法，保证值相同的对象返回相同的哈希码。


import java.util.HashSet;

public class Test {
    public static void main(String[] args) {
        HashSet<Employee> employees = new HashSet<>();

        System.out.println(employees.add(new Employee("张三", 11)));
        System.out.println(employees.add(new Employee("李四", 12)));
        System.out.println(employees.add(new Employee("王五", 13)));

        System.out.println(employees);

        System.out.println(employees.add(new Employee("张三", 11)));
        System.out.println(employees.add(new Employee("李四", 12)));

        System.out.println(employees);
    }
}
