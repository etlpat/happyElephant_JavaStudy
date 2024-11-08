package com._05_facadePattern.test01.facade;

// 外观类：SmartSpeaker智能音箱
//  可以控制所有家电统一开启/关闭

import com._05_facadePattern.test01.subSystem.AirConditioner;
import com._05_facadePattern.test01.subSystem.Light;
import com._05_facadePattern.test01.subSystem.TV;

public class SmartSpeaker {
    private Light light;
    private TV tv;
    private AirConditioner airConditioner;

    public SmartSpeaker() {
        light = new Light();
        tv = new TV();
        airConditioner = new AirConditioner();
    }

    public SmartSpeaker(Light light, TV tv, AirConditioner airConditioner) {
        this.light = light;
        this.tv = tv;
        this.airConditioner = airConditioner;
    }


    // 调用全部电器的on方法
    public void on() {
        light.on();
        tv.on();
        airConditioner.on();
    }

    // 调用全部电器的off方法
    public void off() {
        light.off();
        tv.off();
        airConditioner.off();
    }


    public Light getLight() {
        return light;
    }

    public void setLight(Light light) {
        this.light = light;
    }

    public TV getTv() {
        return tv;
    }

    public void setTv(TV tv) {
        this.tv = tv;
    }

    public AirConditioner getAirConditioner() {
        return airConditioner;
    }

    public void setAirConditioner(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }
}
