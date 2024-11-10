package com.experiment04.test02;

// 组合+观察者

import com.experiment04.test02.subject.Manager;
import com.experiment04.test02.tree.AbstractDepartment;
import com.experiment04.test02.tree.Department;
import com.experiment04.test02.tree.Employee;

public class Client {
    public static void main(String[] args) {
        // (1)创建公司
        AbstractDepartment root = new Department("莱茵公司");
        Manager manager = root.manager;
        manager.setDepartment(root);
        AbstractDepartment department1 = new Department("结构科室");
        AbstractDepartment department2 = new Department("研发科室");
        AbstractDepartment department3 = new Department("防卫科室");
        root.add(department1);
        root.add(department2);
        root.add(department3);
        department1.add(new Employee("张三"));
        department1.add(new Employee("李四"));
        department1.add(new Employee("王五"));
        department2.add(new Employee("赵六"));
        department2.add(new Employee("孙七"));
        department3.add(new Employee("周八"));
        department3.add(new Employee("武九"));
        department3.add(new Employee("钱十"));


        // (2)先序遍历公司全部结点
        root.displayAll();
        System.out.println("==========================");


        // (3)随机生成参加会议的成员列表
        manager.getRandomMeetingEmployeeName();
        System.out.print("随机开会员工列表：");
        for (String name : manager.getMeetingEmployeeName()) {
            System.out.print(name + "|");
        }
        System.out.println();


        // (4)管理员（主题类）开会，每一个观察者接收到通知（先序遍历树，获取要开会的成员）
        System.out.println("要开会的成员如下：");
        manager.notifyEmployeeMeeting();
    }
}
