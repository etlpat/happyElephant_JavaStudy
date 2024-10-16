package com.test5;

public class Frock {
    // 公有序列号，初始为100000
    private static int currentNum = 100000;

    // 对象的序列号
    private int serialNum;


    // 构造器
    public Frock() {
        serialNum = getNextNum();
    }


    // 生成上衣序列号
    public static int getNextNum() {
        currentNum += 100;
        return currentNum;
    }

    public int getSerialNum() {
        return serialNum;
    }
}
