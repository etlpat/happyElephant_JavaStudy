package com._01_designPatternBasic.test06_syntheticMultiplexing;

public class Car {
    private Color color;
    private Engine engine;

    public Car(Color color, Engine engine) {
        this.color = color;
        this.engine = engine;
    }

    public Car() {
    }

    public void show() {
        color.show();
        engine.show();
    }

    @Override
    public String toString() {
        return "Car{" +
                "color=" + color +
                ", engine=" + engine +
                '}';
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
