package com._06_compositePattern.test01.tree;

// 抽象根节点类
//  （是根/叶结点的父类，提供二者所需的方法）

public abstract class AbstractFolder {
    private String name = "";
    public String level;// 文件/文件夹

    public AbstractFolder() {
    }

    public AbstractFolder(String name) {
        this.name = name;
    }


    // 添加子树
    public abstract void add(AbstractFolder folder);

    // 删除子树
    public abstract void remove(AbstractFolder folder);

    // 查找子树
    public abstract AbstractFolder getChile(int i);

    // 执行业务逻辑
    public abstract void operation();


    // 输出本结点信息
    public void printInfo() {
        System.out.println(level + ":\t" + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
