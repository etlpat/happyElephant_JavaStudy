package com.test1;

public class Frock {
    public static int currentNum = 1000;
    private int serialNum;

    public Frock() {
        serialNum = getNextNum();
    }

    public static int getNextNum() {
        return ++currentNum;
    }

    public int getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(int serialNum) {
        this.serialNum = serialNum;
    }

    @Override
    public String toString() {
        return "Frock{" +
                "服装编号=" + serialNum +
                '}';
    }
}
