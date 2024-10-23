package com.test01;

import java.sql.SQLOutput;
import java.util.Scanner;

public class SimpleIO {
    public static void main(String[] args) {
        // (1)输入
        // 使用Scanner文本扫描器对象，读入标准输入流
        Scanner scanner = new Scanner(System.in);// 创建文本扫描器对象，参数传入标准输入流对象
//        String str = scanner.next();// 从键盘输入字符串
//        System.out.println(str);

        // 输入一行
        System.out.println(scanner.nextLine());

        // 输入一个单词（空格/回车截至）
        System.out.println(scanner.next());

        // 输入整型
        System.out.println(scanner.nextInt());


        // (2)输出
        System.out.print(1234);// 输出（不换行）
        System.out.println(1234);// 输出并换行

        // 格式化输出
        String s = "AAA";
        int num = 114;
        System.out.printf("hello, %s! you are %d", s, num);


    }
}
