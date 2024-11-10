package com.experiment04.test02.tree;

public class Employee extends AbstractDepartment {
    public Employee() {
    }

    public Employee(String name) {
        super(name);
    }

    @Override
    public void displayAll() {
        // 输出员工信息
        System.out.println("--" + getName());
    }

    @Override
    public void displayMeeting() {
        // 若会议列表中包含该员工，则呼叫该员工开会
        if (manager.containsMeetingEmployeeName(getName())) {
            System.out.println("--" + getName());
        }
    }
}
