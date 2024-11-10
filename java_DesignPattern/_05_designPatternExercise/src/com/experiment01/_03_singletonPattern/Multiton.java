package com.experiment01._03_singletonPattern;

import java.util.ArrayList;

public class Multiton {
    private static ArrayList<Multiton> instances = new ArrayList<>();

    // 为该类安排3个对象
    static {
        instances.add(new Multiton());
        instances.add(new Multiton());
        instances.add(new Multiton());
    }


    private Multiton() {
    }

    // 随机返回实例
    public static Multiton getInstance() {
        return instances.get(Multiton.random());
    }

    // 获取[0/1/2]随机数，对应多例对象的下标
    public static int random() {
        return (int) (Math.random() * 3);
    }
}
