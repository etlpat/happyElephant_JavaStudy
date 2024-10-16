package com.test9;

public class Boat implements Vehicles {
    @Override
    public void work() {
        System.out.println("Boat works");
    }

    @Override
    public String toString() {
        return "Boat{}";
    }
}
