package com._06_builderPattern.test01;

// 抽象构建者，用于规范复杂对象零件的创建

public abstract class AbstractBuilder {
    // 构建的产品
    private Bike bike;

    public AbstractBuilder() {
        this.bike = new Bike();
    }


    // 构建车架
    public abstract void buildFrame();

    // 构建车座
    public abstract void buildSeat();


    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }
}
