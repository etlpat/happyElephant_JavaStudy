package com.test09;

import java.util.Observable;

// 观察者接口
public interface Observer {
    public void request(Subject subject);

    public void response(Observer o);
}
