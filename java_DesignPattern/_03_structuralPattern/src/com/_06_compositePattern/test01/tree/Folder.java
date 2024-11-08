package com._06_compositePattern.test01.tree;

// 文件夹（根节点）

import java.util.ArrayList;

public class Folder extends AbstractFolder {
    // AbstractFolder列表，用于存放子文件
    private ArrayList<AbstractFolder> folders = new ArrayList<AbstractFolder>();

    public Folder() {
        setLevel("文件夹");
    }

    public Folder(String name) {
        super(name);
        setLevel("文件夹");
    }

    @Override
    public void add(AbstractFolder folder) {
        folders.add(folder);
    }

    @Override
    public void remove(AbstractFolder folder) {
        folders.remove(folder);
    }

    @Override
    public AbstractFolder getChile(int i) {
        return folders.get(i);
    }


    // 根结点的operation()：遍历所有子树，执行子树的operation()方法。
    @Override
    public void operation() {
        // 输出自身信息
        printInfo();

        // 遍历folders列表，执行所有子树的operation()方法
        for (AbstractFolder folder : folders) {
            folder.operation();
        }
    }
}
