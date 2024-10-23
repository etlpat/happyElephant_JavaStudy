package com.test01;

public class SmallPen extends Pen {
    public SmallPen() {
        setColor();
        this.penType = "small";
    }

    @Override
    public void setColor() {
        this.myColor = new Red();
    }
}
