package com.test02;

public class _01_Test {
    public static void main(String[] args) {
        // 创建职员对象数组
        _01_Employee[] empArr = new _01_Employee[3];
        empArr[0] = new _01_Employee("张三", 12, 0);
        empArr[1] = new _01_Employee("李四", 24, 3000);
        empArr[2] = new _01_Employee("王五", 48, 7000);

        // for-each循环遍历数组
        for (_01_Employee tmp : empArr) {
            System.out.println(tmp);
            tmp.setSalary(tmp.getSalary() * 1.05);// 工资上涨5%
        }
        System.out.println("**************************");
        for (_01_Employee tmp : empArr) {
            System.out.println(tmp);
        }
    }
}
