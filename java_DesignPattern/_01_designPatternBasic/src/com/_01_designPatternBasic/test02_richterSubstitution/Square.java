package com._01_designPatternBasic.test02_richterSubstitution;

public class Square implements Quadrilateral {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public Square() {
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getLength() {
        return getSide();
    }

    @Override
    public double getWidth() {
        return getSide();
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                '}';
    }
}
