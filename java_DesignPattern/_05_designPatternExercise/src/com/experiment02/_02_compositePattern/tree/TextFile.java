package com.experiment02._02_compositePattern.tree;

public class TextFile extends AbstractFile {
    public TextFile() {
    }

    public TextFile(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println("--显示文本文件:" + getName());
    }
}
