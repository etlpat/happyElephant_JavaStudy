package com.test9;

public class Horse implements Vehicles {
    @Override
    public void work() {
        System.out.println("Horse works");
    }

    @Override
    public String toString() {
        return "Horse{}";
    }
}
