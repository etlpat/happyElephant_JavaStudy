package com.leetcode_2024_03_05.test1;

public class Solution {
    public int minimumPushes(String word) {
        return 8 * getAddNum(word.length() / 8) + (word.length() / 8 + 1) * (word.length() % 8);
    }

    public int getAddNum(int num) {
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum += i;
        }
        return sum;
    }
}
