package com.experiment03._03_strategyPattern.strategy;

public class WalkStrategy implements TravelStrategy {
    @Override
    public void travel() {
        System.out.println("步行旅游~~");
    }
}
