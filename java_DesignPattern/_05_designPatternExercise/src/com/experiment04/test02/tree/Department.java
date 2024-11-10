package com.experiment04.test02.tree;

import java.util.ArrayList;

public class Department extends AbstractDepartment {
    private ArrayList<AbstractDepartment> departments = new ArrayList<>();

    public Department() {
    }

    public Department(String name) {
        super(name);
    }

    @Override
    public void add(AbstractDepartment department) {
        departments.add(department);
        // 若存入员工，则将员工姓名添加到管理员的列表中
        if (department instanceof Employee) {
            manager.addAllEmployeeName(department.getName());
        }
    }

    @Override
    public void remove(AbstractDepartment department) {
        departments.remove(department);
        // 若删除员工，则将该员工姓名从管理员列表中删除
        if (department instanceof Employee) {
            manager.removeAllEmployeeName(department.getName());
        }
    }

    @Override
    public void displayAll() {
        System.out.println(getName() + ":");
        // 遍历全部子树，调用display方法
        for (AbstractDepartment department : departments) {
            department.displayAll();
        }
    }

    @Override
    public void displayMeeting() {
        System.out.println(getName() + ":");
        // 遍历全部子树，调用display方法
        for (AbstractDepartment department : departments) {
            department.displayMeeting();
        }
    }
}
