package com.leetcode_2024_03_04.test1;

//    TODO LCR 075. 数组的相对排序
//
//    arr2 中的元素各不相同
//    arr2 中的每个元素都出现在 arr1 中对 arr1 中的元素进行排序，
//    使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。
//    未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
//
//    示例：
//    输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//    输出：[2,2,2,1,4,3,3,9,6,7,19]
//
//    提示：
//    1 <= arr1.length, arr2.length <= 1000
//    0 <= arr1[i], arr2[i] <= 1000
//    arr2 中的元素 arr2[i] 各不相同
//    arr2 中的每个元素 arr2[i] 都出现在 arr1 中


public class test {
    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        Solution solution = new Solution();
        int[] arr3 = solution.relativeSortArray(arr1, arr2);// 2 2 2 1 4 3 3 9 6 7 19
        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + " ");
        }
        System.out.println();


        int[] arr4 = {26, 21, 11, 20, 50, 34, 1, 18};
        int[] arr5 = {21, 11, 26, 20};
        int[] arr6 = solution.relativeSortArray(arr4, arr5);// 21 11 26 20 1 18 34 50
        for (int i = 0; i < arr6.length; i++) {
            System.out.print(arr6[i] + " ");
        }
        System.out.println();


        int[] arr7 = {943, 790, 427, 722, 860, 550, 225, 846, 715, 320};
        int[] arr8 = {943, 715, 427, 790, 860, 722, 225, 320, 846, 550};
        int[] arr9 = solution.relativeSortArray(arr7, arr8);// 943 715 427 790 860 722 225 320 846 550
        for (int i = 0; i < arr9.length; i++) {
            System.out.print(arr9[i] + " ");
        }
    }
}
