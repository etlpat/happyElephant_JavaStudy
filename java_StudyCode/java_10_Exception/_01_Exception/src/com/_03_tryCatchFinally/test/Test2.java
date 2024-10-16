package com._03_tryCatchFinally.test;

// 案例：编写程序，若用户输入的不是整数，使其反复输入，直到输入整数为止。

import java.util.Scanner;

public class Test2 {
    public static int func() {
        Scanner sc = new Scanner(System.in);
        int num;
        while (true) {
            try {
                num = Integer.parseInt(sc.next());// 当不出现NumberFormatException，返回该整数
                return num;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.println("请输入整数:");
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(func());
    }
}
