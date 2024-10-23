package com.test08;

public class Dog extends Observer {
    @Override
    public void update() {
        System.out.println("狗叫：汪汪汪！");
    }
}
