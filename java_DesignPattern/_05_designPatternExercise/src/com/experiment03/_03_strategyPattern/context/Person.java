package com.experiment03._03_strategyPattern.context;

import com.experiment03._03_strategyPattern.strategy.TravelStrategy;

public class Person {
    TravelStrategy travelStrategy;

    public Person() {
    }

    public Person(TravelStrategy travelStrategy) {
        this.travelStrategy = travelStrategy;
    }

    public TravelStrategy getTravelStrategy() {
        return travelStrategy;
    }

    public void setTravelStrategy(TravelStrategy travelStrategy) {
        this.travelStrategy = travelStrategy;
    }

    public void travel() {
        System.out.print("我出去旅游了，这次选择" + travelStrategy.getClass().getSimpleName() + "策略：");
        travelStrategy.travel();
    }
}
