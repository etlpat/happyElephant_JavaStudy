package com._03_anonymousInnerClass.test03;

// 手机类，其中包含参数为Bell接口类型的闹钟方法alarmClock

public class Phone {
    private String name;

    public Phone(String name) {
        this.name = name;
    }

    public Phone() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 闹钟方法
    public void alarmClock(Bell bell) {
        System.out.print(name + "打铃：");
        bell.ring();
        //System.out.println(bell.getClass());
    }
}
