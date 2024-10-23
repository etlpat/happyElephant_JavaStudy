package com.test09;

// 观察者：玩家
public class Player implements Observer {
    private String name;

    public Player(String name) {
        this.name = name;
    }


    @Override
    public void request(Subject subject) {
        System.out.println(name + "：我重伤倒地！ -- 呼叫指挥部");
        subject.notifyObservers(this);
    }

    @Override
    public void response(Observer o) {
        Player p = (Player) o;
        System.out.println(name + " 前往救援 " + p.name + "!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
