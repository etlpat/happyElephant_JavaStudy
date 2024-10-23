package com.test04;

public class Window {
    public String name;

    public Window(String name) {
        this.name = name;
    }

    public Window() {
    }

    public void play() {
        System.out.println("这是窗体:" + name + "~");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
