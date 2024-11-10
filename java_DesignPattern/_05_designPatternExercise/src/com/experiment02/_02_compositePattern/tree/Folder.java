package com.experiment02._02_compositePattern.tree;

import java.util.ArrayList;

public class Folder extends AbstractFile {
    ArrayList<AbstractFile> list = new ArrayList<>();

    public Folder() {
    }

    public Folder(String name) {
        super(name);
    }


    @Override
    public void add(AbstractFile file) {
        list.add(file);
    }

    @Override
    public void remove(AbstractFile file) {
        list.remove(file);
    }

    // 先序遍历：显示本文件夹，并调用全部子树的display()方法
    @Override
    public void display() {
        System.out.println("文件夹:" + getName());

        for (AbstractFile file : list) {
            file.display();
        }
    }
}
