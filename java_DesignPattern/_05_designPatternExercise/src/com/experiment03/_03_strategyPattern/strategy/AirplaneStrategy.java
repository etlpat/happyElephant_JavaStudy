package com.experiment03._03_strategyPattern.strategy;

public class AirplaneStrategy implements TravelStrategy {
    @Override
    public void travel() {
        System.out.println("飞机旅游~~");
    }
}
