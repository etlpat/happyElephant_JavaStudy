package com._05_facadePattern.test01.subSystem;

public class TV implements HomeAppliances {
    @Override
    public void on() {
        System.out.println("电视开启~");
    }

    @Override
    public void off() {
        System.out.println("电视关闭~");
    }
}
