package com._02_staticMethod;

public class MyTools {
    public static void printArr(int[] arr) {
        System.out.print("{");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print(arr[arr.length - 1] + "}");
    }


    public static void printArr(int[][] arr) {
        System.out.print("{");
        for (int i = 0; i < arr.length - 1; i++) {
            printArr(arr[i]);
            System.out.print(", ");
        }
        printArr(arr[arr.length - 1]);
        System.out.print("}");
    }
}
