package com._01_interface.test01;

// 手机类实现接口

public class Phone implements UsbInterface {
    @Override
    public void start() {
        System.out.println("手机开始运行");
    }

    @Override
    public void end() {
        System.out.println("手机停止运行");
    }
}
