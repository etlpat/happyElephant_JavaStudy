package com._02_generic.test01;

// 练习:
//  1.创建3个学生对象
//  2.放入到HashMap中,要求Key是String name,Value就是学生对象
//  3.使用两种方式遍历

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Student student1 = new Student("张三", 18);
        Student student2 = new Student("李四", 28);
        Student student3 = new Student("王五", 15);

        // 创建HashMap，并使用泛型
        HashMap<String, Student> studentMap = new HashMap<>();

        studentMap.put(student1.getName(), student1);
        studentMap.put(student2.getName(), student2);
        studentMap.put(student3.getName(), student3);
        System.out.println(studentMap);
        System.out.println("=================================");


        // 遍历方式1
        Set<Map.Entry<String, Student>> entries = studentMap.entrySet();
        for (Map.Entry entry : entries) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
        System.out.println("=================================");


        // 遍历方式2
        Set<String> keySet = studentMap.keySet();
        for (String key : keySet) {
            System.out.println(key + "=" + studentMap.get(key));
        }
    }
}
