package com.experiment03._03_strategyPattern;

import com.experiment03._03_strategyPattern.context.Person;
import com.experiment03._03_strategyPattern.strategy.AirplaneStrategy;
import com.experiment03._03_strategyPattern.strategy.BicycleStrategy;
import com.experiment03._03_strategyPattern.strategy.TrainStrategy;
import com.experiment03._03_strategyPattern.strategy.WalkStrategy;

public class Client {
    public static void main(String[] args) {
        // (1)设置环境类 -- person
        Person person = new Person();


        // (2)为person提供不同的旅游策略
        // 飞机旅游
        person.setTravelStrategy(new AirplaneStrategy());
        person.travel();

        // 自行车旅游
        person.setTravelStrategy(new BicycleStrategy());
        person.travel();

        // 火车旅游
        person.setTravelStrategy(new TrainStrategy());
        person.travel();

        // 徒步旅游
        person.setTravelStrategy(new WalkStrategy());
        person.travel();
    }
}
