package com.test01;

/**
 * 案例1
 * 要求：
 * 1.定义一个Person类{name, age, job}
 * 2.创建一个Person[5]数组，初始化数组元素
 * 3.按照age大小，对数组进行冒泡排序
 */

public class Test {
    public static void main(String[] args) {
        Person[] pArr = new Person[5];
        pArr[0] = new Person("张三", 47, "工程师");
        pArr[1] = new Person("李四", 34, "律师");
        pArr[2] = new Person("王五", 18, "学生");
        pArr[3] = new Person("小明", 78, "教授");
        pArr[4] = new Person("小红", 5, "博士");

        MyTools tools = new MyTools();
        tools.bubbleSort(pArr);
        tools.printArr(pArr);
        // 排序结果如下：
//        index:0, Person{name='小红', age=5, job='博士'}
//        index:1, Person{name='王五', age=18, job='学生'}
//        index:2, Person{name='李四', age=34, job='律师'}
//        index:3, Person{name='张三', age=47, job='工程师'}
//        index:4, Person{name='小明', age=78, job='教授'}
    }
}
