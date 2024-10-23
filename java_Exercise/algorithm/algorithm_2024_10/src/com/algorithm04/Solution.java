package com.algorithm04;

import java.util.LinkedList;

public class Solution {
    public int minOperations(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int num : nums) {
            list.add(num);
        }

        int count = 0;
        return reversal(list, count);
    }


    // 递归，对链表进行从头到尾的[去除首部全部的1，把剩下首部为0的三个反转，返回boolean]
    public static int reversal(LinkedList<Integer> list, int count) {
        // 若无元素/链表为空，返回true
        if (list == null || list.isEmpty()) {
            return count;
        }

        // (1)先去掉链首的全部1结点
        while (!list.isEmpty() && list.getFirst() != 0) {
            list.removeFirst();
        }

        // (2)看看还剩多少元素
        if (list.isEmpty()) {// 无元素，返回count
            return count;
        } else if (list.size() < 3) {// 少于3个元素，返回-1
            return -1;
        } else {// 否则，执行链表操作
            // 去除首个0，反转前两个
            list.removeFirst();
            list.set(0, getOppositeNumber(list.get(0)));
            list.set(1, getOppositeNumber(list.get(1)));
            count++;

            // 返回剩下的链表的boolean值
            return reversal(list, count);
        }
    }


    // 1变0，0变1
    public static int getOppositeNumber(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 0;
        } else {
            return -1;
        }
    }
}
