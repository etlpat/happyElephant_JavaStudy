package com._06_builderPattern.test01;

// 指挥者类，用于组装构建的对象

public class Director {
    // 要组装的构建者对象
    AbstractBuilder builder;

    public Director() {
    }

    public Director(AbstractBuilder builder) {
        this.builder = builder;
    }

    // 组装自行车
    public Bike constructBike() {
        if (builder == null) {
            return null;
        }

        // 组装车架
        builder.buildFrame();
        // 组装车座
        builder.buildSeat();

        return builder.getBike();
    }


    public AbstractBuilder getBuilder() {
        return builder;
    }

    public void setBuilder(AbstractBuilder builder) {
        this.builder = builder;
    }
}
