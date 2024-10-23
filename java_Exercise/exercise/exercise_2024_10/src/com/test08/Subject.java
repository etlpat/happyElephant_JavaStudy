package com.test08;

// 观察目标
public abstract class Subject {
    public abstract void attach(Observer o);

    public abstract void detach(Observer o);

    // 提醒观察者
    public abstract void notifyObservers();
}
