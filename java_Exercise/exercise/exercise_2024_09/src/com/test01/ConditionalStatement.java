package com.test01;

import java.util.Scanner;

public class ConditionalStatement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        // (1)if-else语句
        while (true) {
//            int num = scanner.nextInt();
            int num = 0;
            if (num > 0) {
                System.out.println("输入的是正数");
            } else if (num < 0) {
                System.out.println("输入的是负数");
            } else {
                System.out.println("输入的是零");
                break;
            }
        }


        // (2)while语句
        int i = 100;
        while (i > 0) {
            if (i == 30) {
                break;
            }
            if (i < 80 && i > 50) {
                i--;
                continue;
            }
            System.out.println(i--);
        }
        System.out.println(i);


        // (3)do-while语句
        do {
            System.out.println(++i);
        } while (i < 100);


        // (4)for循环语句
        for (int j = 0; j < 20; j++) {
            System.out.print(j + " ");
        }
        System.out.println();


        // (5)switch-case语句
        // case后可以是char、byte、short、int的常量表达式 / enum常量
        char choice = 'B';
        switch (choice) {
            case 'A':
                System.out.println("A");
//                break;
            case 'B':
                System.out.println("B");
//                break;
            case 'C':
                System.out.println("C");
//                break;
            default:
                System.out.println("...");
        }

    }
}
