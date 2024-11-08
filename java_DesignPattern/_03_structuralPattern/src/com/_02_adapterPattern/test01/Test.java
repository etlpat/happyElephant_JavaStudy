package com._02_adapterPattern.test01;

// 案例：
//  现有一台电脑只能读取SD卡,而要读取TE卡中的内容的话就需要使用到适配器模式。创建一个读卡器,将TE卡中的内容读取出来。
//  分析可得：目标接口为SD卡，适配者类为TF卡，读卡器即为适配器类。

public class Test {
    public static void main(String[] args) {
        SDAdapterTF sdAdapterTF = new SDAdapterTF();

        sdAdapterTF.readSD();
        System.out.println("=============");
        sdAdapterTF.writeSD();

    }
}
