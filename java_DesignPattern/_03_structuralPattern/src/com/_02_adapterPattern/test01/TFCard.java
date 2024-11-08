package com._02_adapterPattern.test01;

// TF卡为适配者方法

public class TFCard {
    // 读方法
    public void readTF() {
        System.out.println("读取TF卡内容...");
    }

    // 写方法
    public void writeTF() {
        System.out.println("写入TF卡内容...");
    }
}
