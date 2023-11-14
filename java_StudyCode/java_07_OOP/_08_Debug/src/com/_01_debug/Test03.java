package com._01_debug;

import java.util.Arrays;
import java.util.Random;

// debug过程中，查看java的源代码
// 法1：快捷键：shift+alt+F7 (强制进入方法，可进入java库方法查看源码)
// 法2：改设置，之后F7就能直接进入方法源代码
//  Settings -> Build,Execution,Deployment -> Debugger -> Stepping
//  把 java.* 和 javax.* 取消勾选(默认F7不进入这些类方法)
//
//
// 快捷键：
//  F7：进入方法（改设置后可进入java库方法查看源码）
//  shift+alt+F7：强制进入方法（可直接进入java库方法查看源码）
//  shift+F8：跳出方法


public class Test03 {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100) + 1;
        }

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
