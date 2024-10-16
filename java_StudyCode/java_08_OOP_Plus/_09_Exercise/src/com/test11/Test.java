package com.test11;

public class Test {
    public static void main(String[] args) {
        for (Color c : Color.values()) {
            c.showColor();
        }

        //Color:RED{redValue=255, greenValue=0, blueValue=0}
        //Color:BLUE{redValue=0, greenValue=0, blueValue=255}
        //Color:BLACK{redValue=0, greenValue=0, blueValue=0}
        //Color:YELLOW{redValue=255, greenValue=255, blueValue=0}
        //Color:GREEN{redValue=0, greenValue=255, blueValue=0}
    }
}
