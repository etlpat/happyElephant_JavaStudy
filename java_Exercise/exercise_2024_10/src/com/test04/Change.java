package com.test04;

public abstract class Change {
    Window window;

    public Change(Window window) {
        this.window = window;
    }

    public Change() {
    }

    public abstract void ChangeWindow();
}
