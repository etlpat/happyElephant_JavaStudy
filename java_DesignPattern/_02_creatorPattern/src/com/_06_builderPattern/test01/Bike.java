package com._06_builderPattern.test01;

// 产品类

public class Bike {
    // 车架
    private String frame;
    // 车座
    private String seat;


    public Bike() {
    }


    @Override
    public String toString() {
        return "Bike{" +
                "frame='" + frame + '\'' +
                ", seat='" + seat + '\'' +
                '}';
    }


    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }
}
