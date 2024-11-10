package com.experiment02._02_compositePattern.tree;

public abstract class AbstractFile {
    private String name;

    public AbstractFile() {
    }

    public AbstractFile(String name) {
        this.name = name;
    }

    public void add(AbstractFile file) {
        throw new RuntimeException("该类不可添加子树");
    }

    public void remove(AbstractFile file) {
        throw new RuntimeException("该类不可删除子树");
    }

    public abstract void display();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
