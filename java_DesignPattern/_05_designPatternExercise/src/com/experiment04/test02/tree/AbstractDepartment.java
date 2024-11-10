package com.experiment04.test02.tree;

import com.experiment04.test02.subject.Manager;

public abstract class AbstractDepartment {
    // 公司的静态管理员
    public static Manager manager = new Manager();

    private String name;

    public AbstractDepartment() {
    }

    public AbstractDepartment(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 添加子树
    public void add(AbstractDepartment department) {
        throw new RuntimeException("该类不可添加子树");
    }

    // 删除子树
    public void remove(AbstractDepartment department) {
        throw new RuntimeException("该类不可删除子树");
    }

    // 遍历全部
    public abstract void displayAll();

    // 遍历开会的结点
    public abstract void displayMeeting();
}
