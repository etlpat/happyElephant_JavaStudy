package com._01_String.test;

// 案例：已知密码"123456"
//      给用户三次输入机会，看看能否成功输入密码

import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Passwd p = new Passwd();
        p.judge();
    }
}

class Passwd {
    private String passwd = "123456";

    public Passwd() {
    }

    public Passwd(String passwd) {
        this.passwd = passwd;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public boolean judge() {
        Scanner sc = new Scanner(System.in);
        int count = 3;
        boolean flag = false;
        while (count != 0) {
            System.out.print("您还有" + count + "次输入机会，请输入密码：");
            if (passwd.equals(sc.next())) {
                flag = true;
                break;
            }
            System.out.println("密码错误！");
            count--;
        }
        if (flag) {
            System.out.println("密码正确，开锁成功！");
            return true;
        }
        System.out.println("次数耗尽，无法开锁");
        return false;
    }
}
