package com._03_anonymousInnerClass.test02;

public class Computer {
    private String name;

    public Computer(String name) {
        this.name = name;
    }

    public Computer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 使用usb设备的类
    public void useUsbEquipment(UsbInterface usbInterface) {
        System.out.println("Usb设备成功接入" + name);
        usbInterface.start();
        usbInterface.end();
        System.out.println(usbInterface.getClass());
    }
}
