package com.test04;

public class Test {
    public static void main(String[] args) {
        Window windowA = new Window("A窗体");
        windowA.play();
        System.out.println("====================");

        new ScrollBar(windowA).ChangeWindow();
        System.out.println("====================");

        new TextBox(windowA).ChangeWindow();

    }
}
