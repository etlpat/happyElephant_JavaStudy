package com._06_compositePattern.test01;

// 案例：
//  我们在访问一些管理系统时,经常可以看到文件系统的菜单。
//  一个菜单可以包含菜单项(文件File),也可以包含带有其他菜单项的菜单(文件夹Folder),
//  因此使用组合模式描述菜单就很恰当,我们的需求是针对一个菜单,打印出其包含的所有菜单以及菜单项的名称。

import com._06_compositePattern.test01.tree.File;
import com._06_compositePattern.test01.tree.Folder;

public class Test {
    public static void main(String[] args) {
        // (1)创建文件系统树
        Folder folder1 = new Folder("管理系统");
        Folder folder2 = new Folder("菜单管理");
        Folder folder3 = new Folder("权限配置");
        Folder folder4 = new Folder("角色管理");
        folder1.add(folder2);
        folder1.add(folder3);
        folder1.add(folder4);
        File file1 = new File("页面访问.exe");
        File file2 = new File("展开菜单.exe");
        File file3 = new File("编辑菜单.exe");
        File file4 = new File("删除菜单.exe");
        File file5 = new File("新增菜单.exe");
        folder2.add(file1);
        folder2.add(file2);
        folder2.add(file3);
        folder2.add(file4);
        folder2.add(file5);
        File file6 = new File("页面访问.exe");
        File file7 = new File("提交保存.exe");
        folder3.add(file6);
        folder3.add(file7);
        File file8 = new File("页面访问.exe");
        File file9 = new File("新增角色.exe");
        File file10 = new File("修改角色.exe");
        folder4.add(file8);
        folder4.add(file9);
        folder4.add(file10);


        // (2)调用根目录的operation()方法，递归执行全部子树的对应操作
        folder1.operation();
    }
}
