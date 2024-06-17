package com.leetcode_2024_03_04.test1;

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // （1）将arr1中与arr2相同的元素换到前面，不同的换到后面
        int left = 0, right = arr1.length - 1;
        int tmp;
        while (left <= right) {
            while (left < arr1.length && isNumInArr(arr1[left], arr2)) {
                left++;// 将left置为首个与arr2不相同的元素
            }
            while (right >= 0 && !isNumInArr(arr1[right], arr2)) {
                right--;// 将right置为末个arr2中相同的元素
            }
            // 交换left和right的元素
            if (left > right) {
                break;
            }
            tmp = arr1[left];
            arr1[left] = arr1[right];
            arr1[right] = tmp;
            left++;
            right--;
        }
        // 最终left变为右边区域的首个元素，right变为左边区域的末尾元素

        // （2）排序左半区域
        int leftIndex = 0;
        for (int i = 0; i < arr2.length; i++) {
            while (leftIndex < arr1.length && arr1[leftIndex] == arr2[i]) {
                leftIndex++;
            }
            if (leftIndex >= arr1.length) {
                break;
            }
            // 将arr1中与arr2[i]相同的元素换到前面
            for (int j = leftIndex + 1; j <= right; j++) {
                if (arr1[j] == arr2[i]) {
                    arr1[j] = arr1[leftIndex];
                    arr1[leftIndex] = arr2[i];
                    leftIndex++;
                }
            }
        }

        // （3）排序右半区域
        for (int i = left; i < arr1.length - 1; i++) {
            for (int j = arr1.length - 2; j >= i; j--) {
                if (arr1[j] > arr1[j + 1]) {
                    tmp = arr1[j];
                    arr1[j] = arr1[j + 1];
                    arr1[j + 1] = tmp;
                }
            }
        }
        return arr1;
    }

    // 判断num是否是arr中的元素
    public boolean isNumInArr(int num, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return true;
            }
        }
        return false;
    }
}
