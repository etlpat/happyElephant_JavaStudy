package com._04_finalize;

public class Car {
    private String name;

    public Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {// 重写finalize方法
        System.out.println("Car的finalize()被调用...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Car{name='" + name + "\'}";
    }
}
