package com._01_interface.test01;

public class Test {
    public static void main(String[] args) {
        // (1)创建手机、相机对象（接口的实现）
        Camera camera = new Camera();
        Phone phone = new Phone();

        // (2)创建电脑对象
        Computer computer = new Computer();

        // (3)电脑的方法调用接口
        computer.work(camera);
//        设备与电脑连接成功
//        相机开始运行
//        相机停止运行
        System.out.println("================");
        computer.work(phone);
//        设备与电脑连接成功
//        手机开始运行
//        手机停止运行
    }
}
