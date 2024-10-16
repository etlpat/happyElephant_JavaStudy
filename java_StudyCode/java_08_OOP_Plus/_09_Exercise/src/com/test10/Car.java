package com.test10;

public class Car {
    private double temperature;
    private Air air = new Air();


    public Car(double temperature) {
        this.temperature = temperature;
    }


    public void useAir() {
        air.flow();
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }


    // 内部类 -- 空调
    public class Air {
        public void flow() {
            if (temperature > 40) {
                System.out.println("空调吹冷气");
            } else if (temperature < 0) {
                System.out.println("空调吹热气");
            } else {
                System.out.println("空调不运作");
            }
        }
    }
}
