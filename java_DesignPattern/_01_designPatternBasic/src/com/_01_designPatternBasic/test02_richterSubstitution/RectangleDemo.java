package com._01_designPatternBasic.test02_richterSubstitution;

public class RectangleDemo {

    // 使得长方形的length++，直到大于width
    public void resize(Rectangle r) {
        while (r.getLength() <= r.getWidth()) {
            r.setLength(r.getLength() + 1);
        }
    }
}
