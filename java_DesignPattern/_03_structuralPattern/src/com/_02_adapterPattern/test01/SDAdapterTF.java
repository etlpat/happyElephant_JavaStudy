package com._02_adapterPattern.test01;

// 适配器方法：
//  实现SD目标接口，SD接口的方法内部调用适配者TF的方法

public class SDAdapterTF implements SDCard {
    private TFCard tfCard = new TFCard();

    @Override
    public void readSD() {
        System.out.println("执行SD卡的读取方法：");
        tfCard.readTF();
    }

    @Override
    public void writeSD() {
        System.out.println("执行SD卡的写入方法：");
        tfCard.writeTF();
    }
}
