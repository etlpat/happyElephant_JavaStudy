package com.test03;

public abstract class Document {
    public String name;

    public Document(String name) {
        this.name = name;
    }

    public Document() {
    }

    public abstract void killVirus();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
