package com._12_用户管理;

// 用户管理
//
//  todo (1)用户表 user
//  MySQL的用户信息，存放在数据库mysql的user表中。
//  查找用户信息：SELECT * FROM mysql.user;
//  【user表中的字段说明】：
//      ①host：允许用户登录的“位置”。
//          注意：localhost表示该用户只允许在本机登录，也可以指定ip地址，如：192.168.1.100
//              通配符“%”，用于表示任何主机
//      ②user：用户名。
//      ③authentication_string：被password()函数加密后的密码。
//
//
//
//  todo (2)语法
//  查看所有用户：SELECT * FROM mysql.user;
//  创建用户：CREATE USER '用户名'@'允许登录位置' [IDENTIFIED BY '密码'];
//  删除用户：DROP USER '用户名'@'允许登录位置';
//
//  修改用户密码：SET PASSWORD FOR '用户名'@'允许登录位置' = password('密码');
//  修改自己的密码：SET PASSWORD = password('密码');
//
//
//
//  todo (3)注意事项
//  ①MySQL不存储用户的原密码，而是存储password()函数加密后的密码，这样会增加安全性。
//  ②若CREATE创建用户时没有用IDENTIFIED设置密码，则该用户默认没有密码，可以直接登录。
//  ③若CREATE创建用户时没有指定host，则默认是%
//    若想要删除的用户的host为%，则可以不指定ip地址，直接通过用户名删除
//  ③不同权限的用户登录DBMS后，允许执行的操作也不同。
//      新创建的用户，默认不含有任何权限。
//
//


public class _01_用户管理 {
}
