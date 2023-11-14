package com._01_interface.test01;

// 相机类实现接口

public class Camera implements UsbInterface {
    @Override
    public void start() {
        System.out.println("相机开始运行");
    }

    @Override
    public void end() {
        System.out.println("相机停止运行");
    }
}
