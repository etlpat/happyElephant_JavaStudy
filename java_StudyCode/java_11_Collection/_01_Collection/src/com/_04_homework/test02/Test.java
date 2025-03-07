package com._04_homework.test02;

// 按要求完成下列任务
//  (1)使用HashMap类实例化一个Map类型的对象m,
//      键(String)和值(int)分别用于存储员工的姓名和工资,
//      存入数据如下: jack-650元;tom-1200元;smith-2900元;
//  (2)将jack的工资更改为2600元
//  (3)为所有员工工资加薪100元;
//  (4)遍历集合中所有的员工
//  (5)遍历集合中所有的工资


import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        // 创建Map集合
        Map m = new HashMap();
        m.put("jack", 650);
        m.put("tom", 1200);
        m.put("smith", 2900);
        System.out.println(m);

        // 修改k对应的v
        m.put("jack", 2600);
        System.out.println(m);


        // 遍历集合，并修改value
        for (Object o : m.entrySet()) {
            Map.Entry e = (Map.Entry) o;
            e.setValue((Integer) e.getValue() + 100);
            System.out.print(e.getKey() + "=" + e.getValue() + "  ");
        }
        System.out.println();


        // 遍历keySet
        for (Object key : m.keySet()) {
            System.out.print(key + "=" + m.get(key) + "  ");
        }
        System.out.println();


        // 遍历values
        for (Object value : m.values()) {
            System.out.print(value + "  ");
        }
        System.out.println();

    }
}
