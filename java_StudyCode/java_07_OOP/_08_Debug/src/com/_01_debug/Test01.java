package com._01_debug;

import java.util.Random;

// 快捷键：
//  F8：逐行调试
//  F9：进入debug/跳到下一个断点

public class Test01 {
    public static void main(String[] args) {
        System.out.println("进入程序...");
        Random rand = new Random();
        int[] arr = new int[10];
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100) + 1;
        }

        System.out.println("随机数组创建完毕...");

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        System.out.println(sum);
        System.out.println("程序退出...");
    }
}
