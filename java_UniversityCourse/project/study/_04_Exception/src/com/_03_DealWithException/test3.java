package com._03_DealWithException;

// 案例：让用户输入double类型商品价格
//      用异常处理保证用户输入的是数字

import java.util.InputMismatchException;
import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        boolean flag = true;
        double price = 0;
        while (true) {
            try {
                flag = true;
                price = getMoney();
            } catch (InputMismatchException e) {// 若输入的不是数字
                flag = false;
                System.out.println("只能输入整数或小数，您的输入非法");
            } catch (Exception e) {// 若是其它异常
                flag = false;
                e.printStackTrace();
            } finally {
                if (flag) {
                    System.out.println("输入成功");
                    break;
                }
            }
        }
        System.out.println("最终价格为：" + price);
    }

    public static double getMoney() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入价格：");
        return sc.nextDouble();
    }
}

