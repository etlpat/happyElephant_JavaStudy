package com.test03;

public class ImagineFile extends Document {
    public ImagineFile(String name) {
        super(name);
    }

    public ImagineFile() {

    }

    @Override
    public void killVirus() {
        System.out.println("name:" + name + " 图像文件杀毒~");
    }
}
