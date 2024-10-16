package com.test01;

public abstract class Pen {
    Color myColor = null;
    String penType = null;

    public abstract void setColor();

    public void draw() {
        System.out.println("Pen Color: " + myColor + "; Pen Type: " + penType);
    }

    ;
}
