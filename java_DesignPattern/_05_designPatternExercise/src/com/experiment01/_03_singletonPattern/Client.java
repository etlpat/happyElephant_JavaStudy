package com.experiment01._03_singletonPattern;

public class Client {
    public static void main(String[] args) {
        // 获取100次多例的对象，其地址始终是3个中的任一个
        for (int i = 0; i < 100; i++) {
            Multiton instance = Multiton.getInstance();
            System.out.println(instance.hashCode());
        }
    }
}
