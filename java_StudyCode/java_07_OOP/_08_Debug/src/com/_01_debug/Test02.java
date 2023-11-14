package com._01_debug;

// debug时，遇到代码报异常

public class Test02 {
    public static void main(String[] args) {
        int[] arr = new int[5];

        for (int i = 0; i < arr.length + 10; i++) {// 数组访问越界
            arr[i] = 1;
            System.out.println(arr[i]);
        }
    }
}
