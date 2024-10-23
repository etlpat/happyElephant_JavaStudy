package com.test03;

public class TextFile extends Document{
    public TextFile(String name) {
        super(name);
    }

    public TextFile() {

    }

    @Override
    public void killVirus() {
        System.out.println("name:"+name+" 文本文件杀毒~");
    }
}
