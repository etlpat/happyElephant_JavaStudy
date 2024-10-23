package com.test08;

import java.util.HashSet;

public class Cat extends Subject {
    // 该观察目标所对应的观察者集合
    private HashSet<Observer> observers;

    public Cat() {
        this.observers = new HashSet<>();
    }

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        // 提醒观察者（遍历每一个观察者的update方法）
        for (Observer o : observers) {
            o.update();
        }
    }

    public void cry() {
        System.out.println("猫叫：喵喵喵！");

        // 叫声触发notify
        notifyObservers();
    }
}
