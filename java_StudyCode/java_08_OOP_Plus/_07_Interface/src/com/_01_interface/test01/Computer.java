package com._01_interface.test01;

public class Computer {

    // 计算机工作
    public void work(UsbInterface usbInterface) {
        System.out.println("设备与电脑连接成功");
        // 通过接口，调用方法
        usbInterface.start();
        usbInterface.end();
    }

}
