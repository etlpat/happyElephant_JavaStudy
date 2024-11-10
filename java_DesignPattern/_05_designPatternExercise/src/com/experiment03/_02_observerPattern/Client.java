package com.experiment03._02_observerPattern;

import com.experiment03._02_observerPattern.observer.ConcreteInvestor;
import com.experiment03._02_observerPattern.subject.Stock;

public class Client {
    public static void main(String[] args) {
        // 创建股票，并添加观察者
        Stock stock = new Stock("大象股票", 100);
        stock.attach(new ConcreteInvestor("张三"));
        stock.attach(new ConcreteInvestor("李四"));
        stock.attach(new ConcreteInvestor("王五"));


        // 修改股价
        System.out.println("############第1次变动############");
        stock.setPrice(106);

        System.out.println("############第2次变动############");
        stock.setPrice(102);

        System.out.println("############第3次变动############");
        stock.setPrice(51);
    }
}
