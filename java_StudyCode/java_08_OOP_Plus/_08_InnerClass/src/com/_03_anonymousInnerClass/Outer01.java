package com._03_anonymousInnerClass;

// 例1：基于接口的匿名内部类
// 本质：匿名内部类实现了Behavior接口


public class Outer01 {

    public void method1() {

        // 【定义匿名内部类的同时创建对象】
        // tiger的编译类型是Behavior接口类型，运行类型是实现接口的匿名内部类Outer01$1
        Behavior tiger = new Behavior() {// 基于Behavior接口，实现匿名内部类
            @Override
            public void eat() {
                System.out.println("好虎在吃肉");
            }

            @Override
            public void cry() {
                System.out.println("老虎在叫唤");
            }
        };

        // 调用匿名内部类的对象
        tiger.eat();
        tiger.cry();
        // 打印匿名内部类的类名（由系统自动分配，为Outer01$1）
        System.out.println(tiger.getClass());//class com._03_anonymousInnerClass.Outer01$1
    }


    public void method2() {
        // 外部类Outer01中的第2个匿名内部类，默认分配的类名为Outer01$2
        Behavior b = new Behavior() {
            public void eat() {
            }

            public void cry() {
            }
        };

        System.out.println(b.getClass());//class com._03_anonymousInnerClass.Outer01$2
    }
}


// Behavior：行为
interface Behavior {
    public abstract void eat();

    public abstract void cry();
}