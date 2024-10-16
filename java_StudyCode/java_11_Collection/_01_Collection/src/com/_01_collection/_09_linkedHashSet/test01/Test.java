package com._01_collection._09_linkedHashSet.test01;

// 案例：有Car类(name,price)，将Car对象添加到LinkedHashSet
//      要求当Car的name和price均相同时，视为同一个元素。

import java.util.LinkedHashSet;

public class Test {
    public static void main(String[] args) {
        LinkedHashSet<Car> cars = new LinkedHashSet<>();

        cars.add(new Car("奥迪", 1000));
        cars.add(new Car("奥迪", 1000000));
        cars.add(new Car("法拉利", 3000000));
        cars.add(new Car("法拉利", 7000000));

        System.out.println(cars);

        // 测试加入重复元素
        System.out.println(cars.add(new Car("奥迪", 1000)));
        System.out.println(cars.add(new Car("法拉利", 3000000)));
        System.out.println(cars);
    }
}
