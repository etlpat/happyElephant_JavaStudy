package com.experiment03._02_observerPattern.subject;

import com.experiment03._02_observerPattern.observer.Investor;

import java.util.ArrayList;

public class Stock {
    private String name;
    private double price;
    ArrayList<Investor> investors = new ArrayList<>();

    public Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void attach(Investor investor) {
        investors.add(investor);
    }

    public void detach(Investor investor) {
        investors.remove(investor);
    }

    // 当数据发生变动，遍历观察者列表，调用每个观察者的update()方法
    public void notifyInvestor() {
        for (Investor investor : investors) {
            investor.update();
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        // 若股价变动>=5%，则通知观察者
        double change = Math.abs(price - this.price);
        if (change >= this.price * 0.05) {
            System.out.println("股票变动幅度较大，本次变动了：" + (change / this.price * 100) + "%");
            notifyInvestor();
        }
        this.price = price;
    }
}
