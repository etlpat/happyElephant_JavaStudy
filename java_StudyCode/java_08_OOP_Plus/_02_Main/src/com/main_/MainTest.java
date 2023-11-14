package com.main_;

// 要求：在idea中为main方法的args数组传参，并打印数组内容
// 操作：Run按键->Edit->设置Program arguments（项目参数）

public class MainTest {
    public static void main(String[] args) {
        MyTools.printArr(args);
    }
}


class MyTools {
    public static void printArr(String[] arr) {
        if (arr.length == 0) {
            System.out.println("数组为空");
            return;
        }
        System.out.print("{");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[arr.length - 1] + "}");
    }
}