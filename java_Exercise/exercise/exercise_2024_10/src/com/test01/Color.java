package com.test01;

public abstract class Color {
    String name = null;

    public abstract void setName();

    @Override
    public String toString() {
        return "Color{" +
                "name='" + name + '\'' +
                '}';
    }
}
