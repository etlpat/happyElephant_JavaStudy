package com._01_collection._09_linkedHashSet.test01;

import java.util.Objects;

public class Car {
    private String name;
    private double prive;

    public Car(String name, double prive) {
        this.name = name;
        this.prive = prive;
    }

    public Car() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(prive, car.prive) == 0 && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, prive);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", prive=" + prive +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrive() {
        return prive;
    }

    public void setPrive(double prive) {
        this.prive = prive;
    }
}
