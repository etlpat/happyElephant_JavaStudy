package com._03_tryCatchFinally.test;

import java.util.Scanner;

public class Test3 {
    public static int myDivide() {
        Scanner scanner = new Scanner(System.in);
        int c = 0;
        try {
            System.out.print("请输入第一个数字：");
            int a = Integer.parseInt(scanner.next());
            System.out.print("请输入第二个数字：");
            int b = Integer.parseInt(scanner.next());
            c = a / b;
        } catch (NumberFormatException e) {
            System.out.println(e);
        } catch (ArithmeticException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(myDivide());
    }
}
