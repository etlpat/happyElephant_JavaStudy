package com._01_String.test;

// 案例2：
//  (1)创建一个验证码生成器，生成一串包含数字和英文字母的6位验证码
//  (2)创建一个验证码比较器，判断你出入的字符串，是否域验证码内容相等(不区分大小写)

import java.util.Random;
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        VerificationCode vc = new VerificationCode();
        System.out.println(vc.judge());
    }
}


class VerificationCode {
    private Random rand = new Random();
    private Scanner sc = new Scanner(System.in);


    public String createVerificationCode(int num) {
        String verificationCode = "";
        for (int i = 0; i < num; i++) {
            switch (rand.nextInt(3)) {
                case 0:// 数字
                    verificationCode += rand.nextInt(10);
                    break;
                case 1:// 大写字母
                    verificationCode += (char) ('A' + rand.nextInt(26));
                    break;
                case 2:// 小写字母
                    verificationCode += (char) ('a' + rand.nextInt(26));
                    break;
            }
        }
        return verificationCode;
    }


    public boolean judge() {
        String verificationCode = createVerificationCode(6);
        System.out.println("验证码是：" + verificationCode);
        System.out.print("请输入验证码：");
        return verificationCode.equalsIgnoreCase(sc.next());
    }
}