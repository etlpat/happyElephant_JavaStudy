package com.test;

/**
 * Account(账户类)
 * 要求：
 * (私有)属性包含：name(长度为2/3/4字符)、余额(必须>20)、密码(必须是6位)
 * 若属性赋值不满足，给出提示信息，并给默认值
 */

public class Account {
    private String name;
    private double balance;// 余额
    private String password;

    public Account(String name, double balance, String password) {
        // 构造器中建议用set方法为变量赋值(复用set对变量的限制语句)
        setName(name);
        setBalance(balance);
        setPassword(password);
    }

    public Account() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {// 长度为2/3/4字符
        if (name.length() < 2 || name.length() > 4) {
            System.out.println("姓名长度必须为2/3/4字符");
            this.name = "???";
            return;
        }
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {// 必须>20
        if (balance <= 20) {
            System.out.println("余额必须>20");
            this.balance = 21;
            return;
        }
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {// 必须是6位
        if (password.length() != 6) {
            System.out.println("密码必须是6位");
            this.password = "000000";
            return;
        }
        this.password = password;
    }

    public String info() {
        return "姓名=" + name + ", 余额=" + balance + ", 密码=" + password;
    }
}
