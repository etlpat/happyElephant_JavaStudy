package com.test3;

// 案例：
//  创建computer接口，具有work方法
//  创建phone类，定义方法testWork，用于测试计算机接口的work功能

public class Test3 {
    public static void main(String[] args) {
        Phone phone = new Phone();

        phone.testWork(new Computer() {
            @Override
            public void work() {
                System.out.println("计算机接口1成功接入");
            }
        });
    }
}
