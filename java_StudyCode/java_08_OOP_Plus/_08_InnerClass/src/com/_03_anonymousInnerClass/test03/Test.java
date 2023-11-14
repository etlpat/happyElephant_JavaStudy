package com._03_anonymousInnerClass.test03;

// 练习案例：
//  1.定义一个铃声接口Bell，其中包含打铃ring方法
//  2.有一个手机类Phone，具有闹钟功能alarmClock，参数是铃声Bell类型
//  3.定义几个基于Bell的不同铃声的匿名内部类，用匿名内部类直接对手机闹钟传参

public class Test {
    public static void main(String[] args) {
        Phone phone = new Phone("诺基亚");


        // 用实现Bell接口的匿名内部类Test$1传参
        phone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("哼，哼，哼，啊啊啊啊，啊啊啊啊啊~");
            }
        });// 诺基亚打铃：哼，哼，哼，啊啊啊啊，啊啊啊啊啊~


        // 用实现Bell接口的匿名内部类Test$2传参
        phone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("小伙伴上课了!~");
            }
        });// 诺基亚打铃：小伙伴上课了!~
    }
}
