package com.experiment03._03_strategyPattern.strategy;

public class TrainStrategy implements TravelStrategy {
    @Override
    public void travel() {
        System.out.println("火车旅游~~");
    }
}
