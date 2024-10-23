package com.test04;

public class ScrollBar extends Change {
    public ScrollBar(Window window) {
        super(window);
    }

    public ScrollBar() {
    }

    @Override
    public void ChangeWindow() {
        System.out.println("滚筒条↑");
        window.play();
        System.out.println("滚筒条↓");
    }
}
