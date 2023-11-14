package com.test;

public class AccountTest {
    public static void main(String[] args) {
        Account a = new Account("X", -100, "1145");
//        姓名长度必须为2/3/4字符
//        余额必须>20
//        密码必须是6位

        System.out.println(a.info());// 姓名=???, 余额=21.0, 密码=000000

        a.setName("张三");
        a.setBalance(500);
        a.setPassword("123456");
        System.out.println(a.info());// 姓名=张三, 余额=500.0, 密码=123456
    }
}
