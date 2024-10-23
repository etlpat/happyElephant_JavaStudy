package com.test04;

public class TextBox extends Change {
    public TextBox(Window window) {
        super(window);
    }

    public TextBox() {
    }

    @Override
    public void ChangeWindow() {
        System.out.println("文本框↑");
        window.play();
        System.out.println("文本框↓");
    }
}
