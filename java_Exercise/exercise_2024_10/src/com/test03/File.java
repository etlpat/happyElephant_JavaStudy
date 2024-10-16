package com.test03;

import java.util.LinkedList;

public class File extends Document {
    public LinkedList fileList = new LinkedList<Document>();

    public File(String name) {
        super(name);
    }

    public File() {

    }

    @Override
    public void killVirus() {
        System.out.println("name:" + name + " 文件夹正在杀毒->");
        for (Object obj : fileList) {
            if (obj != null) {
                Document doc = (Document) obj;
                doc.killVirus();
            }
        }
        System.out.println("name:" + name + " 文件夹杀毒结束<-");
    }
}
