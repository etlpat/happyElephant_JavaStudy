package com._01_extend;

/**
 * Pupil：小学生类
 * 对父类Student的exam方法进行重写
 */

public class Pupil extends Student{
    public String pupilSubject = "小学数学";

    public void exam() {
        System.out.println("小学生" + name + "在考" + pupilSubject);
    }
}
