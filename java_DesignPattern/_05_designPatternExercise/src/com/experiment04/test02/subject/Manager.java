package com.experiment04.test02.subject;

// 主题类 -- 管理员

import com.experiment04.test02.tree.AbstractDepartment;

import java.util.ArrayList;

public class Manager {
    // 包含所有员工的列表
    private ArrayList<String> allEmployeeName = new ArrayList<>();
    // 包含开会员工的列表
    private ArrayList<String> meetingEmployeeName = new ArrayList<>();
    // 公司
    private AbstractDepartment department;


    // 目标对象提醒全部观察者开会的方法
    public void notifyEmployeeMeeting() {
        if (department == null) {
            return;
        }

        // 先序遍历该公司，提醒会议名单中的员工开会
        department.displayMeeting();
    }


    // 列表的操作方法
    public void addAllEmployeeName(String employeeName) {
        allEmployeeName.add(employeeName);
    }

    public void removeAllEmployeeName(String employeeName) {
        allEmployeeName.remove(employeeName);
    }

    public void addMeetingEmployeeName(String employeeName) {
        meetingEmployeeName.add(employeeName);
    }

    public void removeMeetingEmployeeName(String employeeName) {
        meetingEmployeeName.remove(employeeName);
    }

    public boolean containsMeetingEmployeeName(String employeeName) {
        return meetingEmployeeName.contains(employeeName);
    }

    public void clearMeetingEmployeeName() {
        meetingEmployeeName.clear();
    }

    // 随机获取开会员工列表
    public void getRandomMeetingEmployeeName() {
        meetingEmployeeName.clear();
        for (String name : allEmployeeName) {
            if (Math.random() < 0.5) {
                meetingEmployeeName.add(name);
            }
        }
    }


    // get/set方法
    public AbstractDepartment getDepartment() {
        return department;
    }

    public void setDepartment(AbstractDepartment department) {
        this.department = department;
    }

    public ArrayList<String> getAllEmployeeName() {
        return allEmployeeName;
    }

    public void setAllEmployeeName(ArrayList<String> allEmployeeName) {
        this.allEmployeeName = allEmployeeName;
    }

    public ArrayList<String> getMeetingEmployeeName() {
        return meetingEmployeeName;
    }

    public void setMeetingEmployeeName(ArrayList<String> meetingEmployeeName) {
        this.meetingEmployeeName = meetingEmployeeName;
    }
}
