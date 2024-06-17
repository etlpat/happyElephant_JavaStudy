package com.leetcode_2024_03_05.test2_$$$;

import java.util.Arrays;

class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        int minus1 = 0;
        while (minus1 < nums1.length && nums1[minus1] < 0) {
            minus1++;// nums1负数的下一个
        }
        int plus1 = minus1;
        while (plus1 < nums1.length && nums1[plus1] == 0) {
            plus1++;// nums1正数的第一个
        }
        int minus2 = 0;
        while (minus2 < nums2.length && nums2[minus2] < 0) {
            minus2++;// nums2负数的下一个
        }
        int plus2 = minus2;
        while (plus2 < nums2.length && nums2[plus2] == 0) {
            plus2++;// nums2正数的第一个
        }
        int minusNum = minus1 * (nums2.length - plus2) + minus2 * (nums1.length - plus1);// 总共负数个数
        int plusNum = minus1 * minus2 + (nums1.length - plus1) * (nums2.length - plus2);// 总共正数个数
        int zeroNum = nums1.length * nums2.length - minusNum - plusNum;// 总共0的个数
        if (minusNum >= k) {// 若结果为负数
            if (minus2 * (nums1.length - plus1) == 0) {
                int[] nums1Minus = new int[minus1];
                for (int i = 0; i < nums1Minus.length; i++) {
                    nums1Minus[i] = -nums1[minus1 - 1 - i];
                }
                return -getMaxNum(nums1Minus, nums2, k)[(int) k - 1];
            } else if (minus1 * (nums2.length - plus2) == 0) {
                int[] nums2Minus = new int[minus2];
                for (int i = 0; i < nums2Minus.length; i++) {
                    nums2Minus[i] = -nums2[minus2 - 1 - i];
                }
                return -getMaxNum(nums2Minus, nums1, k)[(int) k - 1];
            } else {
                int[] nums1Minus = new int[minus1];
                for (int i = 0; i < nums1Minus.length; i++) {
                    nums1Minus[i] = -nums1[minus1 - 1 - i];
                }
                int[] nums2Minus = new int[minus2];
                for (int i = 0; i < nums2Minus.length; i++) {
                    nums2Minus[i] = -nums2[minus2 - 1 - i];
                }
                int[] nums1Plus = Arrays.copyOfRange(nums1, plus1, nums1.length);
                int[] nums2Plus = Arrays.copyOfRange(nums2, plus2, nums2.length);
                long[] arr1 = getMaxNum(nums1Minus, nums2Plus, k);
                long[] arr2 = getMaxNum(nums2Minus, nums1Plus, k);
                int index1 = 0, index2 = 0;
                long max = 0;
                while (k != 0 && index1 < arr1.length && index2 < arr2.length) {
                    max = arr1[index1] >= arr2[index2] ? arr1[index1++] : arr2[index2++];
                    k--;
                }
                if (k != 0) {
                    if (index1 == arr1.length) {
                        max = arr2[index2 + (int) k - 1];
                    } else if (index2 == arr2.length) {
                        max = arr1[index1 + (int) k - 1];
                    }
                }
                return -max;
            }
        } else if (minusNum + zeroNum >= k) {// 若结果为0
            return 0;
        } else {// 若结果为正数
            k = k - minusNum - zeroNum;
            if (minus1 * minus2 == 0) {
                int[] nums1Plus = Arrays.copyOfRange(nums1, plus1, nums1.length);
                int[] nums2Plus = Arrays.copyOfRange(nums2, plus2, nums2.length);
                return getMinNum(nums1Plus, nums2Plus, k)[(int) k - 1];
            } else if ((nums1.length - plus1) * (nums2.length - plus2) == 0) {
                int[] nums1Minus = new int[minus1];
                for (int i = 0; i < nums1Minus.length; i++) {
                    nums1Minus[i] = -nums1[minus1 - 1 - i];
                }
                int[] nums2Minus = new int[minus2];
                for (int i = 0; i < nums2Minus.length; i++) {
                    nums2Minus[i] = -nums2[minus2 - 1 - i];
                }
                return getMinNum(nums1Minus, nums2Minus, k)[(int) k - 1];
            } else {
                int[] nums1Minus = new int[minus1];
                for (int i = 0; i < nums1Minus.length; i++) {
                    nums1Minus[i] = -nums1[minus1 - 1 - i];
                }
                int[] nums2Minus = new int[minus2];
                for (int i = 0; i < nums2Minus.length; i++) {
                    nums2Minus[i] = -nums2[minus2 - 1 - i];
                }
                int[] nums1Plus = Arrays.copyOfRange(nums1, plus1, nums1.length);
                int[] nums2Plus = Arrays.copyOfRange(nums2, plus2, nums2.length);
                long[] arr1 = getMinNum(nums1Minus, nums2Minus, k);
                long[] arr2 = getMinNum(nums1Plus, nums2Plus, k);
                int index1 = 0, index2 = 0;
                long min = 0;
                while (k != 0 && index1 < arr1.length && index2 < arr2.length) {
                    min = arr1[index1] <= arr2[index2] ? arr1[index1++] : arr2[index2++];
                    k--;
                }
                if (k != 0) {
                    if (index1 == arr1.length) {
                        min = arr2[index2 + (int) k - 1];
                    } else if (index2 == arr2.length) {
                        min = arr1[index1 + (int) k - 1];
                    }
                }
                return min;
            }
        }
    }


    // 方法：传入两个递增的正数数组，返回两数组元素乘积的递减最大数组
    public long[] getMaxNum(int[] arr1, int[] arr2, long k) {
        ElementLinkedList elementLinkedList = new ElementLinkedList();
        long[] longArr = new long[(int) k];// 存放最大乘积的数组
        int[][] alreadyStorage = new int[2 * (int) k + 1][2];// 记录已经存入过链表的数据
        // 将最大的乘积添加到链表中
        elementLinkedList.add(arr1.length - 1, arr2.length - 1, (long) arr1[arr1.length - 1] * arr2[arr2.length - 1]);
        alreadyStorage[0][0] = arr1.length - 1;
        alreadyStorage[0][1] = arr2.length - 1;
        int longArrIndex = 0, alreadyStorageIndex = 1;
        int x, y;
        ElementLinkedList.Element maxElement;

        while (longArrIndex <= k - 1 && !elementLinkedList.isEmpty()) {
            // 获取并删除链表中最大的乘积
            maxElement = elementLinkedList.getMaxElement();
            x = maxElement.nums1Index;
            y = maxElement.nums2Index;
            longArr[longArrIndex] = maxElement.value;
            longArrIndex++;

            // 当下标未越界且元素未添加过，将两个次大的乘积添加入链表中
            if (x != 0 && !isInAlreadyStorage(alreadyStorage, alreadyStorageIndex, x - 1, y)) {
                elementLinkedList.add(x - 1, y, arr1[x - 1] * arr2[y]);
                alreadyStorage[alreadyStorageIndex][0] = x - 1;// 记录该数据为已经存储
                alreadyStorage[alreadyStorageIndex][1] = y;
                alreadyStorageIndex++;
            }
            if (y != 0 && !isInAlreadyStorage(alreadyStorage, alreadyStorageIndex, x, y - 1)) {
                elementLinkedList.add(x, y - 1, arr1[x] * arr2[y - 1]);
                alreadyStorage[alreadyStorageIndex][0] = x;
                alreadyStorage[alreadyStorageIndex][1] = y - 1;
                alreadyStorageIndex++;
            }
        }
        if (longArrIndex < k) {
            longArr = Arrays.copyOfRange(longArr, 0, longArrIndex);
        }
        return longArr;
    }


    // 方法：传入两个递增的正数数组，返回两数组元素乘积的递增最小数组
    public long[] getMinNum(int[] arr1, int[] arr2, long k) {
        ElementLinkedList elementLinkedList = new ElementLinkedList();
        long[] longArr = new long[(int) k];
        int[][] alreadyStorage = new int[2 * (int) k + 1][2];
        elementLinkedList.add(0, 0, (long) arr1[0] * arr2[0]);
        alreadyStorage[0][0] = 0;
        alreadyStorage[0][1] = 0;
        int longArrIndex = 0, alreadyStorageIndex = 1;
        int x, y;
        ElementLinkedList.Element minElement;
        while (longArrIndex <= k - 1 && !elementLinkedList.isEmpty()) {
            minElement = elementLinkedList.getMinElement();
            x = minElement.nums1Index;
            y = minElement.nums2Index;
            longArr[longArrIndex] = minElement.value;
            longArrIndex++;
            if (x != arr1.length - 1 && !isInAlreadyStorage(alreadyStorage, alreadyStorageIndex, x + 1, y)) {
                elementLinkedList.add(x + 1, y, arr1[x + 1] * arr2[y]);
                alreadyStorage[alreadyStorageIndex][0] = x + 1;
                alreadyStorage[alreadyStorageIndex][1] = y;
                alreadyStorageIndex++;
            }
            if (y != arr2.length - 1 && !isInAlreadyStorage(alreadyStorage, alreadyStorageIndex, x, y + 1)) {
                elementLinkedList.add(x, y + 1, arr1[x] * arr2[y + 1]);
                alreadyStorage[alreadyStorageIndex][0] = x;
                alreadyStorage[alreadyStorageIndex][1] = y + 1;
                alreadyStorageIndex++;
            }
        }
        if (longArrIndex < k) {
            longArr = Arrays.copyOfRange(longArr, 0, longArrIndex);
        }
        return longArr;
    }


    // 方法：检查(x, y)是否在二维数组中
    public boolean isInAlreadyStorage(int[][] alreadyStorage, int index, int x, int y) {
        for (int i = 0; i < index; i++) {
            if (alreadyStorage[i][0] == x && alreadyStorage[i][1] == y) {
                return true;
            }
        }
        return false;
    }
}


// 存放两数乘积的链表
class ElementLinkedList {
    public Element head = new Element();

    // Element类，记录两数乘积的值，以及两数在各自数组中的下标
    public static class Element {
        int nums1Index;
        int nums2Index;
        long value;
        Element next = null;

        public Element() {
        }

        public Element(int nums1Index, int nums2Index, long value) {
            this.nums1Index = nums1Index;
            this.nums2Index = nums2Index;
            this.value = value;
        }

        public Element(int nums1Index, int nums2Index, long value, Element next) {
            this(nums1Index, nums2Index, value);
            this.next = next;
        }
    }

    public boolean isEmpty() {
        return head.next == null;
    }

    // 头插法为链表添加元素
    public void add(int nums1Index, int nums2Index, long value) {
        Element tmp = new Element(nums1Index, nums2Index, value, head.next);
        head.next = tmp;
    }

    // 获取并删除链表中最大的元素
    public Element getMaxElement() {
        if (head.next == null) {
            return null;
        }
        Element beforeMaxNum = head;
        Element tmp = head.next;
        while (tmp.next != null) {// 遍历寻找最大的value
            if (tmp.next.value > beforeMaxNum.next.value) {
                beforeMaxNum = tmp;
            }
            tmp = tmp.next;
        }
        tmp = beforeMaxNum.next;
        beforeMaxNum.next = tmp.next;
        return tmp;
    }

    // 获取并删除链表中最小的元素
    public Element getMinElement() {
        if (head.next == null) {
            return null;
        }
        Element beforeMaxNum = head;
        Element tmp = head.next;
        while (tmp.next != null) {// 遍历寻找最大的value
            if (tmp.next.value < beforeMaxNum.next.value) {
                beforeMaxNum = tmp;
            }
            tmp = tmp.next;
        }
        tmp = beforeMaxNum.next;
        beforeMaxNum.next = tmp.next;
        return tmp;
    }
}