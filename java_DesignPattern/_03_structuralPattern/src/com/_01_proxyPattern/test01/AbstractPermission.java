package com._01_proxyPattern.test01;

// 抽象主题类
// （声明了用户的全部方法）

public abstract class AbstractPermission {

    // 修改注册信息
    public abstract void modifyInformation();

    // 查看帖子
    public abstract void viewPost();

    // 发送帖子
    public abstract void sendPost();

    // 修改帖子
    public abstract void modifyPost();
}
