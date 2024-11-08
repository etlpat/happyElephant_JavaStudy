package com._05_facadePattern.test01;

// 案例：智能家电控制
//  小明的爷爷已经60岁了,一个人在家生活:
//  每次都需要打开灯Light、打开电视TV、打开空调AirConditioner;
//  睡觉时关闭灯、关闭电视、关闭空调，操作起来都比较麻烦。
//  所以小明给爷爷买了智能音箱SmartSpeaker,可以直接控制这些智能家电统一开启和关闭。

import com._05_facadePattern.test01.facade.SmartSpeaker;
import com._05_facadePattern.test01.subSystem.AirConditioner;
import com._05_facadePattern.test01.subSystem.Light;
import com._05_facadePattern.test01.subSystem.TV;

public class Test {
    public static void main(String[] args) {
        // 创建家电对象
        Light light = new Light();
        TV tv = new TV();
        AirConditioner airConditioner = new AirConditioner();

        // 创建外观对象（智能音箱）
        SmartSpeaker smartSpeaker = new SmartSpeaker(light, tv, airConditioner);


        // 外观对象控制家电统一on/off
        smartSpeaker.on();
        System.out.println("=============");

        smartSpeaker.off();
    }
}
