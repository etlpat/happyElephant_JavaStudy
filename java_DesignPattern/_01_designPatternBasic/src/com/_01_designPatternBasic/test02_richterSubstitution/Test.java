package com._01_designPatternBasic.test02_richterSubstitution;

// 案例：（反例）正方形 != 长方形

public class Test {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(15, 20);
        System.out.println(rectangle);
        new RectangleDemo().resize(rectangle);
        System.out.println(rectangle);

        System.out.println("===========");

        Square square = new Square(5);
        System.out.println(square);

    }
}
