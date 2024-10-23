package com.test09;

import java.util.ArrayList;

// 观察目标：指挥部
public class Headquarters implements Subject {
    private ArrayList<Observer> observersHashSet;

    public Headquarters() {
        observersHashSet = new ArrayList<>();
    }

    @Override
    public void attach(Observer o) {
        observersHashSet.add(o);
    }

    @Override
    public void detach(Observer o) {
        observersHashSet.remove(o);
    }

    // 通知全体玩家：参数玩家被攻击
    @Override
    public void notifyObservers(Observer o) {
        System.out.println("指挥部通知全体成员：");
        for (Observer player : observersHashSet) {
            if (!player.equals(o)) {
                player.response(o);
            }
        }
    }
}
