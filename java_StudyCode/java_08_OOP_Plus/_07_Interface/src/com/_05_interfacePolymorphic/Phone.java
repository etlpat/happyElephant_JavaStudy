package com._05_interfacePolymorphic;

// Phone类实现接口UsbInterface

public class Phone implements UsbInterface {
    private String name;
    public int USB_ID = 0;

    public Phone() {
    }

    public Phone(String name, int USB_ID) {
        this.name = name;
        this.USB_ID = USB_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUSB_ID() {
        return USB_ID;
    }

    public void setUSB_ID(int USB_ID) {
        this.USB_ID = USB_ID;
    }


    // 重写接口中方法
    @Override
    public void start() {
        System.out.println("Phone" + name + " 插入USB接口，开始运行");
    }

    @Override
    public void end() {
        System.out.println("Phone" + name + " 拔出USB接口，结束运行");
    }


    // 新建call方法
    public void call() {
        System.out.println("Phone" + name + " 正在拨号中...");
    }
}
