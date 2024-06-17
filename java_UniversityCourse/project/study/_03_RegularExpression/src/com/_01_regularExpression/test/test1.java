package com._01_regularExpression.test;

// 案例：输入手机号/邮箱号/时间，判断格式是否正确

import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String regularPhone = "^(1\\d{10})|([1-9]\\d{6})$";// 手机号
        String regularEmail = "^[\\w-]+(\\.[\\w-]+)*@(163|126|qq)(\\.[\\w-]+)+$";//邮箱号
        String regularTime = "^(([0-1]?\\d)|20|21|22|23)[点:：][0-5]?\\d分?$";// 时间(xx:xx)

        // 手机号
        System.out.print("请输入手机号或电话号：");
        String phone = sc.next();
        if (phone.matches(regularPhone)) {
            System.out.println("格式正确");
        } else {
            System.out.println("格式错误");
        }

        // 电话号
        System.out.print("请输入邮箱号：");
        String email = sc.next();
        if (email.matches(regularEmail)) {
            System.out.println("格式正确");
        } else {
            System.out.println("格式错误");
        }

        // 时间
        while (true) {
            System.out.print("请输入时间：");
            String time = sc.next();
            if (time.matches(regularTime)) {
                System.out.println("格式正确");
            } else {
                System.out.println("格式错误");
            }
        }

    }
}
