package com._05_facadePattern.test01.subSystem;

public class Light implements HomeAppliances {
    @Override
    public void on() {
        System.out.println("电灯开启~");
    }

    @Override
    public void off() {
        System.out.println("电灯关闭~");
    }
}
