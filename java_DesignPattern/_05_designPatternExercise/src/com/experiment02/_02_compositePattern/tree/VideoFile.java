package com.experiment02._02_compositePattern.tree;

public class VideoFile extends AbstractFile {
    public VideoFile() {
    }

    public VideoFile(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println("--显示视频文件:" + getName());
    }
}
