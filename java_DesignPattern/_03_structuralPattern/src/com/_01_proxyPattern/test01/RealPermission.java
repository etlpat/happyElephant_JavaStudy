package com._01_proxyPattern.test01;

// 真实主题类，实现抽象主题的全部方法

public class RealPermission extends AbstractPermission {
    @Override
    public void modifyInformation() {
        System.out.println("修改用户信息~~");
    }

    @Override
    public void viewPost() {
        System.out.println("查看帖子~~");
    }

    @Override
    public void sendPost() {
        System.out.println("发送帖子~~");
    }

    @Override
    public void modifyPost() {
        System.out.println("修改帖子~~");
    }
}
