package com.experiment03._03_strategyPattern.strategy;

public class BicycleStrategy implements TravelStrategy{
    @Override
    public void travel() {
        System.out.println("单车旅游~~");
    }
}
