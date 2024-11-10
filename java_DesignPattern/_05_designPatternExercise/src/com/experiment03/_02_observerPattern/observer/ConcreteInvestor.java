package com.experiment03._02_observerPattern.observer;

public class ConcreteInvestor implements Investor {
    public String name;

    public ConcreteInvestor() {
    }

    public ConcreteInvestor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public void update() {
        System.out.println("股票观察者 “" + name + "” 收到通知！");
    }
}
