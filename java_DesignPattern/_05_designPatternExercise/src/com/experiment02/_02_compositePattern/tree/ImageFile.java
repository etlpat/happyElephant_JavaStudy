package com.experiment02._02_compositePattern.tree;

public class ImageFile extends AbstractFile {
    public ImageFile() {
    }

    public ImageFile(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println("--显示图像文件:" + getName());
    }
}
