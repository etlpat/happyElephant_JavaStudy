package com._01_designPatternBasic.test05_demeterRule;

public class Fans {
    private String name;

    public Fans(String name) {
        this.name = name;
    }

    public Fans() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Fans{" +
                "name='" + name + '\'' +
                '}';
    }
}
