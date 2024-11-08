package com._01_proxyPattern.test01;

// 案例；论坛系统
//  在一个论坛中[已注册用户]和[游客]的权限不同,
//      [已注册的用户]拥有修改自己的注册信息、查看帖子、发帖、修改自己的帖子等权限;
//      而[游客]只能看到别人发的帖子,没有其他权限。
//  使用代理模式来设计该权限管理模块。
//  注意：可以用level属性表示是否为游客，0表示游客，1表示用户。

public class Test {
    public static void main(String[] args) {
        // 创建游客
        AbstractPermission visitor = new ProxyPermission(0);
        System.out.println("游客执行以下行为：");
        visitor.modifyInformation();
        visitor.viewPost();
        visitor.sendPost();
        visitor.modifyPost();
        System.out.println("=================");

        // 创建用户
        AbstractPermission user = new ProxyPermission(1);
        System.out.println("用户执行以下行为：");
        user.modifyInformation();
        user.viewPost();
        user.sendPost();
        user.modifyPost();
    }
}
