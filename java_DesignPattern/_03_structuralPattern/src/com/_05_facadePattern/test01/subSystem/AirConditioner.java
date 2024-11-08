package com._05_facadePattern.test01.subSystem;

public class AirConditioner implements HomeAppliances {
    @Override
    public void on() {
        System.out.println("空调开启~");
    }

    @Override
    public void off() {
        System.out.println("空调关闭~");
    }
}
