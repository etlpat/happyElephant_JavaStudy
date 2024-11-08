package com._01_designPatternBasic.test05_demeterRule;

public class Star {
    private String name;

    public Star(String nane) {
        this.name = nane;
    }

    public Star() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Star{" +
                "nane='" + name + '\'' +
                '}';
    }
}
