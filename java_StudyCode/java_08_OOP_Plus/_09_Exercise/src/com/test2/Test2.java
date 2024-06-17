package com.test2;

// 案例：
//  1.实现动物类Animal包含shout抽象方法
//  2.Cat继承Animal，实现shout方法，打印“喵喵喵”
//  3.Dog继承Animal，实现shout方法，打印“汪汪汪”
//  4.在测试类中实例化Animal数组，存放Cat和Dog类对象


public class Test2 {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Animal("Cat") {
            @Override
            public void shout() {
                System.out.println(name + ":喵喵喵");
            }
        };
        animals[1] = new Animal("Dog") {
            @Override
            public void shout() {
                System.out.println(name + ":汪汪汪");
            }
        };

        animals[0].shout();
        animals[1].shout();
    }
}
