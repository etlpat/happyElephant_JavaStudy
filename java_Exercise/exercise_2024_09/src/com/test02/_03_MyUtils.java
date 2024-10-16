package com.test02;

public class _03_MyUtils {
    // static静态方法
    //  静态方法是类的方法，其中没有this对象。
    //  静态方法中只能调用static成员，不能调用非静态成员（它们在实例化后才存在）。

    public static void printArr(int[] arr) {
        System.out.print("{");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[arr.length - 1] + "}");
    }
}
