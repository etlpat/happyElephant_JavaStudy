package com._03_anonymousInnerClass.test02;

// 匿名内部类直接作为函数参数传参

public class Test {
    public static void main(String[] args) {
        Computer computer = new Computer("菠萝电脑");


        // 将匿名内部类作为参数传参（匿名内部类在定义的同时创建对象）
        computer.useUsbEquipment(new UsbInterface() {// 匿名内部类实现接口UsbInterface
            @Override
            public void start() {
                System.out.println("手机接入usb接口");
            }

            @Override
            public void end() {
                System.out.println("手机拔出usb接口");
            }
        });
        //Usb设备成功接入菠萝电脑
        //手机接入usb接口
        //手机拔出usb接口
        //class com._03_anonymousInnerClass.test02.Test$1

        // 注意：该匿名内部类是Test类中第一个匿名内部类，因此默认类名为Test$1
    }
}
