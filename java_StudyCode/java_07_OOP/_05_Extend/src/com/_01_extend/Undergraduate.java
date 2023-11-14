package com._01_extend;

/**
 * Undergraduate：大学生类
 * 对父类Student的exam方法进行重写
 */

public class Undergraduate extends Student {
    public String undergraduateSubject = "高等数学";

    public void exam() {
        System.out.println("大学生" + name + "在考" + undergraduateSubject);
    }
}
