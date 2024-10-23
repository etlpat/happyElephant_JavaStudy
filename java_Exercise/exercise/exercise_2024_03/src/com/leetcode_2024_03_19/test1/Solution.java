package com.leetcode_2024_03_19.test1;

class Solution {
    public int maximumScore(int[] nums, int k) {
        int maximumScore = nums[k];
        int minNum, numSum;
        int leftMinNum = nums[k], leftNumSum = 1;
        for (int leftIndex = k; leftIndex >= 0; leftIndex--, leftNumSum++) {
            // 记录包括k的左半部分
            if (nums[leftIndex] < leftMinNum) {
                leftMinNum = nums[leftIndex];
            }
            // 记录左半部分+右半部分
            minNum = leftMinNum;
            numSum = leftNumSum;
            for (int rightIndex = k; rightIndex < nums.length; rightIndex++, numSum++) {
                if (nums[rightIndex] < minNum) {
                    minNum = nums[rightIndex];
                }
                // 若leftIndex到rightIndex之间的“分数”比maximumScore大，更新maximumScore为当前最大的“分数”
                if (maximumScore < numSum * minNum) {
                    maximumScore = numSum * minNum;
                }
            }
        }
        return maximumScore;
    }
}