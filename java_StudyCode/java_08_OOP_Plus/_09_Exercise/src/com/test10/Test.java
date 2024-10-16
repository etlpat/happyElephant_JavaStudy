package com.test10;

public class Test {
    public static void main(String[] args) {
        Car car = new Car(114.514);
        car.useAir();// 空调吹冷气

        car.setTemperature(11.45);
        car.useAir();// 空调不运作

        car.setTemperature((-1.14));
        car.useAir();// 空调吹热气
    }
}
