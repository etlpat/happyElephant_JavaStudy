package com.test02;

public class _03_Test {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7, 9};
        int[] arr2 = {2, 4, 6, 8, 10};

        // 通过类名直接调用静态方法
        _03_MyUtils.printArr(arr1);
        _03_MyUtils.printArr(arr2);
    }
}
