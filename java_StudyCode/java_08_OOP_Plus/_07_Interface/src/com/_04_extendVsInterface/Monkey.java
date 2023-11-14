package com._04_extendVsInterface;

public class Monkey {
    private String name;

    public Monkey() {
    }

    public Monkey(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void climbTree() {
        System.out.println("猴子" + name + " 会爬树!");
    }
}
