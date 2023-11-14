package com._02_staticMethod;

public class Student {
    private String name;
    private double fee;// 每个对象的学费
    private static double totalFee = 0;// 总学费

    public Student(String name, double fee) {
        this.name = name;
        this.fee = fee;
        payFee();
    }

    private void payFee() {
        // 普通方法中可以访问静态成员
        totalFee += fee;
        System.out.println("交费成功");
    }

    public static void printTotalFee() {
        // 静态方法中不能访问非静态成员
        System.out.println("总学费为：" + totalFee);
    }

    public String getName() {
        return name;
    }

    public double getFee() {
        return fee;
    }

    public static double getTotalFee() {
        return totalFee;
    }
}
